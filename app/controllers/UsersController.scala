package controllers

import javax.inject.{Inject, Singleton}

import database.UsersCollection
import models.User
import play.api.libs.json.JsValue
import play.api.mvc.{Action, BaseController, ControllerComponents}

import scala.concurrent.{ExecutionContext, Future}


/**
  * Created by william on 07/07/17.
  */
@Singleton
class UsersController @Inject()(
  val controllerComponents: ControllerComponents,
  users: UsersCollection
)(implicit ec: ExecutionContext) extends BaseController {

  def create: Action[JsValue] = Action.async(parse.json) { request =>
    request.body.asOpt[User] match {
      case Some(user) => users.insert(user).map(if(_) Created else InternalServerError)
      case None => Future.successful(BadRequest)
    }
  }

  def read(id: String) = Action {
    users.find(id)
    Ok
  }

}
