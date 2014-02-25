package controllers

import play.api._
import play.api.mvc._
import models.Style
import play.api.data._
import play.api.data.Forms._

import models._
import views._


object Styles extends Controller {


  def index = Action {
	 val styles: Seq[Style] = Style.findAll()
     Ok(html.style.overview(styles))
  }
  
   /**
   * 
   */
  def findById(styleId: Long) = Action {
    val style: Seq[Style] = Style.findById(styleId)
    Ok(html.style.overview(style))
  }
  
  
  def findBySalon(salonId: Long) = Action {
    
    val stylsOfSalon: Seq[Style] = Style.findBySalon(salonId)    
    Ok(html.style.overview(stylsOfSalon))
    
  }
  



}
