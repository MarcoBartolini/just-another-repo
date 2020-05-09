package test.ie.just.another.scala.repo

import ie.just.another.scala.repo.FizzBuzz
import org.scalatest.{FlatSpec, MustMatchers}

class FizzBuzzScalaTest extends FlatSpec with MustMatchers {

  "FizzBuzz" should "play the game correctly" in {
    FizzBuzz.playFizzBuzz(15) mustBe "FizzBuzz 1 2 Fizz 4 Buzz Fizz 7 8 Fizz Buzz 11 Fizz 13 14 FizzBuzz "
  }

  "FizzBuzz" should "play the game starting from 0" in {
    FizzBuzz.playFizzBuzz(0) mustBe "FizzBuzz "
  }

  "FizzBuzz" should "play the game starting from -15" in {
    FizzBuzz.playFizzBuzz(-15) mustBe ""
  }

}
