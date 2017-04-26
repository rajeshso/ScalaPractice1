package models

/**
  * Created by rajesh on 09/03/17.
  */
case class Product (
  ean : Long, name: String, description: String
                   )
object Product {
  var products = Set (
    Product(1L, "Paperclips Large", "Large pack of Plain Paper clips"),
    Product(2L, "Paperclips Giant", "Giant pack of Plain Paper clips"),
    Product(3L, "Paperclips Giant Plain", "Giant Plain pack of 1000 Plain Paper clips"),
    Product(4L, "Paperclips No Tear", "No Tear Extra Large pack of Plain Paper clips"),
    Product(5L, "Paperclips Zebra", "Zebra length Large pack of Plain Paper clips")
  )
  def findAll : List[Product] = products.toList.sortBy(_.ean)
}