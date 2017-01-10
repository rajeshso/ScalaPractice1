package uk.rajesh.avoidmutable

/**
  * Created by E797240 on 10/01/2017.
  */
class LearnCollections {

}

object LearnCollections extends App {
  //Vector
  val nums : Vector[Int] = Vector(1,2,3,-90)
  val people : Vector[String] = Vector("Rajesh", "Raghavendran", "Karthik")
  println("nums = "+ nums)
  val numsPrefixed : Vector[Int] = 0 +: nums //Always the sequence should have :
  println("numsPrefixed = "+ numsPrefixed)
  val numsSuffixed : Vector[Int] = nums :+ 100
  println("numsSuffixed = "+ numsSuffixed)
  val a = Vector(1):+2:+3

  //Array's map
  val xs : Array[Int] = Array(1,2,3)
  val arrayMap = xs.map(x=>x*x)
  println("Array's map "+ arrayMap(0) + " "+ arrayMap(1) + " "+ arrayMap(2))

  //String's filter
  val ss : String = "Hello World"
  println("ss map " + ss.filter(x=>x.isUpper))

  //Ranges
  val r1: Range = 1 until 5
  val r2: Range = 1 to 10 by 3
  println("Range r1 = " + r1)
  println("Range r2 = " + r2)

  //Some more Sequence operations
  println("ss exists upper = " + (ss exists (c=>c.isUpper)))
  println("xs forAll positiveIntegers = " + (xs.forall(c=> c>0)))
  println("ss usage of flatMap = " + (ss.flatMap(c=> scala.collection.immutable.List('.',c))))
  val pairs : scala.collection.immutable.List[(Int, Char)] = scala.collection.immutable.List(1,2,3) zip ss
  println("merge two lists and create a pair list = "+ pairs)

  //List all possible combinatoins of sequences
  println("Possible combinations = ")
  println((1 to 2) flatMap( x=> (3 to 4) map (y=> (x,y)) ) )

  def isPrime(n: Int) : Boolean = {
    //(2 to n-1) forall( x=> n%x!=0)
    (2 until n) forall( x=> n%x!=0)
  }
  println("isPrime 1 = "+ isPrime(1))
  println("isPrime 10 = "+ isPrime(10))
  println("isPrime 11 = "+ isPrime(11))
}