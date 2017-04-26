package uk.gov.hmrc.greet

/**
  * Created by rajesh on 03/03/17.
  */
object Week6 {
  //list all combinations of numbers x and y where x is drawn from 1..M and y is drawn from 1..N
  def combinations(m: Int, n: Int) : Seq[(Int, Int)]  = (1 to m).flatMap(x=> (m+1 to n).map(y=>(x,y)))

  //Sigma i=1 to n. (xi * yi)
  def scalarProduct(xs: Vector[Int], ys: Vector[Int]) : Int = (xs zip ys).map(xy => xy._1*xy._2).sum

  def scalarProductByPatternMatching(xs: Vector[Int], ys: Vector[Int]) : Int = (xs zip ys).map{ case(x,y) => x*y}.sum

  def isPrime(n: Int) : Boolean = (2 until n-1).forall(x => n%x!=0)

  //Handling nested sequences using Higher order functions
  //Example : Given a positive integer n, find all pairs of positive integers i and j, with 1 <= j < i < n, such that i+j is prime
  //if n=7, the (j,i ) pairs for 7 are (1,2) , (2,3), (1,4), (3,4), (2,5), (1,6), (5,6)
  def findPairs(n: Int) : IndexedSeq[(Int, Int)]  = (1 until n).flatMap(j=> (j until n).map(i=> (j,i))).filter(ji => isPrime(ji._1+ ji._2))

  //for-expression example
  case class Person(name: String, age: Int)
  def personsOverAgeByFilter(persons: Vector[Person], n: Int) : Vector[String] = persons.filter(p => p.age>n).map(p=>p.name)
  def personsOverAgeByForExpression1(persons: Vector[Person], n:Int) : Vector[String] = for (p <-persons if p.age>n) yield p.name
  def personsOverAgeByForExpression2(persons: Vector[Person], n:Int) : Vector[String] = for (p <-persons; r = p.age; s= p.name; l= r+5; if p.age>n) yield p.name
  def scalarProductByPatternMatchingByForExpression(xs: Vector[Int], ys: Vector[Int]) : Int = ( for ( (x,y) <- xs zip ys) yield x*y ).sum

  //maps
  def mapLearn(): Unit = {
    val romanNumerals : Map[String, Int] = Map("I"->1, "II"->2, "III"->3)
    val capitalCountry : Map[String, String] = Map("US"-> "Washington", "UK"-> "London", "India"->"Delhi")
    println("I = "+ romanNumerals("I"))
    println("II = "+ romanNumerals("II"))
    println("V = "+ romanNumerals.get("V"))
  }

  def main(args: Array[String]): Unit = {
    println(combinations(5,10))
    println(scalarProduct(Vector(1,2),Vector(1, 2)))
    println(scalarProductByPatternMatching(Vector(1,2),Vector(1, 2)))
    println(isPrime(3))
    println(isPrime(5))
    println(findPairs(7))
    println(personsOverAgeByFilter(Vector(Person("Rajesh", 41), Person("Alam", 19)), 20))
    println(personsOverAgeByForExpression1(Vector(Person("Rajesh", 41), Person("Alam", 19)), 20))
    println(scalarProductByPatternMatchingByForExpression(Vector(1,2),Vector(1, 2)))
    mapLearn()
    println(List("Apple","Orange", "Pear").sortWith((x,y) => x.length> y.length))
    println(List("Apple","Orange", "Pear").sortWith(_.length > _.length))
    println(List("Apple","Orange", "Pear").sorted) //Natural ordering
    println(List("Pineapple", "Apple","Orange", "Pear").groupBy(_.head))
    println(List("Pineapple", "Apple","Orange", "Pear").groupBy((x)=> x.endsWith("e")))
    println(List("Pineapple", "Apple","Orange", "Pear").groupBy((x)=> x.length))
  }
}