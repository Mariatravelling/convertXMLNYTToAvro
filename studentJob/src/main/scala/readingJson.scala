import org.apache.spark.sql.SQLContext
import org.apache.spark.{SparkContext, SparkConf}

/**
 * Created by wangzehui on 10/23/15.
 */
object readingJson extends App{

  val cof=new SparkConf().setAppName("readingAvro")
  cof.setMaster("local[*]")
  val sc=new SparkContext(cof)
  val sqlContext=new SQLContext(sc)
  val df=sqlContext.read.json("decoded_file.json")
 // df.selectExpr("")
  df.printSchema()
  //df.foreach(println)
}
