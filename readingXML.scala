
import java.io.File
import java.util

import avroschema._
import org.apache.avro.file.DataFileWriter
import org.apache.avro.io.DatumWriter
import org.apache.avro.specific.SpecificDatumWriter
import org.apache.hadoop.mapreduce.Job
import org.apache.pig.data.{BagFactory, TupleFactory}
import org.apache.spark.sql.SQLContext
import org.apache.spark.{SparkConf, SparkContext}
import utils.ProcessXML

import scala.xml.XML
/**
 * Created by wangzehui on 10/27/15.
 */
object readingXML extends App{
  val conf=new SparkConf().setAppName("readingXML")
  conf.setMaster("local[*]")
  val sc=new SparkContext(conf)
  val job = new Job()
  val sqlContext=new SQLContext(sc)
  val file="0000205.xml"
  //val parseSentence=new SentencesLenConstraint
  val doc=sc.textFile(file)
  val xml = XML.loadFile(file)

  val mTupleFactory = TupleFactory.getInstance()
  val mBagFactory = BagFactory.getInstance()
  var outerBag = mBagFactory.newDefaultBag()
  val tuple=mTupleFactory.newTuple(xml)
  tuple.append(1)

  //val sentenceInfo=parseSentence.exec(tuple)
  val readXml=new ProcessXML()
  val output=readXml.exec(tuple)

  var Abstract=output.get(0).toString
  Abstract=checkNUll(Abstract)
  println("Abstract:"+Abstract)
  val leadParagraph=output.get(1).toString;    println("leadParagraph:"+leadParagraph)
  val url=output.get(2).toString;              println("url"+url)
  val titles=output.get(3);           println("titles"+titles)
  val onlineTitles=output.get(4);     println("onlineTitles"+onlineTitles)
  val headline=output.get(6).toString;         println("headline"+headline)
  val content=output.get(7).toString;          println("content"+content)

  println("6"+output.get(5))
  val attributes=output.get(5).toString.split(",")
  var featurePage=checkNUll(attributes(0))
  println("featurePage:"+featurePage)
  var year=checkNUll(attributes(1))
  println("year:"+year)
  var printPageNumber=checkNUll(attributes(2))
  println("printPageNumber:"+printPageNumber)
  var seriesName=checkNUll(attributes(3))
  println("seriesName:"+seriesName)
  var alternateURL=checkNUll(attributes(4))
  println("alternateURL:"+alternateURL)
  var banner=checkNUll(attributes(5))
  println("banner:"+banner)
  var section=checkNUll(attributes(6))
  println("section:"+section)
  var correctionDate=checkNUll(attributes(7))
  println("correctionDate:"+correctionDate)
  var dayOfWeek=checkNUll(attributes(8))
  println("dayOfWeek:"+dayOfWeek)
  var onlineSection=checkNUll(attributes(9))
  println("onlineSection:"+onlineSection)
  var month=checkNUll(attributes(10))
  println("month:"+month)
  var columnNumber=checkNUll(attributes(11))
  println("columnNumber:"+columnNumber)
  var dayOfMonth=checkNUll(attributes(12))
  println("dayOfMonth:"+dayOfMonth)
  var dsk=checkNUll(attributes(13))
  println("dsk:"+dsk)
  var slug=checkNUll(attributes(14))
  println("slug:"+slug)
  var columnName=checkNUll(attributes(15)).substring(0,checkNUll(attributes(15)).length-1)
  println("columnName:"+columnName)

  def checkNUll(parameter: String):String=
  {

    if(parameter.split("=").length==1)
      return null
    else
      return parameter.split("=")(1)
  }

  def gettingSpan(span: String): String=
  {
    val offset: Array[String] = span.split(",")
    val start_index: String = offset(0).substring(1)
    val end_index: String = offset(1).substring(0, offset(1).length - 1)
    val parsingSpan: String = start_index + ";;" + end_index
    return parsingSpan
  }

