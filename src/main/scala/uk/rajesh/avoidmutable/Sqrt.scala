package uk.rajesh.avoidmutable

object Sqrt {

  /*  def abs(d: Double) = if (d<0) -d else d

    def isGoodEnough(guess: Double, x: Double) = abs(guess * guess - x) < 0.001

    def improve(guess: Double, x: Double) = (guess + x/guess) /2

    def sqrtIter(guess: Double, x: Double) : Double = if (isGoodEnough(guess, x)) guess else sqrtIter(improve(guess: Double, x: Double), x)

    def sqrt(x: Double) = sqrtIter(1.0,x)*/

  def sqrt(x: Double) = {
    def abs(d: Double) = if (d < 0) -d else d

    def isGoodEnough(guess: Double, x: Double) = abs(guess * guess - x) < 0.001

    def improve(guess: Double, x: Double) = (guess + x / guess) / 2

    def sqrtIter(guess: Double, x: Double): Double = if (isGoodEnough(guess, x)) guess else sqrtIter(improve(guess: Double, x: Double), x)

    sqrtIter(1.0, x)
  }
}
