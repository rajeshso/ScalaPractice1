package uk.rajesh.design.week1

/**
  * Created by Rajesh on 01-May-17.
  */
object Recap extends App {

  trait Mappi[Key, Value] extends (Key => Value)

  val s = new Mappi[String,String] {
    override def apply(v1: String): String = v1 match {
      case "1" => "One"
      case _ => "Any number"
    }
  }
  val s1 : String => String = {
    case "1" => "One"
    case _ => "Any number"
  }

  println(s("1"))
  println(s1("1")) //Function is not defined, yet it works

  val s2 : PartialFunction[String, String] = { //benefit of PartialFunction - you get isDefinedAt implemented.
    case "1" => "One"
  }
  println(s2("1"))
  println(s2.isDefinedAt("1"))
  println(s2.isDefinedAt("2"))
  List(41, "cat") collect { case i: Int ⇒ i + 1}

  /**
    * A PartialFunction must provides a method isDefinedAt, which allows the caller of the partial function to know,
    * beforehand, whether the function can return a result for a given input value:
    */
  val fraction = new PartialFunction[Int, Int] {
    def apply(d: Int) = 42 / d
    def isDefinedAt(d: Int) = d != 0
  }

  println(fraction(2))

  if (fraction.isDefinedAt(0)) println(fraction(0))
  val pets = List("cat", "dog", "frog")
  pets(0)
  pets.lift(100) //lift method, which converts the partial function to a normal function that doesn’t crash by returning an Option
  pets.lift(0) map ("I love my " + _) getOrElse "Sorry"
  pets.lift(100) map ("I love my " + _) getOrElse "Sorry"

  //for yield
  val u : Seq[(Int, Int)] = for {
    i <- 1 until 3
    //println(i)
    j <- 1 until i
    if ((i+j)>1)
    //println(j)
  }yield (i,j)
  println(u)

  trait Hello {
    //self => //an alias for this
    foo =>
    def sayHello(s: String)

    def tell(s: String) = println("Wow "+ s)
    def say(s: String) = new Hello {
      override def sayHello(s: String): Unit = foo.sayHello(s + " Somasundaram") //self.sayHello(s+" Somasundaram")//println("Hello "+s)
    }
  }
  def test() = new Hello {
    override def sayHello(s: String): Unit = println("Hi "+s)
  }.sayHello("Rajesh")
}
