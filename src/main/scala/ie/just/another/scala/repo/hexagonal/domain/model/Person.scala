package ie.just.another.scala.repo.hexagonal.domain.model

case class Person(uuid: String, firstName: String, lastName: String, age: Int) {

  def isAdult: Boolean = if (age >= 18) true else false

  def toUppercase: Person = {
    Person(this.uuid.toUpperCase, this.firstName.toUpperCase, this.lastName.toUpperCase, this.age)
  }
}
