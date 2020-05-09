package test.ie.just.another.scala.repo

import ie.just.another.scala.repo.ReverseString
import org.scalatest.{FlatSpec, MustMatchers}

class ReverseStringTest extends FlatSpec with MustMatchers {

  "ReverseString" should "reverse a string" in {
    ReverseString.reverseString("abcdefg-123456789") mustBe "987654321-gfedcba"
  }

}
