package uk.rajesh.avoidmutable

/**
  * Created by rajes on 17-Dec-16.
  */
object FibonacciTraditional {
  def fibonacci(n: Int): Int = {
    var a = 0
    var b = 1
    var i = 0
    while (i < n) {
      val previous_a = a;
      a = b
      b = previous_a + b
      i = i + 1
    }
    a
  }

  def main(a: Array[String]): Unit = {
    val fib4 = fibonacci(4)
    println(s"The fibonacci for 4 is ${fib4}")
  }
}
