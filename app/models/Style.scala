package models

import anorm._
import anorm.SqlParser._
import play.api.db._
import play.api.Play.current

case class Style(id: Long, label: String, salonId: Long, stylistId : Long)

object Style {

  val style = {
    get[Long]("id") ~
    get[String]("label") ~
    get[Long]("salonId") ~
    get[Long]("stylistId") map {
      case id ~ label ~ salonId ~ stylistId => Style(id, label, salonId, stylistId)
    }
  }

  
  // -- Queries
   /**
   * Retrieve All style.
   */
  def findAll(): Seq[Style] = {
    DB.withConnection { implicit connection =>
      SQL(
        """
          select * from style
        """
      ).on(
          
      ).as(Style.style *)
    }
  } 
    
  /**
   * Retrieve a Style from id.
   */
  def findById(id: Long): Seq[Style] = {
    DB.withConnection { implicit connection =>
      SQL(
          """select * from style where id = {id}"""
      ).on(
        'id -> id
      ).as(Style.style *)
    }
  }
  
  def findBySalon(salonId: Long): Seq[Style] = {
    DB.withConnection { implicit connection =>
      SQL(
          """select * from style where salonId = {salonId}"""
      ).on(
        'salonId -> salonId
      ).as(Style.style *)
    }
  }
  

  // -- Updates

  /**
   *   
   */  
  def create(style: Style) {
    DB.withConnection { implicit connection =>
      SQL(
          """insert into style (id, label, salonId, stylistId) 
          values ({id}, {label}, {salonId}, {stylistId})"""
      ).on(
        'id -> style.id,
        'label -> style.label,
        'salonId -> style.salonId,
        'stylistId -> style.stylistId
      ).executeUpdate()
    }
  }


}

