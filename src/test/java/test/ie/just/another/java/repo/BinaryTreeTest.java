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
        binaryTree.displayPreorderTraversal();

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
        binaryTree.displayInorderTraversal();

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
        binaryTree.displayPostorderTraversal();

        assertEquals("50\n" +
                "25\n" +
                "75\n" +
                "150\n" +
                "125\n" +
                "110\n" +
                "175\n" +
                "100\n", outContent.toString());

    }

    @Test
    public void lowestCommonAncestor() {
        Tree binaryTree = new BinaryTree();

        binaryTree
                .add(20)
                .add(8)
                .add(22)
                .add(4)
                .add(12)
                .add(10)
                .add(14);

        assertEquals(8, binaryTree.getLowestCommonAncestor(4, 14));
        assertEquals(8, binaryTree.getLowestCommonAncestor(14, 4));
        assertEquals(8, binaryTree.getLowestCommonAncestor(4, 12));

        assertEquals(new Integer(8), binaryTree.getLowestCommonAncestorSecondVersion(4, 14));
        assertEquals(new Integer(8), binaryTree.getLowestCommonAncestorSecondVersion(14, 4));
        assertEquals(new Integer(8), binaryTree.getLowestCommonAncestorSecondVersion(4, 12));

        binaryTree.add(15);

        assertEquals(12, binaryTree.getLowestCommonAncestor(10, 15));

        assertEquals(new Integer(12), binaryTree.getLowestCommonAncestorSecondVersion(10, 15));

        assertEquals(null, new BinaryTree().getLowestCommonAncestorSecondVersion(10, 15));

    }

    public static void main(String args[]) {

        Tree binaryTree = new BinaryTree();

        binaryTree
                .add(20)
                .add(8)
                .add(22)
                .add(4)
                .add(12)
                .add(10)
                .add(14);

        System.out.println( "RESULT " + binaryTree.getLowestCommonAncestorSecondVersion(4, 14));

    }

}
