package test.ie.just.another.java.repo;

import ie.just.another.java.repo.SinglyLinkedList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SinglyLinkedListTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    public static SinglyLinkedList<String> init() {

        SinglyLinkedList<String> testSinglyLinkedList = new SinglyLinkedList<>();

        testSinglyLinkedList.add("first element");
        testSinglyLinkedList.add("second element");
        testSinglyLinkedList.add("third element");
        testSinglyLinkedList.add("fourth element");

        return testSinglyLinkedList;
    }

    @Test
    public void singlyLinkedList() {

        SinglyLinkedList<String> testSinglyLinkedList = init();

        assertEquals(testSinglyLinkedList.get(0), "first element");
        assertEquals(testSinglyLinkedList.get(1), "second element");
    }

    @Test
    public void add() {

        SinglyLinkedList<String> testSinglyLinkedList = init();

        testSinglyLinkedList.add("last element");

        assertEquals("last element", testSinglyLinkedList.get(4));
        assertEquals(5, testSinglyLinkedList.size());
    }

    @Test
    public void addAll() {

        List<String> elements = new ArrayList<>();
        elements.add("0");
        elements.add("1");
        elements.add("2");
        elements.add("3");
        elements.add("4");

        SinglyLinkedList<String> testSinglyLinkedList = new SinglyLinkedList<>();
        testSinglyLinkedList.addAll(elements);

        assertEquals(5, testSinglyLinkedList.size());
        assertEquals("0", testSinglyLinkedList.get(0));
        assertEquals("4", testSinglyLinkedList.get(4));

    }

    @Test
    public void clear() {

        SinglyLinkedList<String> testSinglyLinkedList = init();
        assertEquals(4, testSinglyLinkedList.size());

        testSinglyLinkedList.clear();
        assertEquals(0, testSinglyLinkedList.size());

    }

    @Test
    public void size() {

        SinglyLinkedList<String> testSinglyLinkedList = init();
        assertEquals(4, testSinglyLinkedList.size());

        testSinglyLinkedList.clear();
        assertEquals(0, testSinglyLinkedList.size());

    }


    @Test
    public void asList() {
        List<String> testList = init().asList();
        assertEquals(testList.get(0), "first element");
        assertEquals(testList.get(1), "second element");
        assertEquals(testList.size(), 4);
    }

    @Test
    public void display() {

        SinglyLinkedList<String> testSinglyLinkedList = init();
        testSinglyLinkedList.display();
        assertEquals("data: first element index: 0\n" +
                "data: second element index: 1\n" +
                "data: third element index: 2\n" +
                "data: fourth element index: 3\n", outContent.toString());

    }

}
