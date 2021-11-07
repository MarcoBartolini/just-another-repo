package ie.just.another.scala.repo.hexagonal.domain.port

import ie.just.another.scala.repo.hexagonal.domain.model.Person

import scala.concurrent.Future

trait PersonPort {

  def createPerson(uuid: String, firstName: String, lastName: String, age: Int): Future[Either[Exception, Any]]

  def findPerson(uuid: String): Future[Either[Exception, Any]]

  def updatePerson(person: Person): Future[Either[Exception, Any]]

  def deletePerson(uuid: String): Future[Either[Exception, Any]]

  final case class CreatePersonException(msg: String, cause: Option[Throwable] = None)
    extends Exception(msg, cause.orNull)

  final case class FindPersonException(msg: String, cause: Option[Throwable] = None)
    extends Exception(msg, cause.orNull)

  final case class UpdatePersonException(msg: String, cause: Option[Throwable] = None)
    extends Exception(msg, cause.orNull)

  final case class DeletePersonException(msg: String, cause: Option[Throwable] = None)
    extends Exception(msg, cause.orNull)

}


