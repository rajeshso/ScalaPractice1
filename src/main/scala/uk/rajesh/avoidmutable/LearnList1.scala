package uk.rajesh.avoidmutable

/**
  * Created by e797240 on 09/01/2017.
  */
object LearnList1 extends App {

  val list1 = 1::2::3::4::5::6::Nil
  val list2 = 7::8::9::10::11::12::Nil
  println("list1.length = " + list1.length)
  println("list1.head = "+list1.head)
  println("list1.tail = "+ list1.tail)
  println("list1.init = "+ list1.init)
  println("list1.take = "+ list1.take(3))
  println("list1.drop = "+ list1.drop(3))
  println("list1.dropWhile = "+ list1.dropWhile(i=> i<3))
  println("list1(3) = "+ list1(3))
  println("list1::list2 = ")
  println(list1::list2)
  println("list1:::list2 = ")
  println(list1:::list2)
  println("list1++list2 = ")
  println(list1++list2)
  println("list1 updated (n,x) = "+ list1.updated(3,0))
  println("list1 indexOf 2 = "+ list1.indexOf(2))
  println("list1 indexOf 2000 = "+ list1.indexOf(2000))
  def removeAt[T](n:Int, xs: scala.collection.immutable.List[T]) = xs.take(n) ::: xs.drop(n+1)
  println("LearnList1.removeAt = "+ removeAt(2, 1::2::3::Nil ))

  //Tuples
  def merge(xs:scala.collection.immutable.List[Int], ys: scala.collection.immutable.List[Int] ) : scala.collection.immutable.List[Int] = (xs, ys) match {
    case (Nil, ys) => ys
    case (xs, Nil) => xs
    case (x::xs1, y::ys1) => if (x < y) x:: merge(xs1, ys) else y:: merge(xs, ys1)
  }
  println("LearnList1.merge using Tuples = "+ merge(List(2,4,1), List(5,6,3) ))

  def squareList1(xs: scala.collection.immutable.List[Int]): scala.collection.immutable.List[Int] =
    xs match {
      case Nil => Nil
      case y :: ys => (y*y) :: squareList1(ys)
    }

  def squareList2(xs: scala.collection.immutable.List[Int]): scala.collection.immutable.List[Int] =
    xs map (x => x*x)
  println("LearnList1.squareList1 = "+ squareList1(scala.collection.immutable.List(2,4,1)))
  println("LearnList1.squareList2 = "+ squareList2(scala.collection.immutable.List(2,4,1)))

  def positiveElements1(xs: scala.collection.immutable.List[Int]) : scala.collection.immutable.List[Int] =
    xs match {
      case Nil => xs
      case y::ys => if (y>0) y::positiveElements1(ys) else positiveElements1(ys)
    }
  def positiveElements2(xs: scala.collection.immutable.List[Int]) : scala.collection.immutable.List[Int] =
    xs filter (x => x>0)
  println("LearnList1.positiveElements1 = "+ positiveElements1(scala.collection.immutable.List(2,-4,1)))
  println("LearnList1.positiveElements2 = "+ positiveElements2(scala.collection.immutable.List(2,-4,1)))
  println("LearnList1.positiveElements filterNot = "+ scala.collection.immutable.List(2,-4,1).filterNot(x=> x<0))
  val tupleElements: (scala.collection.immutable.List[Int], scala.collection.immutable.List[Int]) = scala.collection.immutable.List(2,-4,1) partition(x=>x>0)
  println("LearnList1.positiveElements partition 1 = "+ tupleElements._1)
  println("LearnList1.positiveElements partition 2 = "+ tupleElements._2)
  println("LearnList1.positiveElements- prefix takeWhile = "+ scala.collection.immutable.List(2,-4,1).takeWhile(x=> x>0))
  println("LearnList1.positiveElements- dropWhile (See this as a complete inverse of takeWhile, the suffix) dropWhile = "+ scala.collection.immutable.List(2,-4,1,-3).dropWhile(x=> x>0))
  println("LearnList1.positiveElements- span (This creates a tuple of takeWhile and dropWhile) = "+ scala.collection.immutable.List(2,-4,1,-3).span(x=> x>0))

/*  def pack[T](xs : scala.collection.immutable.List[T]) : scala.collection.immutable.List[scala.collection.immutable.List[T]] =
    xs match {
      case Nil => Nil
      case x :: xs1 => List(xs.takeWhile(y => y.equals(x))) ::: pack(xs1)
    }*/
  def pack[T](xs : scala.collection.immutable.List[T]) : scala.collection.immutable.List[scala.collection.immutable.List[T]] =
    xs match {
      case Nil => Nil
      case x :: xs1 =>
        val (first, rest) = xs span (y => y==x )
        first :: pack(rest)
  }
  //pack(List("a", "a", "a", "b", "c", "c", "a")) should result in List(List("a", "a", "a"), List("b"), List("c", "c"), List("a"))
  println("LearnList1.pack = "+ pack(scala.collection.immutable.List("a", "a", "a", "b", "c", "c", "a")))

