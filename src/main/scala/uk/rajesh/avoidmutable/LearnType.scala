package uk.rajesh.avoidmutable
import java.util.NoSuchElementException
//Refer the note for the problem definition or refer Martin's Week 3-Lecture 3.3 excercise
object LearnType {
 def singleton[T](element : T) = new Cons[T](element, new Nil[T])

  def create10List(i: Int): List[Int] = {

    def createList(accumulatorIndex : Int, start : Int, accumulatorList : List[Int]) : List[Int] = {
      if (accumulatorIndex == 0) {
        accumulatorList
      }
      else {
        val newListElement = new Cons[Int](start, accumulatorList)
        createList(accumulatorIndex-1, start-1, newListElement)
      }
    }
    createList(10,i, new Nil[Int])
  }

  def nthList(i: Int, list: List[Int]): Int = {
    def loop(remainingIndex : Int, remainingList : List[Int]) : Int = {
      if (remainingList.isEmpty)
        throw new NoSuchElementException("No element in the index "+i)
      else if (remainingIndex==i) {
        remainingList.head
      }else {
        loop(remainingIndex+1, remainingList.tail)
      }
    }
    //if (i<0 || i>10) throw new IndexOutOfBoundsException("The position is outside the range")
    loop(1,list)
  }

  def main(args: Array[String]) : Unit = {
   singleton[Int](1) //Examples of the use of Type in methods
   singleton[Boolean](true) //Examples of the use of Type in methods

   val list : List[Int] = create10List(100)
    //println(nthList(0, list))
    println(nthList(1, list))
    println(nthList(2, list))
    println(nthList(3, list))
    println(nthList(4, list))
    println(nthList(5, list))
    println(nthList(6, list))
    println(nthList(7, list))
    println(nthList(8, list))
    println(nthList(9, list))

    println(nthList(19, list))

 }

}

trait List[T] {
  def isEmpty : Boolean
  def head : T
  def tail : List[T]
}

class Cons[T](val head: T, val tail: List[T]) extends List[T] {
  override def isEmpty: Boolean = false
  override def toString: String = "" + head + ""
}

class Nil[T] extends List[T] {
  override def isEmpty: Boolean = true

  override def tail: Nothing = throw new NoSuchElementException("You have reached Nil.tail")

  override def head: Nothing = throw new NoSuchElementException("You have reached Nil.head")
  override def toString: String = "Nil"
}
