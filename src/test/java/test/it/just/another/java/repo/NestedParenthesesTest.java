package test.it.just.another.java.repo;

import static org.junit.Assert.*;
import ie.just.another.java.repo.NestedParentheses;
import org.junit.Test;

public class NestedParenthesesTest {

    @Test
    public void checkNestedParentheses() {
        assertEquals(false,NestedParentheses.isCorrectlyNested(")("));
        assertEquals(false,NestedParentheses.isCorrectlyNested("((1)()()()()(())(())(((())))))("));
        assertEquals(true,NestedParentheses.isCorrectlyNested("(b)"));
        assertEquals(true,NestedParentheses.isCorrectlyNested(""));
    }

}
