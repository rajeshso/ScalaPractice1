package uk.rajesh.avoidmutable

/**
  * Created by E797240 on 24/12/2016.
  */
class TestSumOfIntegersHOF extends UnitSpec {

  val factorial : (Int=>Int) = SumOfIntegersHOF.factorial

  "Sum of Integers of 1 to 3 by traditional and hof" should "result in 6" in {
    SumOfIntegersHOF.sumInts(1,3) should be (SumOfIntegersHOF.sum(SumOfIntegersHOF.id, 1,3))
  }

  "Sum of Cubes of 1 to 3 by traditional and hof" should "be same as in the HOF" in {
    SumOfIntegersHOF.sumOfCubes(1,3) should be (SumOfIntegersHOF.sum(SumOfIntegersHOF.cube, 1,3))
  }

  "Sum of Factorials of 1 to 3 by traditional and hof" should "be same as in the HOF" in {
    SumOfIntegersHOF.sumOfFactorials(1,3) should be (SumOfIntegersHOF.sum(SumOfIntegersHOF.factorial    , 1,3))
  }

  "Sum of Integers of 1 to 3 by using Curried function" should "result in 6" in {
    SumOfIntegersHOF.sumInts(1,3) should be (SumOfIntegersHOF.sumIntsCurryUser( 1, 3))
  }

  "Sum of Cubes of 1 to 3 by using Curried function" should "be same as in the HOF" in {
    SumOfIntegersHOF.sumOfCubes(1,3) should be (SumOfIntegersHOF.sumCubesCurryUser(1,3))
  }

  "Sum of Factorials of 1 to 3 by using Curried function" should "be same as in the HOF" in {
    SumOfIntegersHOF.sumOfFactorials(1,3) should be (SumOfIntegersHOF.sumFactorialCurryUser(1,3))
  }

  "Sum of Factorials of 1 to 3 by using Curried function expression" should "be same as in the HOF" in {
    SumOfIntegersHOF.sumOfFactorials(1,3) should be (SumOfIntegersHOF.sum1(factorial)(1,3))
  }
}
