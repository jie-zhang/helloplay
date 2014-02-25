package models

import anorm._
import anorm.SqlParser._
import play.api.db._
import play.api.Play.current

case class Stylist(id: Long, label: String, salonId: Long)

object Stylist {

  val stylist = {
    get[Long]("id") ~ get[String]("label") ~ get[Long]("salonId") map {
      case id ~ label ~ salonId => Stylist(id, label, salonId)
    }
  }

  // -- Queries
    
  /**
   * Retrieve a Stylist from id.
   */
  def findById(id: Long): Seq[Stylist] = {
    DB.withConnection { implicit connection =>
      SQL(
          """select * from stylist where id = {id}"""
      ).on(
        'id -> id
      ).as(Stylist.stylist *)
    }
  }
  
    /**
   * Retrieve All stylists.(by some conditons.)
   */
  def findBySalon(salonId: Long): Seq[Stylist] = {
    DB.withConnection { implicit connection =>
      SQL(
        """
          select * from stylist
          where salonId = {salonId}
        """
      ).on(
         'salonId -> salonId 
      ).as(Stylist.stylist *)
    }
  }
  
   /**
   * Retrieve All salons.
   */
  def findAll(): Seq[Stylist] = {
    DB.withConnection { implicit connection =>
      SQL(
        """
          select * from stylist 
        """
      ).on(
          
      ).as(Stylist.stylist *)
    }
  }
  

  // -- Updates
  /**
   *   
   */  
  def create(stylist: Stylist) {
    DB.withConnection { implicit c =>
      SQL(
          """insert into stylist (id, label, salonId) values ({id}, {label}, {salonId})"""
      ).on(
        'id -> stylist.id,
        'label -> stylist.label,
        'salonId -> stylist.salonId
      ).executeUpdate()
    }
  }

}

