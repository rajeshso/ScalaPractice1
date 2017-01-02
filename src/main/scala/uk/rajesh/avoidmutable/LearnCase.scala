package uk.rajesh.avoidmutable
//Week 4.6
object LearnCase {
  def main(args: Array[String]) {
    val n1 = new Number(1)
    val n2 = Number(2) //The advantage of using
  }
  def eval(e : Expr): Int = e match {
    case Number(n) => n
    case Sum(a, b) => eval(a) +eval(b)
  }
}

trait Expr
case class Number(n: Int) extends Expr
case class Sum(a: Expr, b: Expr) extends Expr

object Number {
  def apply(n: Int) = new Number(n)
}
object Sum {
  def apply(n: Expr, n1 : Expr) = new Sum(n, n1)
}