package first.bean

/**
  * Created by Tong on 2016/7/14.
  */
object Events extends Enumeration{
  
  val IMPRESSION=Value
  val CLICK=Value
  val CONVERSION=Value
  val ATTRIBUTION=Value
  val ATTRIBUTION_IMP=Value
  val ATTRIBUTION_CLK=Value
  val IMP_ATTR_FREQUENCY=Value
  val IMP_CLK_FREQUENCY=Value
  val CLK_ATTR_FREQUENCY=Value
  val CLK_FREQUENCY=Value
}
