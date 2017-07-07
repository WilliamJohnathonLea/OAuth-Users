package controllers

import javax.inject.{Inject, Singleton}

import database.UsersCollection
import models.User
import play.api.libs.json.JsValue
import play.api.mvc.{Action, BaseController, ControllerComponents}

import scala.concurrent.ExecutionContext


/**
  * Created by william on 07/07/17.
  */
@Singleton
class UsersController @Inject()(
  val controllerComponents: ControllerComponents,
  users: UsersCollection
)(implicit ec: ExecutionContext) extends BaseController {

  def create: Action[JsValue] = Action.async(parse.json) { request =>
    users.insert(request.body.as[User])
      .map { created =>
        if(created) Created else InternalServerError
      }
  }

  def read = Action {
    users.find("")
    Ok
  }

  def update = Action {
    Ok
  }

  def delete = Action {
    Ok
  }

}
