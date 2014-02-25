package models

import anorm._
import anorm.SqlParser._
import play.api.db._
import play.api.Play.current

case class Salon(id: Long, label: String)

object Salon {

  val salon = {
    get[Long]("id") ~ get[String]("label") map {
      case id ~ label => Salon(id, label)
    }
  }

  // -- Queries
    
  /**
   * Retrieve a Salon from id.
   */
  def findById(id: Long): Seq[Salon] = {
    DB.withConnection { implicit connection =>
      SQL(
          """select * from salon where id = {id}"""
      ).on(
        'id -> id
      ).as(Salon.salon *)
    }
  }
  
  /**
   * Retrieve All salons.(by some conditons.)
   */
  def findAll(): Seq[Salon] = {
    DB.withConnection { implicit connection =>
      SQL(
        """
          select * from salon 
        """
      ).on(
          
      ).as(Salon.salon *)
    }
  }

  // -- Updates
  /**
   *   
   */  
  def create(salon: Salon) {
    DB.withConnection { implicit c =>
      SQL(
          """insert into salon (id, label) values ({id}, {label})"""
      ).on(
        'id -> salon.id,
        'label -> salon.label
      ).executeUpdate()
    }
  }

}

