package controllers

import play.api._
import play.api.mvc._

object ScalaApp extends Controller {

  def index = Action {
    println("Hello World...!")
    Ok(views.html.index("Your new application is ready."))
  }

}