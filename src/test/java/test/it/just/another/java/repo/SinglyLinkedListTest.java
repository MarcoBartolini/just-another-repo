package test.it.just.another.java.repo;

import ie.just.another.java.repo.SinglyLinkedList;
import org.junit.Test;

import java.util.List;
import static org.junit.Assert.*;

public class SinglyLinkedListTest {

    @Test
    public void singlyLinkedList() {
        SinglyLinkedList<String> testSinglyLinkedList = new SinglyLinkedList();
        testSinglyLinkedList.setHead("first element");
        testSinglyLinkedList.setTail(
                new SinglyLinkedList<>("second element",
                        new SinglyLinkedList<>("third element",
                                new SinglyLinkedList<>("last element"))));

        List<String> testList =  testSinglyLinkedList.asList();
        assertEquals(testList.get(0), "first element");
        assertEquals(testList.size(),4);
    }

    // TODO: add jcoco!



}
