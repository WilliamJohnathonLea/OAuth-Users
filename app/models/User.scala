package models

import reactivemongo.bson.Macros

/**
  * Created by william on 07/07/17.
  */
case class User(_id: String, name: String, email: String)

object User {

  implicit val format = Macros.handler[User]

}
