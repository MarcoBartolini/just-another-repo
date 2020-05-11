package ie.just.another.java.repo.impl;

public class ReverseString {

    private ReverseString() {

    }

    /**
     * Reverse a string
     * eg: "abc" will return "cba"
     *
     * @param stringToReverse the string to reverse, null will return a null pointer exception
     * @return the input string reverted
     */
    public static String reverseString(String stringToReverse) {
        StringBuilder sb = new StringBuilder();
        for (int i = stringToReverse.length()-1; i >= 0; i--) {
            sb.append(stringToReverse.charAt(i));
        }
        return sb.toString();
    }

}
