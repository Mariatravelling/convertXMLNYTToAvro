package createAvro

import java.io.File

import avroschema.Article
import org.apache.avro.file.DataFileReader
import org.apache.avro.io.DatumReader
import org.apache.avro.specific.SpecificDatumReader


/**
 * Created by wangzehui on 12/30/15.
 */
object deserializing extends App{
  val file=new File("Article.avro")
  val userDatumReader: DatumReader[Article]  = new SpecificDatumReader[Article]
  val dataFileReader: DataFileReader[Article] = new DataFileReader[Article](file, userDatumReader)
  var at:Article  = null
  //println(dataFileReader)
  while (dataFileReader.hasNext()) {
    // Reuse user object by passing it to next(). This saves us from
    // allocating and garbage collecting many objects for files with
    // many items.
    //println(dataFileReader.hasNext())
    at = dataFileReader.next(at)
    //println(Article.getClassSchema)
    println(at)
  }
}
