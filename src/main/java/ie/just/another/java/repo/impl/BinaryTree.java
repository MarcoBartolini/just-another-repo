package ie.just.another.java.repo.impl;

import ie.just.another.java.repo.api.Tree;

public class BinaryTree implements Tree {

    private Node root;

    private static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    @Override
    public BinaryTree add(int value) {
        root = addRecursive(root, value);
        return this;
    }

    @Override
    public void diplayPreorderTraversal() {
        diplayPreorderTraversalRecursive(root);
    }

    private void diplayPreorderTraversalRecursive(Node current) {
        if(current != null) {
            System.out.println(current.value);
            diplayPreorderTraversalRecursive(current.left);
            diplayPreorderTraversalRecursive(current.right);
        }
    }

    @Override
    public void diplayInorderTraversal() {
        displayInorderTraversalRecursive(root);
    }

    private void displayInorderTraversalRecursive(Node current) {
        if(current != null) {
            diplayPreorderTraversalRecursive(current.left);
            System.out.println(current.value);
            diplayPreorderTraversalRecursive(current.right);
        }
    }

    @Override
    public void diplayPostorderTraversal() {
        displayPostorderTraversalRecursive(root);
    }

    private void displayPostorderTraversalRecursive(Node current) {
        if(current != null) {
            diplayPreorderTraversalRecursive(current.left);
            diplayPreorderTraversalRecursive(current.right);
            System.out.println(current.value);

        }
    }

    public Node addRecursive(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }
        if (current.value > value) {
            current.left = addRecursive(current.left, value);
        } else if (current.value < value) {
            current.right = addRecursive(current.right, value);
        }
        return current;
    }

}
