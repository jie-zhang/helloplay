package controllers

import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._

import models._
import views._

object Salons extends Controller {

  def index = Action {
    val salons: Seq[Salon] = Salon.findAll()
    Ok(views.html.salon.overview(salons))
  }

  
  def getSalon(salonId: Long) = Action {
    val salon: Seq[Salon] = Salon.findById(salonId)
    Ok(views.html.salon.overview(salon))
  }


}
