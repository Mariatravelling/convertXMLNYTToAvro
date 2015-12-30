import java.io.{FileOutputStream, FileInputStream, File}

import com.databricks.spark.avro._
import org.apache.spark.sql.SQLContext
import org.apache.spark.{SparkConf, SparkContext}
/**
 * Created by wangzehui on 10/15/15.
 */
object test {
  def main(args: Array[String]) {

    val conf = new SparkConf().setAppName("Simple Application")
    conf.setJars(List("/Users/wangzehui/IdeaProjects/testing/target/scala-2.10/studentjob_2.10-1.0.jar"))
    conf.setMaster("local[*]")
    val sc = new SparkContext(conf)
    val sqlContext = new SQLContext(sc)
    //reading avro files
    val df = sqlContext.read.avro {
      "part-r-00017.avro"
    }
    //substracts the "docID" part in AVRO.URL and store it as a new Attribute "newID" in order to match with Json.docID File
    val df1 = df.withColumn("newID", df("url").substr(48, 58))
    //store the file as a sql readable Table
    df1.registerTempTable("avro")
    //reading all Json files in one directory and match them with AVRO separately
    walk(new File("/Users/wangzehui/Desktop/Student Job/task1/02"))
    def walk(jsonFile: File) {
      if (jsonFile.isFile()) {
        if (jsonFile.getName.endsWith("json")) {
          println("The file is processing:" + jsonFile.getName())
          val dfj = sqlContext.read.json("/Users/wangzehui/Desktop/Student Job/task1/02/" + jsonFile.getName)
          //store the file as a sql readable Table
          dfj.registerTempTable("json")
          //With SQL extract all attributes what we want
          val newData = sqlContext.sql("SELECT avro.url,avro.abstract,avro.leadParagraph,avro.titles,avro.online_titles,avro.metadatMap,avro.headline,avro.content,avro.sentences,json.allEntities FROM json FULL OUTER JOIN avro ON json.docID=avro.newID")
          //select correct records
          val output=newData.filter("json.allEntities IS NOT NULL AND avro.url IS NOT NULL")
          if(output.count()==1) {
            val file="output/"+"new" + jsonFile.getName.substring(1,7)
            val filename=jsonFile.getName.substring(1,7)
            //output.repartition(1).write.avro(file)
            output.repartition(1).write.avro(file)
            output.repartition(1).write.json(file)
            //because the final result is a folder which contains avro and _SUCCESS file,so this step is used to copy avro file
            // to aonther folder
            val in  = new FileInputStream(file+"/part-00000").getChannel
            val out = new FileOutputStream("result/"+filename+".json").getChannel
            in transferTo (0, in.size, out)
          }
          println("end")
        }
        else println("this is a hidden File")
      }
      else jsonFile.listFiles().foreach(walk)
    }
  }
}
