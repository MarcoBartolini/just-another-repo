package ie.just.another.scala.repo.hexagonal.domain.model


case class PersonId(value: String) extends AnyVal

case class FirstName(value: String) extends AnyVal

case class LastName(value: String) extends AnyVal

case class Age(value: Int) extends AnyVal

case class PersonDetails(firstName: FirstName, lastName: LastName, age: Age)

case class Person(id: PersonId, details: PersonDetails) {

  def isAdult: Boolean = if (details.age.value >= 18) true else false

  def toUppercase: Person = {
    Person(
      PersonId(this.id.value.toUpperCase),
      PersonDetails(
        FirstName(details.firstName.value.toUpperCase),
        LastName(details.lastName.value.toUpperCase),
        Age(details.age.value)
      )
    )
  }

}