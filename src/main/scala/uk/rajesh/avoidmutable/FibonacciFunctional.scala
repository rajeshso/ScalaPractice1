package uk.rajesh.avoidmutable

/**
  * Created by rajes on 17-Dec-16.
  */
object FibonacciFunctional {
  def fibonacci(n: Int): Int = {
    def fibonacciIter(i: Int, a: Int, b: Int): Int = {
      if (i == n) a else fibonacciIter(i + 1, b, a + b)
    }

    fibonacciIter(0, 0, 1)
  }

  def main(args: Array[String]): Unit = {
    val fib4 = fibonacci(4)
    println(s"The fibonacci for 4 is ${fib4}")
  }
}
