package test.ie.just.another.scala.repo

import ie.just.another.scala.repo.NestedParentheses
import org.scalatest.{FlatSpec, MustMatchers}

class NestedParenthesesTest extends FlatSpec with MustMatchers {

  "NestedParentheses" should "detect is parentheses are correctly nested or not" in {
    NestedParentheses.isCorrectlyNested("") mustBe true
    NestedParentheses.isCorrectlyNested("()") mustBe true
    NestedParentheses.isCorrectlyNested(")(") mustBe false

    NestedParentheses.isCorrectlyNested("((1)()((())))()") mustBe true
    NestedParentheses.isCorrectlyNested("(((a)))()()(()))(") mustBe false
  }

}
