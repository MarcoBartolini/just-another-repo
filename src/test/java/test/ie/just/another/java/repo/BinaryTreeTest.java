package test.ie.just.another.java.repo;

import ie.just.another.java.repo.api.Tree;
import ie.just.another.java.repo.impl.BinaryTree;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class BinaryTreeTest {

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

    public static Tree init() {
        Tree binaryTree = new BinaryTree();

        binaryTree
                .add(100)
                .add(50)
                .add(150)
                .add(25)
                .add(75)
                .add(125)
                .add(110)
                .add(175);

        return binaryTree;
    }

    @Test
    public void displayPreOrder() {

        Tree binaryTree = init();
        binaryTree.diplayPreorderTraversal();

        assertEquals("100\n" +
                "50\n" +
                "25\n" +
                "75\n" +
                "150\n" +
                "125\n" +
                "110\n" +
                "175\n", outContent.toString());

    }

    @Test
    public void displayPreOrderNonRecurisve() {

        Tree binaryTree = init();
        binaryTree.displayPreorderTraversalNonRecursive();

        assertEquals("100\n" +
                "50\n" +
                "25\n" +
                "75\n" +
                "150\n" +
                "125\n" +
                "110\n" +
                "175\n", outContent.toString());

    }


    @Test
    public void displayInorder() {

        Tree binaryTree = init();
        binaryTree.diplayInorderTraversal();

        assertEquals("50\n" +
                "25\n" +
                "75\n" +
                "100\n" +
                "150\n" +
                "125\n" +
                "110\n" +
                "175\n", outContent.toString());

    }

    @Test
    public void displayPostorder() {

        Tree binaryTree = init();
        binaryTree.diplayPostorderTraversal();

        assertEquals("50\n" +
                "25\n" +
                "75\n" +
                "150\n" +
                "125\n" +
                "110\n" +
                "175\n" +
                "100\n", outContent.toString());

    }


}
