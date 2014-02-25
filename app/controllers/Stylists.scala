package controllers

import play.api._
import play.api.mvc._
import models.Stylist
import play.api.data._
import play.api.data.Forms._

import models._
import views._


object Stylists extends Controller {


  def index = TODO
  
   /**
   * 
   */
  def findById(styleId: Long) = Action { 

    val stylist: Seq[Stylist] = Stylist.findById(styleId)
    Ok(html.stylist.overview(stylist))

  }
  
  def findBySalon(salonId: Long) = Action {
    
    val stylistsOfSalon: Seq[Stylist] = Stylist.findBySalon(salonId)    
    Ok(html.stylist.overview(stylistsOfSalon))
    
  }
  



}
