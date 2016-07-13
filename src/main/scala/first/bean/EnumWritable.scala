package com.hypers.hadoop.io

import java.io.DataInput
import java.io.DataOutput
import java.io.IOException
import java.util.List

import org.apache.commons.lang.builder.CompareToBuilder
import org.apache.commons.lang.builder.EqualsBuilder
import org.apache.commons.lang.builder.HashCodeBuilder
import org.apache.hadoop.io.WritableComparable
import com.hypers.commons.types.TypeStore
import com.hypers.commons.util.EnumList

class EnumListWritable[E <: Enum[E]] extends WritableComparable[EnumListWritable[E]] {
  private var entityClass: Class[E] = null
  private val cacheClz: String = null
  private[io] val list: util.List[E] = new EnumList[E]

  def add(e: E) {
    list.add(e)
    this.entityClass = e.getClass.asInstanceOf[Class[E]]
  }

  def get: util.List[E] = {
    return list
  }

  @throws[IOException]
  def write(out: DataOutput) {
    out.writeUTF(this.entityClass.getName)
    out.writeInt(list.size)
    import scala.collection.JavaConversions._
    for (element <- list) {
      out.writeInt(element.ordinal)
    }
  }

  @throws[IOException]
  def readFields(in: DataInput) {
    clear
    try {
      val clz: String = in.readUTF
      if (this.entityClass == null) {
        this.entityClass = Class.forName(clz).asInstanceOf[Class[E]]
      }
      val size: Int = in.readInt
      var i: Int = 0
      while (i < size) {
        {
          list.add(TypeStore.get(this.entityClass, in.readInt))
        }
        ({
          i += 1; i - 1
        })
      }
    }
    catch {
      case e: Exception => {
        e.printStackTrace
      }
    }
  }

  def compareTo(o: EnumListWritable[E]): Int = {
    var flag: Int = -1
    if (o != null) {
      val l1: util.List[E] = this.get
      val l2: util.List[E] = o.get
      if (l1.size == l2.size) {
        val builder: CompareToBuilder = new CompareToBuilder
        var i: Int = 0
        while (i < this.get.size) {
          {
            builder.append(this.get.get(i).ordinal, o.get.get(i).ordinal)
          }
          ({
            i += 1; i - 1
          })
        }
        flag = builder.toComparison
      }
      else {
        flag = if ((l1.size > l2.size)) 1
        else -1
      }
    }
    return flag
  }

  def clear {
    this.list.clear
  }

  override def toString: String = {
    return this.list.toString
  }

  override def hashCode: Int = {
    val builder: HashCodeBuilder = new HashCodeBuilder
    import scala.collection.JavaConversions._
    for (e <- list) {
      builder.append(e.ordinal).toHashCode
    }
    return builder.toHashCode
  }

  override def equals(obj: Any): Boolean = {
    val o: EnumListWritable[_ <: Enum[E]] = obj.asInstanceOf[EnumListWritable[_ <: Enum[E]]]
    return new EqualsBuilder().append(this.list, o.list).isEquals
  }
}
