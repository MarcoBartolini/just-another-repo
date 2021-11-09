package ie.just.another.scala.repo.hexagonal.domain.port

import ie.just.another.scala.repo.hexagonal.domain.model.{Person, PersonDetails, PersonId}

import scala.concurrent.Future

trait PersonPort {

  def createPerson(details: PersonDetails): Future[Any]

  def findPerson(id: PersonId): Future[Either[Exception, Any]]

  def updatePerson(person: Person): Future[Either[Exception, Any]]

  def deletePerson(id: PersonId): Future[Either[Exception, Any]]

}


