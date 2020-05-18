package ie.just.another.java.repo.impl;

import ie.just.another.java.repo.api.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
    public void displayPreorderTraversal() {
        diplayPreorderTraversalRecursive(root);
    }

    private void diplayPreorderTraversalRecursive(Node current) {
        if (current != null) {
            System.out.println(current.value);
            diplayPreorderTraversalRecursive(current.left);
            diplayPreorderTraversalRecursive(current.right);
        }
    }

    @Override
    public void displayPreorderTraversalNonRecursive() {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node current = stack.pop();
            System.out.println(current.value);
            if (current.right != null) {
                stack.push(current.right);
            }
            if (current.left != null) {
                stack.push(current.left);
            }
        }
    }

    @Override
    public void displayInorderTraversal() {
        displayInorderTraversalRecursive(root);
    }

    private void displayInorderTraversalRecursive(Node current) {
        if (current != null) {
            diplayPreorderTraversalRecursive(current.left);
            System.out.println(current.value);
            diplayPreorderTraversalRecursive(current.right);
        }
    }

    @Override
    public void displayPostorderTraversal() {
        displayPostorderTraversalRecursive(root);
    }

    private void displayPostorderTraversalRecursive(Node current) {
        if (current != null) {
            diplayPreorderTraversalRecursive(current.left);
            diplayPreorderTraversalRecursive(current.right);
            System.out.println(current.value);

        }
    }

    @Override
    public int getLowestCommonAncestor(int firstValue, int secondValue) {
        List<Integer> firstValueParents = getParents(firstValue, root, new ArrayList<>());
        List<Integer> secondValueParents = getParents(secondValue, root, new ArrayList<>());
        if (firstValueParents.size() > secondValueParents.size()) {
            return firstValueParents.get(secondValueParents.size() - 1);
        } else {
            return secondValueParents.get(firstValueParents.size() - 1);
        }
    }

    private List<Integer> getParents(int value, Node current, List<Integer> parents) {
        if (current != null) {
            if (current.value == value) {
                return parents;
            } else {
                parents.add(current.value);
                if (current.value > value) {
                    getParents(value, current.left, parents);
                } else if (current.value < value) {
                    getParents(value, current.right, parents);
                }
            }
        }
        return parents;
    }

    @Override
    public Integer getLowestCommonAncestorSecondVersion(int firstValue, int secondValue) {
        Node current = root;
        while (current != null) {
            if(firstValue > current.value && secondValue > current.value) {
                current = current.right;
            } else if(firstValue < current.value && secondValue < current.value) {
                current = current.left;
            } else {
                return current.value;
            }
        }
        return null;
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
