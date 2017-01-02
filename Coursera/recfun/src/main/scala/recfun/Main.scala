package recfun

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
    * Exercise 1
    */
  def pascal(c: Int, r: Int): Int = {
    if (c == 0 || c == r) 1 else (pascal(c - 1, r - 1) + pascal(c, r - 1))
  }

  /**
    * Exercise 2
    */
  def balance(chars: List[Char]): Boolean = {
    def f(chars: List[Char], numOpens: Int): Boolean = {
      if (chars.isEmpty) {
        numOpens == 0
      }
      else {
        val head = chars.head
        val n =
          if (head == '(') numOpens + 1
          else if (head == ')') numOpens - 1
          else numOpens
        if (n >= 0)
          f(chars.tail, n)
        else
          false
      }
    }

    f(chars, 0)
  }


  /*  val openChar = '('
    val closeChar = ')'
    def balance(chars: List[Char]): Boolean = {
    def isOpen(c: Char) = c == openChar

    def isClosed(c: Char) = c == closeChar

    def isMatchingClosePresent(charList: List[Char]) : Boolean = {
      if (!charList.isEmpty && !isClosed(charList.head)) false else true
    }

    if (isOpen(chars.head) && isMatchingClosePresent(chars.tail)) true else false
  }*/

  /**
    * Exercise 3
    */
  def countChange(money: Int, coins: List[Int]): Int = {
    if (money == 0)
      1
    else if (money > 0 && !coins.isEmpty) {
      var c1 = countChange(money - coins.head, coins);
      var c2 = countChange(money, coins.tail)
      c1 + c2
    }
    else
      0
  }
}