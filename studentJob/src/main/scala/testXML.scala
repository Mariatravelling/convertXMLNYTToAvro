import org.apache.spark.sql.types.{StringType, StructField, StructType}
import org.apache.spark.sql.{Row, SQLContext}
import org.apache.spark.{SparkConf, SparkContext}

/**
 * Created by wangzehui on 11/13/15.
 */
object testXML extends App {

  val cof=new SparkConf().setAppName("readingXML")
  cof.setMaster("local[*]")
  val sc=new SparkContext(cof)
  val sqlContext=new SQLContext(sc)
  val file="0000205.xml"
//  val sentences=new utils.SentencesLenConstraint
  //parse attributes in xml

  /*def readlingXML (fileName:String): String = {
    val doc=sc.textFile(fileName)
    val xml = XML.loadFile(fileName)
    val sentence=(xml\\"block").filter(x=>((x\"@class").text=="full_text")).map(_\"p").toString()

    var sentences=new utils.parseSentence
    var content=sentences.gettingSentences(sentence)
    return content
  }*/

 /* val text: String = "Lawyers for three former preschool teachers said today that they would appeal a judge's ruling that tossed out part of a large civil suit alleging false arrest on charges of child abuse. He said the women had filed their suit too late."
  var sentences=new utils.parseSentence(text)
  var span=sentences.gettingSentences.get(0)
  var tokens=sentences.gettingSentences.get(1)
  val lengthOftokens=tokens.length
  var content=sentences.gettingSentences.get(2)
  //println("content"+content)
  val spans: Array[String]=span.split(";;")
  val startIndexOfSpan=spans(0)
  val endIndexOfSpan=spans(1)
  val SPAN=Row(startIndexOfSpan,endIndexOfSpan)

  var sentenceCount=sentences.countSentence()

  val innerStructOfTokensOfPos=StructType(List(StructField("start_index", IntegerType, true),StructField("end_index", IntegerType, true)))
  val innerStrcutOfTokens=StructType(List(StructField("ner", StringType, true),StructField("pos", StringType, true),StructField("t_span", IntegerType, true)))
  val innerStructOfSpan= StructType(List(StructField("start_index", IntegerType, true),StructField("end_index", IntegerType, true)))
  val innerStruct =StructType(List(StructField("s_id", StringType, false),StructField("span", StringType, true),StructField("sg", StringType, true),StructField("dp", StringType, true),StructField("tokens", StringType, true)))

  val attributes:List[String]=List(content)
  var document=sc.parallelize(attributes)
  val seq = List.tabulate(sentenceCount)(n => StructField(n.toString, innerStruct, true))



  //val row1=List.tabulate(2)(n=> Row(Row(n*5,n*5+1),Row(List.tabulate(5)(n=>Row(Row(n*5+2,n*5+3),n*5+4,n*5+5)),n*5+6,n*5+7,n*5+8)))
   val rowRDD = document.map(_.split(";;")).map(p=>Row.apply(List.tabulate(2)(n=> Row(p(n*5),p(n*5+1),p(n*5+2),p(n*5+3),p(n*5+4)))))
  //val ROW=Row.apply(row1,row2)
    println("row1:"+rowRDD)
  val schema = StructType(seq)*/
//Row(p(n*5),p(n*5+1),p(n*5+2),p(n*5+3),p(n*5+4))


  val attributes1:List[String]=List("g;;o;;o;;d;;a;;b;;c;;d;;e;;f")
  var document1=sc.parallelize(attributes1)
  val attributes2:List[String]=List("b;;c;;d;;e;;f")
  var document2=sc.parallelize(attributes2)
  val innerStructOfSpan= StructType(List(StructField("start_index", StringType, true),StructField("end_index", StringType, true)))
  //val seq1 = List.tabulate(5)(n => StructField(n.toString, StringType, true))
  //val seq2=List.tabulate(5)(n => StructField(n.toString, innerStructOfSpan, true))
  //val rowRDD1 = document1.map(_.split(";;")).map(p=>Row(p(0),Row(p(1),p(2)),p(3),p(4)))
  //val rowRDD2 = document2.map(_.split(";;")).map(p=>Row(p(0),Row(p(1),p(2)),p(3),p(4)))

  val li=List.tabulate(2)(n=> Row((n*5),(n*5+1),(n*5+2),(n*5+3),(n*5+4)))
  println(li);
  val rowRDD = document1.map(_.split(";;")).map(p=>Row.apply(List.tabulate(2)(n=> Row(p(n*5),p(n*5+1),p(n*5+2),p(n*5+3),p(n*5+4)))))
  //val rowRDD2 = document2.map(_.split(";;")).map(p=>Row(p(0),List.tabulate(1)(n=>Row(p(n+2),p(n+2))),p(3),p(4)))
  // val rdd=rowRDD1.union(rowRDD2)

  //val test= new extendsRow()
 // val rowRDD = document1.map(_.split(";;")).map(p=>Row(Row(p(0),p(1),p(2),p(3),p(4)),Row(p(5),p(6),p(7),p(8),p(9))))

  val innerStruct =StructType(List(StructField("s_id", StringType, false),StructField("span", StringType, true),StructField("sg", StringType, true),StructField("dp", StringType, true),StructField("tokens", StringType, true)))

  //val schema = StructType(List(StructField("title",StringType,true),StructField("publication_year",innerStruct,true),StructField("publication_dayOfMonth",StringType,true)
   // ,StructField("publication_month",StringType,true),StructField("dayOfWeek",StringType,true),StructField("dsk",StringType,true),StructField("print_page_number",StringType,true)
    //,StructField("print_section",StringType,true)))
  val seq2=List.tabulate(2)(n => StructField(n.toString, innerStruct, true))
  println("1")
  val schema=StructType(seq2)
  println("2")
  //val schema = StructType(List(StructField("1",innerStruct,true),StructField("2",innerStruct,true)))

  val table=sqlContext.createDataFrame(rowRDD,schema)
  println("3")
    table.registerTempTable("doccc")
  println("4")
    //select all attributes and save them as Json or Avro
    val results = sqlContext.sql("SELECT * FROM doccc")
  println("5")
   //results.foreach(println)
  results.foreach(println)
  println("6")
  // results.select("1").foreach(println)
    results.printSchema()
  println("7")
  results.repartition(1).write.json("testh")

}
