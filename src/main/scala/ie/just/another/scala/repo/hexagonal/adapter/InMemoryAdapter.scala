package ie.just.another.scala.repo.hexagonal.adapter

import ie.just.another.scala.repo.hexagonal.domain.model.Person
import ie.just.another.scala.repo.hexagonal.domain.port.PersonPort

import scala.collection.mutable
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

class InMemoryAdapter extends PersonPort {

  var persons: mutable.Map[String, Person] = new mutable.HashMap[String, Person]()

  override def createPerson(uuid: String, firstName: String, lastName: String, age: Int): Future[Either[CreatePersonException, Option[Person]]] = Future {
    if (!persons.contains(uuid)) {
      Right(persons.get(uuid))
    } else {
      Left(CreatePersonException("Could not create the person"))
    }
  }

  override def findPerson(uuid: String): Future[Either[FindPersonException, Option[Person]]] = Future {
    if (persons.contains(uuid)) {
      Right(persons.get(uuid))
    } else {
      Left(FindPersonException("Could not find the person"))
    }
  }

  override def updatePerson(person: Person): Future[Either[UpdatePersonException, Option[Person]]] = Future {
    if (persons.contains(person.uuid)) {
      persons + (person.uuid -> person)
      Right(persons.get(person.uuid))
    } else {
      Left(UpdatePersonException("Could not update the person"))
    }
  }

  override def deletePerson(uuid: String): Future[Either[DeletePersonException, Boolean]] = Future {
    if (persons.contains(uuid)) {
      persons.-(uuid)
      Right(true)
    } else {
      Left(DeletePersonException("Could not delete the person"))
    }
  }
}

object InMemoryAdapter {
  def apply(): InMemoryAdapter = new InMemoryAdapter()
}