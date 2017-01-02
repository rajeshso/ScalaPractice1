package recfun

import org.junit.runner.RunWith

@RunWith(classOf[JUnitRunner])
class BalanceSuite extends FunSuite {

  test("balance: '()' is balanced") {
    assert(balance("()".toList))
  }

  test("balance: '(' is balanced") {
    assert(!balance("(".toList))
  }

  test("balance: '(if (zero? x) max (/ 1 x))' is balanced") {
    assert(balance("(if (zero? x) max (/ 1 x))".toList))
  }

  test("balance: 'I told him ...' is balanced") {
    println(balance("I told him (that it's not (yet) done).\n(But he wasn't listening)".toList))
    assert(balance("I told him (that it's not (yet) done).\n(But he wasn't listening)".toList))
  }

  test("balance: 'I told him ...' is unbalanced") {
    assert(!balance("I told him (that it's not (yet) done).\n(But he wasn't listening))".toList))
  }

  test("balance: ':-)' is unbalanced") {
    assert(!balance(":-)".toList))
  }

  test("balance: counting is not enough") {
    assert(!balance("())(".toList))
  }
  test("balance: counting is not enough because of extra closing brackets") {
    assert(!balance("())())".toList))
  }

}
