package uk.rajesh.avoidmutable

object InsertionSort {

  //Sort the list List(7,3,9,2) is to sort the tail List(3,9,2) to obtain List(2,3,9)
  def isort(xs: scala.collection.immutable.List[Int]) : scala.collection.immutable.List[Int] = xs match {
    case scala.collection.immutable.List() => scala.collection.immutable.List()
    case y :: rest => insert(y, isort(rest))
  }

  //The next step is to insert the head 7 in the right place to obtain the result List(2,3,7,9)
  def insert(x: Int, xs: scala.collection.immutable.List[Int]): scala.collection.immutable.List[Int] = xs match {
    case scala.collection.immutable.List() => List(x)
    case y :: ys => {
      if (x<=y) x :: xs else y :: insert(x, ys)

/*      if (x>y && x<=ys.head) ???
      else {
        insert(x, ys.tail)
      }*/
    }
    }

  def main(a : Array[String]) : Unit = {
    val x : scala.collection.immutable.List[Int] = 1 :: 3 :: 9 :: 7 :: Nil
    println(isort(x))
  }
}

