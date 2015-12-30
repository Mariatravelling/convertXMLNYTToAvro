/**
 * Created by wangzehui on 10/5/15.
 */

import net.liftweb.json._

import scala.io.Source

object parseJsonrse {

  implicit val formats = DefaultFormats

  def main(args: Array[String]) {
    val filename = "aida_sample.json"
    val fileContents = Source.fromFile(filename).getLines.mkString
    //println(fileContents)
    val json = parse(fileContents)
    val q=json.extract[AIDAFile]
    println(q.docID)
    println(q.allEntities)
  }
  case class AIDAFile(
                           allEntities: List[String],
                           docID: String,
                           //entityMetadata: List[String],
                           formatVersion: String,
                           //mentions: List[String],
                           originalFileName: String,
                           originalText: String,
                           overallTime: String)
                           //tokens: List[String])

}
