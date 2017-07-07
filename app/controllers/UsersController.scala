package controllers

import javax.inject.Inject

import play.api.mvc.{BaseController, ControllerComponents}

/**
  * Created by william on 07/07/17.
  */
class UsersController @Inject()(val controllerComponents: ControllerComponents)
  extends BaseController {

  def create = Action {
    Ok
  }

  def read = Action {
    Ok
  }

  def update = Action {
    Ok
  }

  def delete = Action {
    Ok
  }

}
