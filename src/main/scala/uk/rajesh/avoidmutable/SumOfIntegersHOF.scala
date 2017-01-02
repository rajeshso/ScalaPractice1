package uk.rajesh.avoidmutable

/**
  * Created by E797240 on 24/12/2016.
  */
object SumOfIntegersHOF {
  def sumInts(a: Int, b: Int) : Int = {
    if (a>b) 0 else a+ sumInts(a+1,b)
  }

  def cube(a:Int) : Int = a*a*a

  def sumOfCubes(a:Int, b: Int) : Int = {
    if (a>b) 0 else cube(a) + sumOfCubes(a+1,b)
  }

  def factorial(a: Int) : Int = {
    if (a==0) 1 else a * (a-1)
  }

  def sumOfFactorials(a:Int, b:Int) : Int = {
    if (a>b) 0 else factorial(a) + sumOfFactorials(a+1, b)
  }
  def id(a: Int) : Int = a

  //Higher order functions of the same above methods - Linear recursion
  def sum(f: (Int) => Int, a: Int, b: Int) : Int = {
    if (a>b) 0 else f(a) + sum(f, a+1, b)
  }

  def sumInts1(a: Int, b: Int) : Int = sum(id, a,b)

  //Higher order functions of the same above methods - Tail recursion
  def sumTail(f: Int => Int) (a : Int, b : Int) : Int = {
    def loop(newB: Int, accumulator : Int) : Int = {
      if (newB<a) accumulator
      else loop(newB-1, f(newB)+accumulator)
    }
    loop(b, 0)
  }
  def sumTailMartin(f: Int => Int) (a : Int, b : Int) : Int = {
    def loop(a: Int, accumulator : Int) : Int = {
      if (a>b) accumulator
      else loop(a+1, f(a)+accumulator)
    }
    loop(a, 0)
  }

  //Curried Functions for the above functionalities - used linear recursion
  def sumCurry(f: Int=> Int) : (Int, Int) => Int = {
    def loop(a: Int, b : Int) : Int = {
      if (a>b) 0
      else f(a) + loop(a+1,b)
    }
    loop
  }

  def sumIntsCurryUser = sumCurry(x=>x)
  def sumCubesCurryUser = sumCurry(x=>x*x*x)
  def sumFactorialCurryUser = sumCurry(factorial)

  //Curried functions - consective stepwise applications
  val sumOfIntsResult : Int = sumCurry(id)(1,3)
  val sumOfCubesResult : Int = sumCurry(cube)(1,3)
  val sumOfFactorialResult : Int = sumCurry(factorial)(1,3)

  //Curried functions - Another way to express
  def sum1(f: Int => Int) (a : Int, b : Int) : Int =
    if (a>b) 0 else f(a) + sum1(f)(a+1, b)


  def main(args: Array[String]) {
    println(s"The factorial of 4 is ${factorial(4)}" )
    println(s"The sum of ints 1-3 by traditional is ${sumInts(1,3)} and by High Order functions is ${sum(id,1,3)}")
    println(s"The sumOfFactorials of 1-3 by traditional is ${sumOfFactorials(1,3)} and by High Order functions is ${sum(factorial,1,3)}")
    println(s"The sumOfCubes of 1-3 by HOF is ${sum(cube,1,3)} and by Anonymous High Order functions is ${sum((x:Int) => x*x*x,1,3)}")
    println(s"The sum of integers by Tail recursive HOF is ${sumTail{i=>i}(1,3)}")
    //println(s"The sum of integers by Tail recursive HOF is ${sumTail{i=>i}(10,15)}")
    println(s"The sum of cubes by Tail recursive HOF is ${sumTail{cube}(1,3)}")
    println(s"The sum of cubes by Tail recursive and annonymous HOF is ${sumTail{i=>i*i*i}(1,3)}")
    println(s"The sum of Factorials by Tail recursive HOF is ${sumTail(factorial)(1,3)}")
  }
}
