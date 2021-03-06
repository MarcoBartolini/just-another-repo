package ie.just.another.java.repo.impl;

import java.util.HashMap;
import java.util.Map;

public class ArraysAndStrings {

    private ArraysAndStrings() {

    }

    /**
     * This method will return the first non repeated character in the input string eg:
     * - teeter will return r
     * - tester will return s
     * - total will return o
     * - toto will return null
     *
     * @param s - the string to analyze
     * @return the first non repeated character in the string, a null value will return null
     */
    public static Character findFirstNonRepeatedCharacter(String s) {

        if (s == null || "".equals(s)) {
            return null;
        }

        Map<Character, Integer> searchMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            Character currentChar = s.charAt(i);
            if (searchMap.containsKey(currentChar)) {
                searchMap.put(currentChar, searchMap.get(currentChar) + 1);
            } else {
                searchMap.put(currentChar, 1);
            }
        }

        for (int i = 0; i < s.length(); i++) {
            if (searchMap.get(s.charAt(i)) == 1) {
                return s.charAt(i);
            }
        }

        return null;
    }

    /**
     * This method will remove all the single char from the provided string
     *
     * @param str    the string to clean
     * @param remove the series of char to remove
     * @return the inital string without the char contained in the remove parameter
     */
    public static String removeChar(String str, String remove) {

        if (str == null || remove == null || "".equals(str.trim()) || "".equals(remove.trim())) {
            return str;
        }

        for (char c : remove.toCharArray()) {
            str = str.replace(String.valueOf(c), "");
        }

        return str;
    }


}
