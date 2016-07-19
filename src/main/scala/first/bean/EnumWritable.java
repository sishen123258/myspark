package first.bean;

import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class EnumWritable<E extends Enum<E>> implements
		WritableComparable<EnumWritable<E>> {

	private byte storage;

	private Class<E> entityClass;

	public EnumWritable() {
		storage = 0;
	}

	public EnumWritable(Enum<E> value) {
		set(value);
	}

	public <T extends Enum<E>> E get() {
		return TypeStore.get(this.entityClass, storage);
	}

	@SuppressWarnings("unchecked")
	public void set(Enum<E> e) {
		this.storage = (byte) e.ordinal();
		this.entityClass = (Class<E>) e.getClass();
	}

	@SuppressWarnings("unchecked")
	public void readFields(DataInput in) throws IOException {
		this.storage = in.readByte();

		String clz = in.readUTF();

		// 在 mapper 与 reducer 中, key 与 value 始终是同一个引用, 这里只做一次 forName 即可
		if (entityClass == null) {
			try {
				this.entityClass = (Class<E>) Class.forName(clz);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	}

	public void write(DataOutput out) throws IOException {
		out.write(storage);
		out.writeUTF(this.entityClass.getName());
	}

	@Override
	public String toString() {
		return Integer.toString(storage);
	}

	public String name() {
		return this.get().name();
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof EnumWritable)) {
			return super.equals(obj);
		}
		EnumWritable<E> that = (EnumWritable<E>) obj;
		return this.storage == that.storage;
	}

	@Override
	public int hashCode() {
		return storage;
	}

	public void clear() {
		this.storage = 0;
	}

	@Override
	public int compareTo(EnumWritable<E> o) {
		if (o.storage == this.storage) {
			return 0;
		} else {
			return o.storage > this.storage ? -1 : 1;
		}
	}

}
