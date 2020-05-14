package ie.just.another.java.repo.api;

import ie.just.another.java.repo.impl.BinaryTree;

public interface Tree {

    public Tree add(int value);

    public void diplayPreorderTraversal();

    public void displayPreorderTraversalNonRecursive();

    public void diplayInorderTraversal();

    public void diplayPostorderTraversal();

}
