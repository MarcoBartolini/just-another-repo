package ie.just.another.scala.repo

object FizzBuzz {

  def playFizzBuzz(number: Int): String = {
    (0 until number+1).map(fizzBuzz).mkString
  }

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