  //encode(List("a", "a", "a", "b", "c", "c", "a")) should result in List(("a", 3), ("b", 1), ("c", 2), ("a", 1))
  def encode[T](xs : scala.collection.immutable.List[T]) : scala.collection.immutable.List[(T, Int)] = {
/*    val packed : scala.collection.immutable.List[scala.collection.immutable.List[T]] = pack(xs)
    packed match {
      case Nil => Nil
      case y::ys =>
        val tuple : (String, Int) = (y(0).toString, y.length)
        tuple::encode(ys)
    }*/
    pack(xs) map (ys => (ys.head, ys.length))
  }
  println("LearnList1.encode = "+ encode(scala.collection.immutable.List("a", "a", "a", "b", "c", "c", "a")))

  println("LearnList1.insert operators between elements sum (left) = "+ (1::2::3::4::Nil).reduceLeft((x,y)=>x+y))// Only for non empty list
  println("LearnList1.insert operators between elements product (left) = "+ (1::2::3::4::Nil).reduceLeft(_*_)) // Only for non empty list

  println("LearnList1.insert operators between elements sum (left) = "+ (1::2::3::4::Nil).foldLeft(0)((x,y)=>x+y))// 0 is the accumulator starts with x=0
  println("LearnList1.insert operators between elements product (left) = "+ (1::2::3::4::Nil).foldLeft(1)(_*_)) // 1 is the accumulator

  println("LearnList1.insert operators between elements sum (right) = "+ (1::2::3::4::Nil).reduceRight((x,y)=>x+y))// Only for non empty list
  println("LearnList1.insert operators between elements product (right) = "+ (1::2::3::4::Nil).reduceRight(_*_)) // Only for non empty list

  println("LearnList1.insert operators between elements sum (right) = "+ (1::2::3::4::Nil).foldRight(0)((x,y)=>x+y))// 0 is the accumulator starts with x=0
  println("LearnList1.insert operators between elements product (right) = "+ (1::2::3::4::Nil).foldRight(1)(_*_)) // 1 is the accumulator

  //concat using foldRight
  def concat[T](xs: scala.collection.immutable.List[T], ys: scala.collection.immutable.List[T]) : scala.collection.immutable.List[T] =
    xs.foldRight(ys)(_::_)

  println("LearnList1.foldRight applications = "+ concat((1::2::3::4::Nil), (5::6::7::8::Nil)))
}

class LearnList1 {

  def last[T](xs: scala.collection.immutable.List[T]) : T = xs match {
    case scala.collection.immutable.List() => throw new Error("last of empty list")
    case scala.collection.immutable.List(x) => x
    case y :: ys => last(ys)
  }
  def init[T](xs: scala.collection.immutable.List[T]): scala.collection.immutable.List[T] = xs match {
    case scala.collection.immutable.List() => throw new Error("init of empty list") //0 element
    case scala.collection.immutable.List(x) => List() //1 element
    case y::ys => y::init(ys) //2 or more elements
  }
/*  def removeAt[T](n: Int, xs: scala.collection.immutable.List[T]) : scala.collection.immutable.List[T] =  {
    def removeAt1[T](n: Int, index: Int, xs: scala.collection.immutable.List[T]) : scala.collection.immutable.List[T] = xs match {
      case scala.collection.immutable.List() => throw new Error("Empty List") //0
      case scala.collection.immutable.List(x) if (n==0) => List()   //1
      case scala.collection.immutable.List(x) => xs //1
      case y::ys =>  if (n==index) removeAt1(n, index+1, ys) else y::removeAt1(n, index+1, ys)
    }
    removeAt1(n,0,xs)
  }*/
}