package uk.gov.hmrc.greet

/**
  * Created by rajesh on 21/02/17.
  */
class Week2 {

  // Take the sum of integers between a and b
  def sumInts(a:Int, b:Int) : Int = if (a>b) 0 else a+ sumInts(a+1, b)

  //Take the sum of cubes of all the integers between a and b
  def cube(x: Int) : Int = x*x*x
  def sumCubes(a:Int, b:Int) : Int = if (a>b) 0 else cube(a) + sumCubes(a+1,b)

  //Take the sum of the factorials of all the integers between a and b
  def fact(a: Int) : Int = if (a==0) 1 else a*fact(a-1)
  def sumFact(a: Int, b: Int) : Int = if (a>b) 0 else fact(a) + sumFact(a+1,b)

}

class Week2HOF {
  def sum(f: (Int)=>(Int), a:Int, b:Int) : Int = if (a>b) 0 else f(a) + sum(f, a+1, b)
}

class Week2LinearRecursion {
  def sum(f: Int => Int)(a: Int, b: Int): Int = {
    def loop(a: Int, acc: Int): Int = {
      if (a>b) acc
      else loop(a+1, f(a)+acc)
    }
    loop(a, 0)
  }
}

class Week2Currying {
  def sum(f: Int => Int) : (Int, Int)=> Int =  {
    def sumFunction(a: Int, b: Int): Int = {
      if (a>b) 0
      else f(a) + sumFunction(a+1, b)
    }
    sumFunction
  }

  def sumInts = sum(x=>x)
  def sumCubes = sum(x=>x*x*x)
  def sumFact = sum(new Week2().fact)
}

class Week2CurryProduct {
  def product(f: Int => Int) : (Int, Int)=> Int =  {
    def productFunction(a: Int, b: Int): Int = {
      if (a>b) 1
      else f(a) * productFunction(a+1, b)
    }
    productFunction
  }

  def productInts = product(x=>x)
  def productCubes = product(x=>x*x*x)
  def productFact = product(new Week2().fact)
}
class Week2CurryArithmetic {
  def arithmetic(f: Int => Int, combine: (Int,Int) => Int, zero:Int) : (Int, Int)=> Int =  {
    def arithmeticFunction(a: Int, b: Int): Int = {
      if (a>b) zero
      else combine( f(a) , arithmeticFunction(a+1, b))
    }
    arithmeticFunction
  }

  def sum(a:Int, b:Int) : Int = a+b
  def product(a:Int, b:Int) : Int = a*b

  def productInts = arithmetic(x=>x, product,1)
  def productCubes = arithmetic(x=>x*x*x, product,1)
  def productFact = arithmetic(new Week2().fact, product,1)

  def sumInts = arithmetic(x=>x, sum,0)
  def sumCubes = arithmetic(x=>x*x*x, sum,0)
  def sumFact = arithmetic(new Week2().fact, sum,0)
}
object Week2 {
  def main(args: Array[String]): Unit = {
    println("Hello World")
    val w = new Week2()
    println("Sum = "+ w.sumInts(1,3))
    println("Sum of Cubes = "+ w.sumCubes(1,3))
    println("Sum of Factorials = "+ w.sumFact(1,3))
    println("----")

    val w1 = new Week2HOF
    println("Sum = "+ w1.sum(Int=>Int, 1,3))
    println("Sum of Cubes = "+  w1.sum(w.cube, 1,3))
    println("Sum of Factorials = "+  w1.sum(w.fact, 1,3))
    println("----")

    println("Sum = "+ w1.sum(x=>x, 1,3))
    println("Sum of Cubes = "+  w1.sum((a:Int)=> a*a*a, 1,3))
    println("Sum of Factorials = "+  w1.sum(w.fact, 1,3))
    println("----")

    val w2 = new Week2LinearRecursion
    println("Sum = "+ w2.sum(x=>x)(1,3))
    println("Sum of Cubes = "+  w2.sum((a:Int)=> a*a*a) (1,3))
    println("Sum of Factorials = "+  w2.sum(w.fact) (1,3))
    println("----")

    val w3 = new Week2Currying
    println("Sum = "+ w3.sumInts(1,3))
    println("Sum of Cubes = "+  w3.sumCubes(1,3))
    println("Sum of Factorials = "+  w3.sumFact(1,3))
    println("----")

    println("Sum = "+ w3.sum(x=>x)(1,3))
    println("Sum of Cubes = "+  w3.sum (w.cube) (1,3))
    println("Sum of Factorials = "+  w3.sumFact(1,3))
    println("----")

    val w4 = new Week2CurryProduct
    println("Product = "+ w4.productInts(1,3))
    println("Product of Cubes = "+  w4.productCubes(1,3))
    println("Product of Factorials = "+  w4.productFact(1,3))
    println("----")

    val w5 = new Week2CurryArithmetic
    println("Sum = "+ w5.sumInts(1,3))
    println("Sum of Cubes = "+  w5.sumCubes(1,3))
    println("Sum of Factorials = "+  w5.sumFact(1,3))
    println("Product = "+ w5.productInts(1,3))
    println("Product of Cubes = "+  w5.productCubes(1,3))
    println("Product of Factorials = "+  w5.productFact(1,3))
    println("----")

    val c1: Vector[Int] = Vector(1,2,3) //Random access
    val c2: List[Int] = List(1,2,3) //Sequential access
    val c3: Map[Int, String] = Map(1->"one")
    val c4: Set[Int] = Set(1,2,3)

    //For Expressions
    val c5: IndexedSeq[(Int, Int)] = (1 until 5).flatMap( i=>
      (1 until 5).filter(j => i+j>10)
       map(j => (i,j))
    )
    for {
      i <- c1
      j <- c2
      i+j>10
    }yield (i,j)

  }
}
