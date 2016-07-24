package streaming

import org.apache.spark.SparkConf
import org.apache.spark.streaming.{Seconds, StreamingContext}

class S3FileStreaming {

    def main(args: Array[String]) {

        val conf=new SparkConf().setAppName(getClass.getName)
        val ssc=new StreamingContext(conf,Seconds(60))

        ssc.fileStream("")


    }

}
