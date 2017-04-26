package uk.gov.hmrc.fundesign.week1

/**
  * Created by rajesh on 10/04/17.
  */
abstract class JSON
case class JSeq(elems: List[JSON]) extends JSON
case class JObj(bindings: Map[String, JSON]) extends JSON
case class JNum(num: Double) extends JSON
case class JStr(str: String) extends JSON
case class JBool(b: Boolean) extends JSON
case object JNull extends JSON

/**
  *
  * {
  *   "firstname" : "Rajesh",
  *   "lastname"  : "Somasundaram",
  *   "address"   : {
  *                   "street" : "3 Lathom Road",
  *                   "city"   : "London",
  *                   "postcode" : "1000"
  *                   },
  *   "phonenumbers" : [
  *     { "type" : "home" , "number" : "123456" },
  *     { "type" : "office" , "number" : "654321" }
  *   ]
  * }
  */

object MyJSON extends App {
  val data = JObj(Map(
    "firstname" -> JStr("Rajesh"),
    "lastname" -> JStr("Somasundaram"),
    "address" -> JObj(Map(
                      "street" -> JStr("3 Lathom Road"),
                      "city"   -> JStr("London"),
                      "postcode" -> JNum(1000)
                        )
                      ),
  "phonenumbers" -> JSeq(List(
                          JObj(Map(
                                "type" -> JStr("home"),
                                "number" -> JNum(123456)
                          )),
                          JObj(Map(
                                "type" -> JStr("home"),
                                "office" -> JNum(654321)
                          ))
                        )
                      )
                    )
                  )

  def show(json: JSON) : String = json match {
    case JSeq(elems: List[JSON]) => "[" + (elems map show mkString(","))  + "]"
    case JObj(bindings: Map[String, JSON]) =>
      val a = bindings map {
        case(key, value) => "\"" + key +  "\": "  + show(value)
      }
      "{" + (a mkString " , ") + "}"
    case JNum(num: Double) => num toString
    case JStr(str: String) => str
    case JBool(b : Boolean) => b toString
    case JNull => "null"
  }
  println(show(data))

  val list : List[String] = List("peppa", "charlie", "captain")
  val listSuffix : List[String] = list map {
    case "captain" => "america"
    case s : String => s
  }
  println(listSuffix)
  val funcstr : String => String = {case "Rajesh" => "Somasundaram"}
  println(funcstr("Rajesh"))
  println(funcstr("ABCD"))

  val f: PartialFunction[List[Int], String] = {
    case Nil => "one"
    case a::y::rest => "two"
  }
  //println(f())
}