import org.apache.spark.sql.SQLContext
import org.apache.spark.{SparkContext, SparkConf}
import com.databricks.spark.avro._
/**
 * Created by wangzehui on 10/21/15.
 */
object readingAvro extends App{

  val cof=new SparkConf().setAppName("readingAvro")
  cof.setMaster("local[*]")
  val sc=new SparkContext(cof)
  val sqlContext=new SQLContext(sc)
  val df=sqlContext.read.avro{
    "part-r-00017.avro"
  }
  val newdata=df.withColumn("docID",df("url").substr(48, 58))

  newdata.registerTempTable("avro")
  df.printSchema()
  //newdata.select("docID").foreach(println)
  val result=sqlContext.sql("""SELECT avro.url,avro.abstract,avro.leadParagraph,avro.titles,avro.online_titles,avro.metadatMap,avro.headline,avro.content,avro.sentences FROM avro WHERE docID='9B0DE7D7123AF933A25752C0A961948260'""")
  result.write.json("json3.json")
  //df.foreach(println)
  //df.select("allEntities").foreach(println)
  //df.select("url").foreach(println)
}
