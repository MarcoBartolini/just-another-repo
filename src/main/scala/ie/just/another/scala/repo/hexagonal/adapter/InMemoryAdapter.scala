package ie.just.another.scala.repo.hexagonal.adapter

import ie.just.another.scala.repo.hexagonal.domain.exception.PersonExceptions
import ie.just.another.scala.repo.hexagonal.domain.model._
import ie.just.another.scala.repo.hexagonal.domain.port.PersonPort

import java.util.UUID
import scala.collection.mutable
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

class InMemoryAdapter extends PersonPort with PersonExceptions {

  private val persons: mutable.Map[String, Person] = new mutable.HashMap[String, Person]()

  override def createPerson(details: PersonDetails): Future[Option[Person]] = Future {
    val person = Person(
      PersonId(UUID.randomUUID().toString),
      PersonDetails(
        FirstName(details.firstName.value),
        LastName(details.lastName.value),
        Age(details.age.value)
      )
    )
    persons + (person.id.value -> person)
    persons.get(person.id.value)
  }

  override def findPerson(id: PersonId): Future[Either[FindPersonException, Option[Person]]] = Future {
    if (persons.contains(id.value)) {
      Right(persons.get(id.value))
    } else {
      Left(FindPersonException("Could not find the person"))
    }
  }

  override def updatePerson(person: Person): Future[Either[UpdatePersonException, Option[Person]]] = Future {
    if (persons.contains(person.id.value)) {
      persons + (person.id.value -> person)
      Right(persons.get(person.id.value))
    } else {
      Left(UpdatePersonException("Could not update the person"))
    }
  }

  override def deletePerson(id: PersonId): Future[Either[DeletePersonException, Boolean]] = Future {
    if (persons.contains(id.value)) {
      persons.-(id.value)
      Right(true)
    } else {
      Left(DeletePersonException("Could not delete the person"))
    }
  }
}

object InMemoryAdapter {
  def apply(): InMemoryAdapter = new InMemoryAdapter()
}