package ie.just.another.scala.repo

object FizzBuzz {

  /**
   * Fizz buzz is a group word game for children to teach them about division.
   * Players take turns to count incrementally, replacing any number divisible
   * by three with the word "fizz", and any number divisible by five with the word "buzz"
   *
   * This method will play the game on its own and output the result on the console
   *
   * @param number - that is the number the method will count to, starting from 0
   * @return a string with the output of the game eg: FizzBuzz 1 2 Fizz 4 Buzz...
   */
  def playFizzBuzz(number: Int): String = (0 until number+1).map(fizzBuzz).mkString

  private def fizzBuzz(x:Int) = {
    if (x % 15 == 0)
      "FizzBuzz "
    else if (x % 3 == 0)
      "Fizz "
    else if (x % 5 == 0)
      "Buzz "
    else
      s"$x "
  }

}
