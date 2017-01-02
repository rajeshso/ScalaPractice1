package uk.rajesh.avoidmutable

/**
  * Created by E797240 on 25/12/2016.
  */
object ProductOfIntegers {
  //Write a Product function that calculates the product of the values of a function for the points on a given interval
  def product(a : Int, b: Int) : Int = {
    if (a>b) 1 else a * product(a+1, b)
  }
  //Write factorial in terms of a Product
  def factorial(b: Int) : Int = product(1,b)
  //Can you write a more general function, which generalizes both sum and product

  //Note the way zero is defined and used
  def mapReduce(combine: (Int, Int)=> Int, zero : Int)(a: Int, b: Int) : Int = {
    if (a>b) zero else combine(a, mapReduce(combine, zero)(a+1, b))
  }

  def prod(a: Int, b : Int) : Int = mapReduce((a,b)=>a*b,1)(a,b)
  def sum(a: Int, b : Int) : Int = mapReduce((a,b)=>a+b,1)(a,b)

  private class Rational(x: Int, y: Int){
    //Use this for prod
    require(y != 0, "Denominator must be non zero. Else you will receive a IllegalArgumentException")

    //Use this during development
    assert(y!=0, "Denominator must be non zero. Else you will receive an Assertion Error")

    def this(x: Int) = this(x,1)// Always there should be a lineage to the primary constructor

    def add(z: Int) = x+z

    def +(z: Int) = x+z
  }

  def main(args: Array[String]) {
    var p = product(1,3)
    println(s"The product function for interval 1-3 is ${p}")
    p = product(2,4)
    println(s"The product function for interval 2-4 is ${p}")
    val fact = factorial(5)
    println(s"The factorial for 5 is ${fact}")

    val sumCalc : Int= mapReduce((a : Int, b: Int)=>a+b,0)(1,3)
    val prodCalc : Int= mapReduce((a : Int, b: Int)=>a*b,1)(1,3)
    println(s"The sum of 1-3 is "+ sumCalc + " and product is "+ prodCalc)
    println(s"The sum of 5-7 is "+ sum(5,7) + " and product is "+ prod(5,7))

    //infix
    val r1 = new Rational(1,2)
    val r2 = new Rational(3,4)
    val r1Plus1 = r1.add(1)
    println("r1Plus1 = "+ r1Plus1)
    val r1Plus2 = r1 add 1
    println("r1Plus2 = "+ r1Plus2)
    val r1Plus3 = r1 + 1
    println("r1Plus3 = "+ r1Plus3)

  }
}
