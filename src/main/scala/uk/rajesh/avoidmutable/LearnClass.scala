package uk.rajesh.avoidmutable

/**
  * Created by E797240 on 26/12/2016.
  */
object LearnClass {
  def main(args: Array[String]) {
    val t1 = new NonEmpty(3, Empty, Empty)
    println(t1)
    val t2 = t1 incl 4
    println(t1) //same value because t1 is immutable
    println(t2)
  }
}

abstract class IntSet {
  def incl(x: Int) : IntSet
  def contains(x: Int) : Boolean
  def union(other: IntSet) : IntSet
}

/*class Empty extends IntSet {
  override def contains(x: Int) : Boolean = false
  override def incl(x: Int) : IntSet = new NonEmpty(x, new Empty, new Empty)
  override def toString = "."
}*/
//One enhancement to the Empty is to avoid creating multiple instances of Empty is by using an Object definition
object Empty extends IntSet {
  override def contains(x: Int) : Boolean = false
  override def incl(x: Int) : IntSet = new NonEmpty(x, Empty, Empty)
  override def toString = "."

  override def union(other: IntSet): IntSet = other
}

class NonEmpty(element: Int, left: IntSet, right: IntSet) extends IntSet {
  override def incl(x: Int): IntSet = {
    if (x< element) new NonEmpty(x, left incl x, right)
    else if (x> element) new NonEmpty(x, left, right incl x)
    else this
  }

  override def contains(x: Int): Boolean = {
    if (x < element) left contains x
    else if (x>element) right contains x
    else true
  }

  override def union(other: IntSet): IntSet = ((left union right) union other)  incl element

  override def toString = "{ "+ left + element + right + " }"
}

object Week4Example {
  def main(args: Array[String]) {
    val a : Array[NonEmpty] = Array(new NonEmpty(1, Empty, Empty))
/*    val b : Array[IntSet] = a //Throws Compile error - Expression of Type Array[NonEmpty] does not conform to Array[Empty]
    b(0) = Empty
    val s : NonEmpty = a(0)*/
  }
}
