package first.bean;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.math.BigDecimal;

public class ActionRecordValue implements Writable {

	EnumWritable<Events> event = new EnumWritable<>();

	EnumWritable<ATRBModel> atrb = new EnumWritable<>();

	Text sessionId = new Text();

	Text user = new Text();

	Text account = new Text();

	Text campaign = new Text();

	Text adgroup = new Text();

	Text ad = new Text();

	Text country = new Text();

	Text province = new Text();

	Text city = new Text();

	Text htp1 = new Text();

	Text htp2 = new Text();

	Text htp3 = new Text();

	Text platform = new Text();

	Text device = new Text();

	Text actParams = new Text();

	LongWritable time = new LongWritable(0);

	LongWritable actionTime = new LongWritable(0);

	BigDecimalWritable weightLinear = new BigDecimalWritable(BigDecimal.ZERO);

	BigDecimalWritable weightRanking = new BigDecimalWritable(BigDecimal.ZERO);

	BigDecimalWritable weightTimeDecay = new BigDecimalWritable(BigDecimal.ZERO);

	/**
	 * temp used
	 */
	@Deprecated
	String ip;

	Writable[] data = { event, atrb, sessionId, user, account, campaign,
			adgroup, ad, country, province, city, htp1, htp2, htp3, platform,
			device, actParams, time, actionTime, weightLinear, weightRanking,
			weightTimeDecay };

	public void setWeight(ATRBModel attr, BigDecimal weight) {
		switch (attr) {
		case LINEAR:
			weightLinear.set(weight);
			break;
		case RANKING:
			weightRanking.set(weight);
			break;
		case TIME_DECAY:
			weightTimeDecay.set(weight);
			break;
		default:
			break;
		}
	}

	public BigDecimal getWeight(ATRBModel atrb) {
		switch (atrb) {
		case LINEAR:
			return weightLinear.getBigDecimal();
		case RANKING:
			return weightRanking.getBigDecimal();
		case TIME_DECAY:
			return weightTimeDecay.getBigDecimal();
		default:
			return BigDecimal.ONE;
		}
	}

	@Deprecated
	public String getIp() {
		return ip;
	}

	@Deprecated
	public void setIp(String ip) {
		this.ip = ip;
	}

	public void setEvent(Events event) {
		this.event.set(event);
	}

	public Events getEvent() {
		return event.get();
	}

	public void setAtrb(ATRBModel atrb) {
		this.atrb.set(atrb);
	}

	public ATRBModel getAtrb() {
		return atrb.get();
	}

	public void setSessionId(String sessionId) {
		this.sessionId.set(sessionId);
	}

	public String getSessionId() {
		return sessionId.toString();
	}

	public String getCampaign() {
		return campaign.toString();
	}

	public void setUser(String user) {
		this.user.set(user);
	}

	public String getUser() {
		return user.toString();
	}

	public String getAccount() {
		return account.toString();
	}

	public void setAccount(String account) {
		this.account.set(account);
	}

	public void setCampaign(String campaignId) {
		this.campaign.set(campaignId);
	}

	public String getAdgroup() {
		return adgroup.toString();
	}

	public void setAdgroup(String adgroupId) {
		this.adgroup.set(adgroupId);
	}

	public String getAd() {
		return ad.toString();
	}

	public void setAd(String adId) {
		this.ad.set(adId);
	}

	public String getHtp1() {
		return htp1.toString();
	}

	public void setHtp1(String htp1) {
		this.htp1.set(htp1);
	}

	public String getHtp2() {
		return htp2.toString();
	}

	public void setHtp2(String htp2) {
		this.htp2.set(htp2);
	}

	public String getHtp3() {
		return htp3.toString();
	}

	public void setHtp3(String htp3) {
		this.htp3.set(htp3);
	}

	public Long getTime() {
		return time.get();
	}

	public void setTime(Long time) {
		this.time.set(time);
	}

	public Long getActionTime() {
		return actionTime.get();
	}

	public void setActionTime(Long actionTime) {
		this.actionTime.set(actionTime);
	}

	public void setCountry(String country) {
		this.country.set(country);
	}

	public void setProvince(String province) {
		this.province.set(province);
	}

	public void setCity(String city) {
		this.city.set(city);
	}

	public void setPlatform(String platform) {
		this.platform.set(platform);
	}

	public void setDevice(String device) {
		this.device.set(device);
	}

	public String getPlatform() {
		return platform.toString();
	}

	public String getDevice() {
		return device.toString();
	}

	public String getCountry() {
		return country.toString();
	}

	public String getProvince() {
		return province.toString();
	}

	public String getCity() {
		return city.toString();
	}

	public void setActParams(String actParams) {
		this.actParams.set(actParams);
	}

	public String getActParams() {
		return actParams.toString();
	}

	@Override
	public void write(DataOutput out) throws IOException {
		for (Writable value : data) {
			value.write(out);
		}
	}

	@Override
	public void readFields(DataInput in) throws IOException {
		for (Writable value : data) {
			value.readFields(in);
		}
	}

	public void clear() {
		event.clear();
		atrb.clear();
		sessionId.clear();
		user.clear();
		account.clear();
		campaign.clear();
		adgroup.clear();
		ad.clear();
		platform.clear();
		device.clear();
		htp1.clear();
		htp2.clear();
		htp3.clear();
		weightLinear.set(BigDecimal.ZERO);
		weightRanking.set(BigDecimal.ZERO);
		weightTimeDecay.set(BigDecimal.ZERO);
		actParams.clear();
		time.set(0);
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
				.append("sessionId", this.sessionId).append("user", this.user)
				.append("account", this.account)
				.append("campaign", this.campaign)
				.append("adgroup", this.adgroup).append("ad", this.ad)
				.append("platform", this.platform)
				.append("device", this.device).append("htp1", this.htp1)
				.append("htp2", this.htp2).append("htp3", this.htp3)
				.append("actParams", this.actParams).append("time", this.time)
				.toString();
	}
}
