package first.bean

import java.io.{DataInput, DataOutput}
import java.math.BigDecimal

import com.hypers.hadoop.io.EnumWritable
import com.hypers.hfa.types.ATRBModel
import org.apache.hadoop.hive.ql.io.parquet.writable.BigDecimalWritable
import org.apache.hadoop.io.{LongWritable, Text, Writable, WritableComparable}
import org.apache.hadoop.mapreduce.jobhistory.Events

/**
  * Created by Tong on 2016/7/14.
  */
class ActionRecordValue extends WritableComparable[ActionRecordValue]{
  private[conversion] val event: EnumWritable[Events] = new EnumWritable[Events]
  private[conversion] val atrb: EnumWritable[ATRBModel] = new EnumWritable[ATRBModel]
  private[conversion] val sessionId: Text = new Text
  private[conversion] val user: Text = new Text
  private[conversion] val account: Text = new Text
  private[conversion] val campaign: Text = new Text
  private[conversion] val adgroup: Text = new Text
  private[conversion] val ad: Text = new Text
  private[conversion] val country: Text = new Text
  private[conversion] val province: Text = new Text
  private[conversion] val city: Text = new Text
  private[conversion] val htp1: Text = new Text
  private[conversion] val htp2: Text = new Text
  private[conversion] val htp3: Text = new Text
  private[conversion] val platform: Text = new Text
  private[conversion] val device: Text = new Text
  private[conversion] val actParams: Text = new Text
  private[conversion] val time: LongWritable = new LongWritable(0)
  private[conversion] val actionTime: LongWritable = new LongWritable(0)
  private[conversion] val weightLinear: BigDecimalWritable = new BigDecimalWritable(BigDecimal.ZERO)
  private[conversion] val weightRanking: BigDecimalWritable = new BigDecimalWritable(BigDecimal.ZERO)
  private[conversion] val weightTimeDecay: BigDecimalWritable = new BigDecimalWritable(BigDecimal.ZERO)
  @deprecated private[conversion] var ip: String = null
  private[conversion] val data: Array[Writable] = Array(event, atrb, sessionId, user, account, campaign, adgroup, ad, country, province, city, htp1, htp2, htp3, platform, device, actParams, time, actionTime, weightLinear, weightRanking, weightTimeDecay)

  def setWeight(attr: ATRBModel, weight: BigDecimal) {
    attr match {
      case LINEAR =>
        weightLinear.set(weight)
        break //todo: break is not supported
      case RANKING =>
        weightRanking.set(weight)
        break //todo: break is not supported
      case TIME_DECAY =>
        weightTimeDecay.set(weight)
        break //todo: break is not supported
      case _ =>
        break //todo: break is not supported
    }
  }

  def getWeight(atrb: ATRBModel): BigDecimal = {
    atrb match {
      case LINEAR =>
        return weightLinear.getBigDecimal
      case RANKING =>
        return weightRanking.getBigDecimal
      case TIME_DECAY =>
        return weightTimeDecay.getBigDecimal
      case _ =>
        return BigDecimal.ONE
    }
  }

  @deprecated def getIp: String = {
    return ip
  }

  @deprecated def setIp(ip: String) {
    this.ip = ip
  }

  def setEvent(event: Events) {
    this.event.set(event)
  }

  def getEvent: Events = {
    return event.get
  }

  def setAtrb(atrb: ATRBModel) {
    this.atrb.set(atrb)
  }

  def getAtrb: ATRBModel = {
    return atrb.get
  }

  def setSessionId(sessionId: String) {
    this.sessionId.set(sessionId)
  }

  def getSessionId: String = {
    return sessionId.toString
  }

  def getCampaign: String = {
    return campaign.toString
  }

  def setUser(user: String) {
    this.user.set(user)
  }

  def getUser: String = {
    return user.toString
  }

  def getAccount: String = {
    return account.toString
  }

  def setAccount(account: String) {
    this.account.set(account)
  }

  def setCampaign(campaignId: String) {
    this.campaign.set(campaignId)
  }

  def getAdgroup: String = {
    return adgroup.toString
  }

  def setAdgroup(adgroupId: String) {
    this.adgroup.set(adgroupId)
  }

  def getAd: String = {
    return ad.toString
  }

  def setAd(adId: String) {
    this.ad.set(adId)
  }

  def getHtp1: String = {
    return htp1.toString
  }

  def setHtp1(htp1: String) {
    this.htp1.set(htp1)
  }

  def getHtp2: String = {
    return htp2.toString
  }

  def setHtp2(htp2: String) {
    this.htp2.set(htp2)
  }

  def getHtp3: String = {
    return htp3.toString
  }

  def setHtp3(htp3: String) {
    this.htp3.set(htp3)
  }

  def getTime: Long = {
    return time.get
  }

  def setTime(time: Long) {
    this.time.set(time)
  }

  def getActionTime: Long = {
    return actionTime.get
  }

  def setActionTime(actionTime: Long) {
    this.actionTime.set(actionTime)
  }

  def setCountry(country: String) {
    this.country.set(country)
  }

  def setProvince(province: String) {
    this.province.set(province)
  }

  def setCity(city: String) {
    this.city.set(city)
  }

  def setPlatform(platform: String) {
    this.platform.set(platform)
  }

  def setDevice(device: String) {
    this.device.set(device)
  }

  def getPlatform: String = {
    return platform.toString
  }

  def getDevice: String = {
    return device.toString
  }

  def getCountry: String = {
    return country.toString
  }

  def getProvince: String = {
    return province.toString
  }

  def getCity: String = {
    return city.toString
  }

  def setActParams(actParams: String) {
    this.actParams.set(actParams)
  }

  def getActParams: String = {
    return actParams.toString
  }


  override def compareTo(o: ActionRecordValue): Int = {

  }

  override def write(out: DataOutput): Unit = {}

  override def readFields(in: DataInput): Unit = {

  }

}
