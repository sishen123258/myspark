package first.bean

import java.io.{DataInput, DataOutput}

import org.apache.commons.lang.builder.CompareToBuilder
import org.apache.hadoop.io.{Text, WritableComparable}

/**
  * Created by Tong on 2016/7/14.
  */
class ActionRecordKey extends WritableComparable[ActionRecordKey]{

  //private[conversion]
  val actionId: Text = new Text
  val date: Text = new Text
  val hour: Text = new Text

  def getActionId: String = {
    return actionId.toString
  }

  def setActionId(actionId: String) {
    this.actionId.set(actionId)
  }

  def setDate(date: String) {
    this.date.set(date)
  }

  def getDate: String = {
    return date.toString
  }

  def getHour: String = {
    return hour.toString
  }

  def setHour(hour: String) {
    this.hour.set(hour)
  }

  override def compareTo(o: ActionRecordKey): Int = {
    var flag: Int = -1
    if (o != null) {
      val builder: CompareToBuilder = new CompareToBuilder
      builder.append(this.actionId, o.actionId).append(this.date, o.date).append(this.hour, o.hour)
      flag = builder.toComparison
    }
    return flag
  }

  override def write(out: DataOutput): Unit = {
    actionId.write(out)
    hour.write(out)
    date.write(out)
  }

  override def readFields(in: DataInput): Unit = {
    actionId.readFields(in)
    hour.readFields(in)
    date.readFields(in)

  }
}
