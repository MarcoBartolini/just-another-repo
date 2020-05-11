package ie.just.another.java.repo.impl;

public class FizzBuzz {

    private FizzBuzz() {

    }

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
    public static String fizzBuzzGame(int number) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= number; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                update("FizzBuzz",sb);
            } else if (i % 3 == 0) {
                update("Fizz",sb);
            } else if (i % 5 == 0) {
                update("Buzz",sb);
            } else {
                update(i,sb);
            }
        }
        return sb.toString();
    }

    private static void update(Object obj, StringBuilder sb) {
        sb.append(obj).append(" ");
        System.out.println(obj);
    }

}
