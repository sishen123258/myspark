import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by Tong on 2016/7/13.
  *
  * /user/t_test/ATTRIBUTION
  */
object First{

  def main(args: Array[String]) {

    val conf=new SparkConf().setAppName("testConversionModel")

    val sc=new SparkContext(conf)

    val hadoopFile = sc.hadoopFile("/user/t_test/ATTRIBUTION/20160624/")  //TODO add inputformat





  }

}