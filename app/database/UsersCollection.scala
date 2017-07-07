package database

import javax.inject.{Inject, Singleton}

import models.User
import play.modules.reactivemongo.ReactiveMongoApi
import reactivemongo.api.collections.bson.BSONCollection
import reactivemongo.bson.BSONDocument

import scala.concurrent.{ExecutionContext, Future}

/**
  * Created by william on 07/07/17.
  */
@Singleton
class UsersCollection @Inject()(mongo: ReactiveMongoApi) {

  private val collectionName = "users"

  def insert(user: User)(implicit ec: ExecutionContext): Future[Boolean] = {
    val result = for {
      db <- mongo.database
      _ <- db.collection[BSONCollection](collectionName).insert(user)
    } yield true

    result.recover { case _ => false }
  }

  def find(id: String)(implicit ec: ExecutionContext): Future[Option[User]] = {
    val selector = BSONDocument("_id" -> id)

    for {
      db <- mongo.database
      user <- db.collection[BSONCollection](collectionName).find(selector).one[User]
    } yield user
  }

}
