package uk.rajesh.avoidmutable

/**
  * Created by E797240 on 29/12/2016.
  */
object LearnTypeRight {
  def nth[T](n: Int, xs: List[T]) : T = if (xs.isEmpty)
    throw new IndexOutOfBoundsException else if (n==0) xs.head else nth(n-1,xs.tail)

  def main(args: Array[String]) {
    val list : List[Int] = new Cons[Int](1, new Cons(2, new Cons(3, new Cons(4, new Nil))))
    println(nth(2, list))
    println(nth(-1, list))
  }
}
