package uk.rajesh.avoidmutable
//Week 4.6
object LearnCase {
  def main(args: Array[String]) {
    val n1 = new Number(1)
    val n2 = Number(2) //The advantage of using Case classes or Objects. There is no requirement to write new
    val exp1 = Sum(Number(1) , Number(2))
    println(show(exp1))
    val exp2 = Prod(Number(1), Number(2))
    println(show(exp2))
    val exp3 = Sum( Prod(Number(2), Var("x")), Var("y") )
    println(show(exp3))
    val exp4 = Prod( Sum(Number(2), Var("x")), Var("y"))
    println(show(exp4))
  }

  def eval(e : Expr): Int = e match {
    case Number(n) => n
    case Sum(a, b) => eval(a) +eval(b)
  }

  def show(e: Expr) : String = e match {
    case Number(n) => n.toString
    case Sum(a, b) => "("+ show(a) + " + " + show(b) + ")"
    case Var(a) => a
    case Prod(a, b) => "(" + show(a) + " * " + show(b) +")"
  }
}

trait Expr
case class Number(n: Int) extends Expr
case class Sum(a: Expr, b: Expr) extends Expr
case class Prod(a: Expr, b: Expr) extends Expr
case class Var(a: String) extends Expr


/*
object Number {
  def apply(n: Int) = new Number(n)
}
object Sum {
  def apply(n: Expr, n1 : Expr) = new Sum(n, n1)
}*/
