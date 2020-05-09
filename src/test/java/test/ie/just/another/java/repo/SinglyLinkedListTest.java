package test.ie.just.another.java.repo;

import ie.just.another.java.repo.SinglyLinkedList;
import org.junit.Test;

import java.util.List;
import static org.junit.Assert.*;

public class SinglyLinkedListTest {

    @Test
    public void singlyLinkedList() {
        SinglyLinkedList<String> testSinglyLinkedList = new SinglyLinkedList();
        testSinglyLinkedList.insert("first element");
        testSinglyLinkedList.insert("second element");
        testSinglyLinkedList.insert("third element");
        testSinglyLinkedList.insert("fourth element");

        List<String> testList =  testSinglyLinkedList.asList();
        assertEquals(testList.get(0), "first element");
        assertEquals(testList.get(1), "second element");
        assertEquals(testList.size(),4);

        testSinglyLinkedList.insert("last element");
        assertEquals("last element", testSinglyLinkedList.asList().get(4));
    }

}