  def gettingtokens(tokens: String): util.ArrayList[Token] = {
    var parsingToken = new java.util.ArrayList[Token]()
    val token: Array[String] = tokens.substring(2, tokens.length - 2).split("\\),\\(")
    var i: Int = 0
    while (i < token.length) {

          val attributeOfTokens: Array[String] = token(i).split(",")
          val pos: String = attributeOfTokens(0)
          val ner: String = attributeOfTokens(1)
          val start_index: String = attributeOfTokens(2).substring(1)
          val end_index: String = attributeOfTokens(3).substring(0, attributeOfTokens(3).length - 1)
          val tspan=Span.newBuilder().setStartIndex(start_index).setEndIndex(end_index).build()
          val tokenss=Token.newBuilder().setNer(ner).setPos(pos).setTSpan(tspan).build()
          println("tokenss.getNer:"+tokenss.getNer)
          parsingToken.add(i,tokenss)
          //parsingTokens = parsingTokens + pos + ";;" + ner + ";;" + start_index + ";;" + end_index + ";;"
          i=i+1

      }
    return parsingToken
  }
  /*var sentences = new java.util.ArrayList[Sentence]()
  val iter = sentenceInfo.iterator()
  var i=0
  while (iter.hasNext)
    {
      val str=iter.next().getAll
      val id=str.get(0).toString.toInt
      val spans=gettingSpan(str.get(1).toString()).split(";;")
      val span=Span.newBuilder().setEndIndex(spans(1).toInt).setStartIndex(spans(0).toInt).build()
      println(str.get(2).toString)
      //val tok=gettingtokens(str.get(2).toString)
      println("getStartIndex:"+span.getStartIndex)
      val sen=Sentence.newBuilder().setDp(str.get(3).toString).setSg(str.get(4).toString()).setSId(id).setSpan(span).setTokens(null).build()
      println("sen.getDp:"+sen.getDp)
      sentences.add(i,sen)
      i=i+1
    }*/
     //val titles=Title.newBuilder().setTitle(onlineTitles.toString).build()
     val article= new Article()
  article.setAbstract$(Abstract)
  article.setHeadline(headline)
article.setLeadParagraph(leadParagraph)
  article.setAlternateURL(alternateURL)
  article.setBanner(banner)
  article.setColumnName(columnName)
  article.setColumnNumber(columnNumber)
  article.setContent(content)
  article.setCorrectionDate(correctionDate)
  article.setDayOfMonth(dayOfMonth)
  article.setDayOfWeek(dayOfWeek)
  article.setDsk(dsk)
  article.setFeaturePage(featurePage)
  //article.setLeadParagraph(leadParagraph.toString)
  article.setMonth(month)
  article.setOnlineSection(onlineSection)
  //article.setOnlineTitles(null)
  article.setPrintPageNumber(printPageNumber)
  //article.setPrintSection(null)
    //    .setSentences(null)
  article.setSeriesName(seriesName)
  article.setSlug(slug)
        //.setTitles(null)
  article.setUrl(url)
  article.setYear(year)
 // println(article.getSentences)
 val avroSchema=Article.SCHEMA$
  /*println(article.getAbstract$)
  println(article.getAlternateURL)
  println(article.getBanner)
  println(article.getColumnName)
  println(article.getColumnNumber)
  println(article.getContent)
  println(article.getCorrectionDate)
  println(article.getDayOfMonth)
  println(article.getDayOfWeek)
  println(article.getDsk)
  println(article.getFeaturePage)
  println(article.getHeadline)
  println(article.getLeadParagraph)
  println(article.getMonth)
  println(article.getOnlineSection)
  println(article.getOnlineTitles)
  println(article.getPrintSection)
  println(article.getPrintPageNumber)
  println(article.getSentences)
  println(article.getSeriesName)
  println(article.getSlug)
  //println(article.getTitles)
  println(article.getUrl)
  println(article.getYear)
  println(article.getClass)*/

  val userDatumWriter: DatumWriter[Article]  = new SpecificDatumWriter[Article]
  val dataFileWriter: DataFileWriter[Article]  = new DataFileWriter[Article](userDatumWriter)

  dataFileWriter.create(Article.getClassSchema, new File("Article.avro"))
  dataFileWriter.append(article)
  dataFileWriter.close()

  println(article)
  /*
  //println("SentenceSchema:"+Sentence.getClassSchema)
  //ParquetOutputFormat.setWriteSupportClass(job, classOf[AvroWriteSupport])
  //AvroParquetOutputFormat.setSchema(job,avroSchema)


  val schema = Article.SCHEMA$
  val files=new File("/resource/avroSchemaFlattened.avro")
  /*val path= new Path("/resource/avroSchemaFlattened.avro")
  val fsInput = new FsInput(path, conf)

  val dataFileReader = DataFileReader.openReader(fsInput, reader)

  val path= new Path("/resource/avroSchemaFlattened.avro")
  val parquetWriter = new AvroParquetWriter[IndexedRecord](path, schema)
 // val userDatumReader = new SpecificDatumReader<Article>(Article.class);*/
  //val files=new File("/resource/avroSchemaFlattened.avro")
  val reader =  new GenericDatumReader[GenericRecord](schema)
  val dataFileReader = new DataFileReader(files, reader)
  var user: GenericRecord = null
  while (dataFileReader.hasNext()) {
    // Reuse user object by passing it to next(). This saves us from
    // allocating and garbage collecting many objects for files with
    // many items.
    user = dataFileReader.next(user)
    println(user)
  }

*/

}
