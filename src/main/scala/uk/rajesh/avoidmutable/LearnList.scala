package uk.rajesh.avoidmutable

/**
  * Week 4 - Lecture 4.7
  */
object LearnList extends App {

  //import scala.List
  import scala.collection.immutable.{List, Nil}

  val fruit = List("Apple", "Pear", "Orange")
  val nums = List(1, 2, 3)
  val diag3 = List(List(1, 0, 0), List(0, 1, 0), List(0, 0, 1))
  val empty = List()

  val fruit1 = List().::("a").::("b")
  // List("asdas").::"Apple" :: ("Pear" :: ("Orange"))
  val fruit2 = Nil.::("Apple").::("Pear").::("Orange")
  val nums1 = List().::(1).::(2).::(3)
  println(fruit.head + " " + fruit.tail.head + " " + fruit.tail.tail.head)
  println(fruit2.head + " " + fruit2.tail.head + " " + fruit2.tail.tail.head)
  val y = 1 :: 2 :: 3 :: Nil
  val x = "1"::"2"::"3"::Nil
  println(x.head + " " + x.tail.head + " " + x.tail.tail.head)
  val fruit3 = "Apple" :: "Pear" :: "Orange" ::  Nil
  println(fruit3.head + " " + fruit3.tail.head +   " " + fruit3.tail.tail.head)
  println("sum is "+ sum(y))
  import scala.collection.immutable.Nil
  def sum(list: scala.collection.immutable.List[Int]): Int = list match {
    case Nil => 0
    case n :: rest => n + sum(rest)
  }
  def multiply(list: scala.collection.immutable.List[Int]) : Int = list match {
    case Nil => 1
    case n :: rest => n * multiply(rest)
  }
  println("product is "+ multiply(y))
}

class LearnList {
  import scala.collection.immutable.Nil
  def sum(list: scala.collection.immutable.List[Int]): Int = list match {
    case Nil => 1
    case n :: rest => n + sum(rest)
  }
}