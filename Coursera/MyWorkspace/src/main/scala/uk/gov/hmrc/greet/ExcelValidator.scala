package uk.gov.hmrc.greet

/**
  * Created by rajesh on 30/03/17.
  */

import java.util.regex.Matcher
import java.util.regex.Pattern


object ExcelValidator extends App {
  private val EXCEL_PATTERN = "([^\\s]+(\\.(?i)(jpg|png|gif|bmp))$)"
  private val pattern = Pattern.compile(EXCEL_PATTERN)

  println(validate1("hello.jpg1"))
  /**
    * Validate image with regular expression
    *
    * @param image image for validation
    * @return true valid image, false invalid image
    */
  def validate1(image: String): Boolean = {
    val matcher: Matcher = pattern.matcher(image)
    matcher.matches
  }
  def validate2(image: String): Boolean = {
    val matcher: Matcher = pattern.matcher(image)
    matcher.matches
  }
}
