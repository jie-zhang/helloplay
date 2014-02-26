import play.api._

import models._
import anorm._

object Global extends GlobalSettings {
  
  override def onStart(app: Application) {
    // InitialData.insert()
  }
  
}

/**
 * Initial set of data to be imported 
 * in the sample application.
 */
/*
object InitialData {
  
  def date(str: String) = new java.text.SimpleDateFormat("yyyy-MM-dd").parse(str)
  
  def insert() = {
    
    if(Salon.findAll.isEmpty) {
      
      Seq(
        Salon(10001, "卡伊发型"),
        Salon(10002, "顶上发艺"),
        Salon(10003, "皇剪造型")
      ).foreach(Salon.create)
      
      Seq(
        Stylist(101, "胡桑桑", 10001),
        Stylist(102, "王冲", 10001),
        Stylist(103, "范辉", 10002),
        Stylist(104, "武则文", 10002),
        Stylist(105, "韩应森", 10002),
        Stylist(106, "郑露", 10002),
        Stylist(107, "韩宏展", 10002),
        Stylist(108, "豆平", 10003)
      ).foreach(Stylist.create)
      
      Seq(
        Style(1001, "贝壳汉姆式", 10001, 101),
        Style(1002, "和尚式", 10001, 101),
        Style(1003, "和尚式2", 10002, 103)
      ).foreach(Style.create)
      
    }
    
  }
  
}
*/
