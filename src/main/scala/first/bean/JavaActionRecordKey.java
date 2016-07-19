package first.bean;

import org.apache.commons.lang.builder.CompareToBuilder;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class JavaActionRecordKey implements WritableComparable<JavaActionRecordKey> {

	Text actionId = new Text();

	Text date = new Text();

	Text hour = new Text();

	public String getActionId() {
		return actionId.toString();
	}

	public void setActionId(String actionId) {
		this.actionId.set(actionId);
	}

	public void setDate(String date) {
		this.date.set(date);
	}

	public String getDate() {
		return date.toString();
	}

	public String getHour() {
		return hour.toString();
	}

	public void setHour(String hour) {
		this.hour.set(hour);
	}

	public void write(DataOutput out) throws IOException {
		actionId.write(out);
		hour.write(out);
		date.write(out);
	}

	public void readFields(DataInput in) throws IOException {
		actionId.readFields(in);
		hour.readFields(in);
		date.readFields(in);
	}

	public int compareTo(JavaActionRecordKey o) {
		int flag = -1;
		if (o != null) {
			flag = new CompareToBuilder().append(this.actionId, o.actionId)
					.append(this.date, o.date).append(this.hour, o.hour)
					.toComparison();
		}
		return flag;
	}

	public void clear() {
		this.actionId.clear();
		this.date.clear();
		this.hour.clear();
	}

    @Override
    public String toString() {
        return "ActionRecordKey{" +
                "actionId=" + actionId +
                ", date=" + date +
                ", hour=" + hour +
                '}';
    }
}
