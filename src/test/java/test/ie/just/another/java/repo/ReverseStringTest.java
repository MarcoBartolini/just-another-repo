package test.ie.just.another.java.repo;

import ie.just.another.java.repo.ReverseString;
import static org.junit.Assert.*;
import org.junit.Test;

public class ReverseStringTest {

    @Test
    public void reverseStringTest() {
        String result = ReverseString.reverseString("abcdefg-123456789");
        assertEquals(result, "987654321-gfedcba");
    }

}
