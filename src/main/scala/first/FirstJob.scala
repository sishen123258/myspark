package first

import first.bean.{ActionRecordKey, ActionRecordValue}
import org.apache.log4j.Logger
import org.apache.spark.{SparkConf, SparkContext}

object FirstJob{

  private[this] val logger = Logger.getLogger(getClass().getName());

  def main(args: Array[String]) {

    val conf=new SparkConf().setAppName("testConversionModel")

    val sc=new SparkContext(conf)

    //val hadoopFile = sc.hadoopFile("/user/t_test/ATTRIBUTION/20160624/")

    //classOf == .class
    val sequenceFile=sc.sequenceFile("/user/t_test/ATTRIBUTION/20160624/",classOf[ActionRecordKey],classOf[ActionRecordValue])

    val first = sequenceFile.take(1)

    logger.info(first)

  }

}