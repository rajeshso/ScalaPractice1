package gov.hmrc.bankaccount

/**
  * Created by E797240 on 18/01/2017.
  */
class BankAccountTest extends UnitSpec {
  "MyBankAccount" should "not return exceptions on use" in {
    try {
      val myBank = new BankAccount()
      myBank.getAmountOfInterst(2.2)
    }catch {
      case _ => fail("Exception is not expected to use the bank account")
    }
  }
  //input is negative , output 0
  "Simple Interest" should "be 0 for negative balance" in {
      val myBank = new BankAccount()
      myBank.getAmountOfInterst(-2000.99) should be (0)
  }
  //input 0, output 0
  "Simple Interest" should "be 0 for 0 balance" in {
    val myBank = new BankAccount()
    myBank.getAmountOfInterst(0) should be (0)
  }
  //input 500, output 5
  "Simple Interest" should "be 0 for 500 balance" in {
    val myBank = new BankAccount()
    myBank.getAmountOfInterst(500) should be (5)
  }
  //input is 1222_1234567, output is 24_44
  "Simple Interest" should "be 24.44 for 1222.1234567, balance" in {
    val myBank = new BankAccount()
    myBank.getAmountOfInterst(1222.1234567) should be (24.44)
  }
  //input is 1222_349 , Output is 24_44
  "Simple Interest" should "be 24.44 for 1222.349, balance" in {
    val myBank = new BankAccount()
    myBank.getAmountOfInterst(1222.1234567) should be (24.44)
  }
  //input is 1000, output is 20
  "Simple Interest" should "be 1000 for 20, balance" in {
    val myBank = new BankAccount()
    myBank.getAmountOfInterst(1000) should be (20)
  }
  //input is 1001, output is 20.02
  "Simple Interest" should "be 20.02 for 1001, balance" in {
    val myBank = new BankAccount()
    myBank.getAmountOfInterst(1001) should be (20.02)
  }
  //input is 999,
  "Simple Interest" should "be 9.99 for 999, balance" in {
    val myBank = new BankAccount()
    myBank.getAmountOfInterst(999) should be (9.99)
  }
  //input is 999.99 , Output is 10.0
  "Simple Interest" should "be 999.99 for 10.0, balance" in {
    val myBank = new BankAccount()
    myBank.getAmountOfInterst(999.99) should be (10.0)
  }
  //input is 1000.01 , output is 20
  "Simple Interest" should "be 1000.01 for 20, balance" in {
    val myBank = new BankAccount()
    myBank.getAmountOfInterst(1000.01) should be (20)
  }
  //input is 2000 output is 40
  "Simple Interest" should "be 2000 for 40, balance" in {
    val myBank = new BankAccount()
    myBank.getAmountOfInterst(2000) should be (40)
  }
  //input is 5000
  "Simple Interest" should "be 5000 for 150, balance" in {
    val myBank = new BankAccount()
    myBank.getAmountOfInterst(5000) should be (150)
  }
  //4999.99 should be 100
  "Simple Interest" should "be 4999.99 for 100, balance" in {
    val myBank = new BankAccount()
    myBank.getAmountOfInterst(4999.99) should be (100)
  }
  //1000000 should be 30,000
  "Simple Interest" should "be 1000000 for 30000, balance" in {
    val myBank = new BankAccount()
    myBank.getAmountOfInterst(1000000) should be (30000)
  }
}
