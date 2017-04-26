package uk.gov.hmrc.greet

/**
  * Created by rajesh on 28/02/17.
  */
object Week5 {
  def init[T](xs: List[T]): List[T] = xs match {
    case List() => throw new Error("init of empty list")
    case List(x) => List()
    case y :: ys => y::init(ys)
  }

  def removeAt[T](n: Int, xs: List[T]) : List[T] = (xs take n) ::: (xs drop(n+1))
  def flatten(xs: List[Any]): List[Any] = xs match {
    case Nil => Nil
    case (head: List[_]) :: tail => flatten(head) ++ flatten(tail)
    case head :: tail => head :: flatten(tail)
  }

  def factorByLinearRecursion(xs:List[Int], fact: Int) : List[Int] = xs match {
    case Nil => xs
    case y::ys => y*fact :: factorByLinearRecursion(ys,fact)
  }

  def factorByListMap(xs:List[Int], fact: Int) : List[Int] = xs.map((x: Int) => fact*x)

  def squareByLinearRecursion(xs: List[Int]) : List[Int] = xs match {
    case Nil => xs
    case y::ys => y*y :: squareByLinearRecursion(ys)
  }

  def squareByMap(xs: List[Int]) : List[Int] = xs map( (x:Int) => x*x)

  def filterByLinearRecursion(xs: List[Int]) : List[Int] = xs match {
    case Nil => xs
    case y::ys => if (y>0) y::filterByLinearRecursion(ys) else filterByLinearRecursion(ys)
  }

  def filterByMap(xs: List[Int]) = xs.filter(x=> x>0)

  def pack[T](xs: List[T]) : List[List[T]] = xs match {
    case Nil => Nil
    case y::_ =>
      val (first, rest) = xs span (everyY => everyY == y)
      first::pack(rest)
  }
  def encode[T](xs: List[T]) : List[List[(T,Int)]] = {
    val packed : List[List[T]] = pack(xs)
    packed.map((everyList)=> List((everyList.head,everyList.size)))
  }

  def sumOfListElements(xs: List[Int]) : Int = xs reduceLeft((x,y)=> x+y) // xs reduceLeft(_ + _)

  def sumOfListElementsWithAccumulator(xs: List[Int], accumulator: Int) : Int = xs.foldLeft(accumulator) ((x,y)=> x+y) // xs reduceLeft(_ + _)

  def sumOfListElementsByReduceRight(xs: List[Int]) : Int = xs reduceRight((x,y)=> x+y) // xs reduceLeft(_ + _)

  def sumOfListElementsWithAccumulatorByFoldRight(xs: List[Int], accumulator: Int) : Int = xs.foldRight(accumulator) ((x,y)=> x+y) // xs reduceLeft(_ + _)

  def lengthFun[T](xs: List[T]): Int =
    (xs foldRight 0)( (x,y) =>y+1 )

  def rangeRovers() : Unit = {
    val r1: Range = 1 to 5
    val r2: Range = 1 until 5
    println( 1 to 10 by 2)
    println( 6 to -1 by -2)
  }

  def listFunctions(): Unit = {
    val xs : Array[Int] = Array(1,2,3,4,5)
    val s = "HelloWorld"

    println(s filter (_.isUpper))
    println(s exists(_.isDigit))
    println(s forall(_.isLetter))
    println( (xs zip s) forall(x=> {print("("+x._1+" "+x._2+")" ) ;true}) )
    println( s flatMap(c=> List('.',c)))
  }

  def main(args: Array[String]): Unit = {
    val myList: List[Int] = 1 :: 2 :: -1 :: 0:: 3:: 4:: 5:: Nil
   // println(removeAt(1, myList))
    //println(flatten(List(List(1, 1), 2, List(3, List(5, 8)))))
    println(factorByLinearRecursion(myList,2))
    println(squareByLinearRecursion(myList))
    println(squareByMap(myList))
    println(filterByLinearRecursion(myList))
    println(filterByMap(myList))
    println(myList.filterNot(x=>x>0))
    println(myList.partition(x=>x>0))

    val data = List("a","a","a","b","c","c","a")
    println(pack(data))
    println(encode(data))

    println(sumOfListElements(myList))
    println(sumOfListElementsWithAccumulator(myList, 100))

    println(sumOfListElementsByReduceRight(myList))
    println(sumOfListElementsWithAccumulatorByFoldRight(myList, 100))

    println ( myList.foldRight(data)(_.toString :: _))
    rangeRovers
    listFunctions
  }
}
