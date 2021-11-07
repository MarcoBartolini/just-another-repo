package ie.just.another.scala.repo.hexagonal.adapter

import ie.just.another.scala.repo.hexagonal.domain.model.Person
import ie.just.another.scala.repo.hexagonal.domain.port.PersonPort

import scala.collection.mutable
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

class InMemoryAdapter extends PersonPort {

  var persons: mutable.Map[String, Person] = new mutable.HashMap[String, Person]()

  override def createPerson(uuid: String, firstName: String, lastName: String, age: Int): Future[Either[CreatePersonException, Option[Person]]] = Future {
    if (persons.get(uuid).isEmpty) {
      Right(persons.get(uuid))
    } else {
      Left(CreatePersonException("Could not create the person"))
    }
  }

  override def findPerson(uuid: String): Future[Either[FindPersonException, Option[Person]]] = Future {
    if (persons.get(uuid).isDefined) {
      Right(persons.get(uuid))
    } else {
      Left(FindPersonException("Could not find the person"))
    }
  }

  override def updatePerson(person: Person): Future[Either[UpdatePersonException, Option[Person]]] = Future {
    if (persons.get(person.uuid).isDefined) {
      persons + (person.uuid -> person)
      Right(persons.get(person.uuid))
    } else {
      Left(UpdatePersonException("Could not update the person"))
    }
  }

  override def deletePerson(uuid: String): Future[Either[DeletePersonException, Boolean]] = Future {
    if (persons.get(uuid).isDefined) {
      persons.-(uuid)
      Right(true)
    } else {
      Left(DeletePersonException("Could not delete the person"))
    }
  }
}

object PersonController {
  def apply(): InMemoryAdapter = new InMemoryAdapter()
}