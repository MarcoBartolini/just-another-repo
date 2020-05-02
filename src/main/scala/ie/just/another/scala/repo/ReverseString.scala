package ie.just.another.scala.repo

object ReverseString {

  /**
   * Reverse a string
   * eg: "abc" will return "cba"
   *
   * @param stringToReverse the string to reverse, null will return a null pointer exception
   * @return the input string reverted
   */
  def reverseString(stringToReverse: String): String = stringToReverse.reverseMap(s => s)

}
