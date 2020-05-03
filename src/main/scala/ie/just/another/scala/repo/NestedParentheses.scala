package ie.just.another.scala.repo

import scala.annotation.tailrec

object NestedParentheses {

  /**
   * Checks it the round parentheses in a string are properly nested
   * eg:
   * "()" or "(bc(d)e)" parentheses are properly nested
   * ")(" or ")a(ad)e(" parentheses are not properly nested
   *
   * @param s the string to check
   * @return a boolean stating if the parentheses are properly nested
   */
  def isCorrectlyNested(s: String): Boolean = {

    @tailrec
    def check(chars: Array[Char], index: Int = 0): Int = {
      if (chars.isEmpty || index < 0) {
        index
      } else if (chars.head == '(') {
        check(chars.tail, index + 1)
      } else if (chars.head == ')') {
        check(chars.tail, index - 1)
      } else {
        check(chars.tail, index)
      }
    }

    if (check(s.toCharArray) == 0) true else false
  }

}
