//Evaluation Rules
def example1 = 2
val example2 = 3
lazy val example3 = 4
def square1(x: Double) {}//Call by Value
def square2(x: => Double) {} //Call by Name - arg called if need be

//Higher Order Functions - Input is a function and output is a function
def sumf(f: Int => Int) : (Int, Int) => Int = {
  def sumInternal(x: Int, y: Int) : Int = {
    23
  }
  sumInternal
}

sumf((x: Int) => x*x*x)(1,2)

def cube(x: Int): Int = x*x*x
sumf(x=> x*x*x)(1,10)
sumf(cube)(1,10)

//Currying
def f1(a:Int, b:Int) : Int = 2 //Uncurried
def f2(a:Int)(b: Int) : Int = 3 //Curried

val a = f2(2)_
a(2)

//Type Parameters
class MyClass[TOO](a: TOO) {
  def whoAmI(): TOO = a
}
new MyClass[Int](100).whoAmI()
new MyClass[String]("Rajesh").whoAmI()

//Type Parameters
class TopLevel
class MiddleLevevl extends TopLevel
class BottomLevel extends MiddleLevevl

def myFunction1[T <: TopLevel](arg: T) = 1
myFunction1(new TopLevel())
myFunction1(new MiddleLevevl())
myFunction1(new BottomLevel())

def myFunction2[T >: TopLevel](arg: T) =1
myFunction2(new TopLevel())
myFunction2(new MiddleLevevl())
myFunction2(new BottomLevel())

(1 to 5).flatMap(x=> (6 to 10).map(y=>(x,y)))

var a1 = 10
var b1 = 5
a1 = a1 + b1
b1 = a1 - b1
a1 = a1 - b1

val one : PartialFunction[Int, String] = { case 1 => "one"}
val two : PartialFunction[Int, String] = { case 2 => "two"}
val wildcard : PartialFunction[Int,String] = {case _ => "something else"}
one.isDefinedAt(1)
one.isDefinedAt(3)
val p : PartialFunction[Int, String] = one.orElse(two).orElse(wildcard)
one(1)
p(4)

val divideFunction = (x: Int) => 42 /x
divideFunction(2)
// divideFunction(0) would be Arithmetic Exception
//This problem can be solved by making this a PartialFunction
val dividePartialFunction1 : PartialFunction[Int, Int] = new PartialFunction[Int, Int] {
  override def isDefinedAt(x: Int): Boolean = x!=0

  override def apply(v1: Int): Int = 42/v1
}
dividePartialFunction1(2)
dividePartialFunction1 isDefinedAt(0)
//dividePartialFunction1(0)

val dividePartialFunction2: PartialFunction[Int, Int] = {
  case d: Int if d != 0 => 42/d
}

dividePartialFunction2(0)
dividePartialFunction2(2)

