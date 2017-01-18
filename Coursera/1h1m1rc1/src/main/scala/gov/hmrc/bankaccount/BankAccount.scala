package gov.hmrc.bankaccount
import scala.math.BigDecimal.RoundingMode

sealed trait Account {
  val INTEREST_BAND_FOR_PRINCIPAL_LESS_THAN_999 = 0.01
  val INTEREST_BAND_FOR_PRINCIPAL_BTW_1000_AND_5000 = 0.02
  val INTEREST_BAND_FOR_PRINCIPAL_MORETHAN_5000 = 0.03
}
class BankAccount extends Account {
    def getAmountOfInterst(principal : Double) : Double = {
      var interest : Double = 0.0
      if (principal<1000)
        interest = principal*INTEREST_BAND_FOR_PRINCIPAL_LESS_THAN_999
      else if (principal<5000)
        interest = principal*INTEREST_BAND_FOR_PRINCIPAL_BTW_1000_AND_5000
      else
        interest = principal*INTEREST_BAND_FOR_PRINCIPAL_MORETHAN_5000
    Math.max(round(interest) , 0)
  }
  def round(a : Double): Double = BigDecimal(a).setScale(2, RoundingMode.HALF_UP).toDouble
}
