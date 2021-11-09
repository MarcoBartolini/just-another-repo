package test.ie.just.another.scala.repo.hexagonal.adapter

import ie.just.another.scala.repo.hexagonal.adapter.InMemoryAdapter
import ie.just.another.scala.repo.hexagonal.domain.model._
import org.scalatest.{FlatSpec, MustMatchers}

import scala.concurrent.ExecutionContext.Implicits.global

class InMemoryAdapterTest extends FlatSpec with MustMatchers {

  "InMemoryAdapter" should "Create a person" in {
    val inMemoryAdapter = InMemoryAdapter.apply()
    inMemoryAdapter.createPerson(
      PersonDetails(
        FirstName("Massimo"),
        LastName("Decimo Meridio"),
        Age(47)
      )
    ).map(personOp => {
      personOp match {
        case Some(person: Person) => {
          person.id.value.length > 0 mustBe true
          person.details.firstName.value mustBe "Massimo"
          person.details.lastName.value mustBe "Decimo Meridio"
          person.details.age.value mustBe 47
        }
        case _ => fail
      }
    })
  }

  "InMemoryAdapter" should "Find a person" in {
    val inMemoryAdapter = InMemoryAdapter.apply()
    inMemoryAdapter.createPerson(
      PersonDetails(
        FirstName("Massimo"),
        LastName("Decimo Meridio"),
        Age(47)
      )
    ).map(personOp => {
      personOp match {
        case Some(personCreated: Person) => {
          inMemoryAdapter.findPerson(personCreated.id).map(personFoundOp => {
            personFoundOp match {
              case Right(personFound) => {
                personFound.get mustBe personCreated
              }
              case Left(findPersonException) => fail
            }
          })
        }
        case _ => fail
      }
    })
  }

}
