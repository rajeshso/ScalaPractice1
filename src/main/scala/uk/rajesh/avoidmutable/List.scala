package uk.rajesh.avoidmutable
import java.util.NoSuchElementException
// Week 4 - Lecture 4.2 Functions as Objects - Define an object List with three functions
// in it so that users can create lists of length 0-2 using syntax List(), List(1) and List(2, 3)
trait List[T] {
  def isEmpty: Boolean
  def head : T
  def tail : List[T]
}

class Cons[T](val head : T, val tail : List[T]) extends List[T] {
  def isEmpty = false
}

class Nil[T] extends List[T] {
  override def isEmpty: Boolean = true
  override def tail: List[T] = throw NoSuchElementException
  override def head: T = throw NoSuchElementException
}

object List {
  //List(1,2)
  def apply[T](x1: T, x2: T): List[T] = new Cons(x1, new Cons(x2, new Nil))
  //List(1)
  def apply[T](x: T): List[T] = new Cons(x, new Nil)
  //List()
  def apply[T]: List[T] = new Nil()

}