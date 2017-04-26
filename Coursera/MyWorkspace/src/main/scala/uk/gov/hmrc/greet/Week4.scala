package uk.gov.hmrc.greet

/**
  * Created by rajesh on 24/02/17.
  */
class Week4 {

}

object true1 {
  def <[T](left: T, right: T) : T = left
}

object false1 {
  def <[T](left: T, right: T) : T = right
}

abstract class Nat {
  def isZero: Boolean
  def predecessor: Nat
  def successor: Nat
  def + (that: Nat): Nat
  def - (that: Nat): Nat
}

object Zero extends Nat {
  override def isZero: Boolean = true

  override def predecessor: Nothing = throw new NoSuchElementException("Nothing is less than zero")

  override def successor: Nat = new Succ(Zero)

  override def +(that: Nat): Nat = that

  override def -(that: Nat): Nothing = throw new NoSuchElementException("Nothing to subract from zero")
}

class Succ(n: Nat) extends Nat {
  override def isZero: Boolean = false

  override def predecessor: Nat = ??? //- n

  override def successor: Nat = ??? //new Succ( + n)

  override def +(that: Nat): Nat = that.+(n)

  override def -(that: Nat): Nat = that.-(n)
}

//Pattern Matching
trait Expr
case class Number(n1: Int) extends Expr
case class Sum(n1: Expr, n2 : Expr) extends Expr
case class Product(n1: Expr, n2 : Expr) extends Expr

object TestExpr {
  def show(e: Expr) : String = e match {
    case Number(n1) => n1.toString
    case Sum(n1, n2) => "("+ show(n1) + " + " + show(n2) + ")"
    case Product(n1, n2) => "("+ show(n1) + " * " + show(n2) + ")"
  }

  def main(args: Array[String]): Unit = {
    var showedExpr = show(Sum(Number(1), Number(2)))
    println(showedExpr)
    println(show(Product(Number(1), Sum(Number(1), Number(2)))))
  }
}

//Lists
object ListExample {
  val fruit = List("apple","orange","pear") //Lists are immutable by default. there are mutable variants too.
  val nums = List(1,2)
  val emptyList = List()
  //x:: xs , :: means Cons
  val veg = "carrot" :: "bean" :: "beetroot" :: Nil
  val sugar = "sugarcane" :: ("sugarroot" :: ("watermelon" :: Nil))
  def main(args: Array[String]) : Unit = {
    println(veg.head)
    println(veg.tail.head)

    //List for Pattern Matching

  }
}
