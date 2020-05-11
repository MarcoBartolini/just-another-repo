package test.ie.just.another.java.repo;


import ie.just.another.java.repo.impl.FizzBuzz;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FizzBuzzTest {

    @Test
    public void playFizzBuzzPositiveNumber() {
        String result = FizzBuzz.fizzBuzzGame(15);
        assertEquals(result, "FizzBuzz 1 2 Fizz 4 Buzz Fizz 7 8 Fizz Buzz 11 Fizz 13 14 FizzBuzz ");
    }

    @Test
    public void playFizzBuzzWithZero() {
        String result = FizzBuzz.fizzBuzzGame(0);
        assertEquals(result, "FizzBuzz ");
    }

    @Test
    public void playFizzBuzzWithNegativeNumber() {
        String result = FizzBuzz.fizzBuzzGame(-15);
        assertEquals(result, "");
    }

}
