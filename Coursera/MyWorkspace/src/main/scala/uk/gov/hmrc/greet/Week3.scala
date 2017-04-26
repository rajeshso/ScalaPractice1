package uk.gov.hmrc.greet

import java.util.NoSuchElementException

/**
  * Created by rajesh on 23/02/17.
  */
class Week3 {

}
abstract class IntSet {
  def incl(x: Int): IntSet
  def contains(x: Int): Boolean
  def union(other: IntSet): IntSet
}

object Empty extends IntSet {
  override def incl(x: Int): IntSet = new NonEmpty(x, Empty, Empty)
  override def contains(x: Int): Boolean = false

  override def union(other: IntSet): IntSet = other
}

class NonEmpty(elem: Int, left: IntSet, right: IntSet) extends IntSet {
  override def incl(x: Int): IntSet = if (x<elem) new NonEmpty(elem, left incl x, right) else if (x>elem) new NonEmpty(elem, left, right incl x) else this

  override def contains(x: Int): Boolean = {
    if (x< elem) (left contains x)
    else if (x>elem) (right contains x)
    else true
  }

  override def union(other: IntSet): IntSet = ???
}

//Polymorphism
trait MyList[T] {
  def isEmpty: Boolean
  def head: T
  def tail: MyList[T]
}
class Cons[T](val head: T, val tail: MyList[T]) extends MyList[T] {
  override def isEmpty: Boolean = false
}

class Nil[T] extends MyList[T] {
  override def isEmpty: Boolean = true

  override def head: Nothing = throw new NoSuchElementException("Nil.head")

  override def tail: Nothing = throw new NoSuchElementException("Nil.tail")
}

object MyList {
  val list = new Cons(1, new Cons(2,new Cons(3, new Nil)))
  def find[T](position: Int, list: MyList[T] ) : T = {
      if (list isEmpty) throw new IndexOutOfBoundsException("No elements in list")
      if (position == 0) list.head else find(position-1, list.tail)
  }
  //Week 4 quiz
  //MyList()
  def apply() : MyList[Int] = new Nil()
  //MyList(1)
  def apply(x: Int) : MyList[Int] = new Cons[Int](x, new Nil[Int])
  //MyList(2,3)
  def apply(x1: Int, x2: Int) : MyList[Int] = new Cons[Int](x1, new Cons[Int](x2, new Nil()))

  def main(sds: Array[String]): Unit = {
    println( find(1,list))
    println( find(-1,list))
    println( find(100,list))
  }
}

