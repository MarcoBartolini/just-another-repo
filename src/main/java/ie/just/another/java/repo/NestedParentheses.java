package ie.just.another.java.repo;

public class NestedParentheses {

    private NestedParentheses() {

    }

    /**
     * Checks it the round parentheses in a string are properly nested
     * eg:
     *    "()" or "(bc(d)e)" parentheses are properly nested
     *    ")(" or ")a(ad)e(" parentheses are not properly nested
     *
     * @param s the string to check
     * @return a boolean stating if the parentheses are properly nested
     */
    public static boolean isCorrectlyNested(String s) {

        int validParenthesesIndex = 0;
        for(int i=0;i<s.length();i++){
            char parentheses = s.charAt(i);
            if('(' == parentheses){
                validParenthesesIndex = validParenthesesIndex + 1;
            } else if (')' == parentheses) {
                validParenthesesIndex = validParenthesesIndex - 1;
            } else {
                System.out.println("This is not a parentheses");
            }
            if(validParenthesesIndex < 0) {
                return false;
            }
        }
        return true;
    }

}
