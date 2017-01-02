package uk.rajesh.avoidmutable

import uk.rajesh.UnitSpec

class TestSqrt extends UnitSpec {
  "Sqrt" should "be 1.4 for" in {
    val sqrt = Sqrt
    sqrt.sqrt(2) should be(1.4142156862745097)
  }
}
