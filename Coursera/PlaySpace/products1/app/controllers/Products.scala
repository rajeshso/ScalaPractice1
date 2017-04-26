package controllers

import javax.inject.{Inject, Singleton}

import play.api.mvc.{Action, Controller}
import models.Product

/**
  * Created by rajesh on 22/03/17.
  */
@Singleton
class Products @Inject() extends Controller {
  def list = Action {
    implicit request =>
      val products = Product.findAll
      Ok(views.html.products.list(products))
  }
}
