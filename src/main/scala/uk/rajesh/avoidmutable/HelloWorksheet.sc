//This is not tail recursion because the value of n for every call is retained till the completion
def factorial(n: Int): Int = if (n == 0) 1 else n * factorial(n - 1)
factorial(2)

//This is an example of tail recursion. This is efficient
def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
gcd(4, 2)

def factorialTailRecursive(n: Int): Int = {
  def fact(currentValue: Int, accumulator: Int): Int = {
    if (currentValue == 1) currentValue * accumulator else fact(currentValue - 1, currentValue * accumulator)
  }

  fact(n - 1, n)
}
factorialTailRecursive(4)
// 4 = 4*3*2*1