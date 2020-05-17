package ie.just.another.java.repo.api;

public interface Tree {

    Tree add(int value);

    void displayPreorderTraversal();

    void displayPreorderTraversalNonRecursive();

    void displayInorderTraversal();

    void displayPostorderTraversal();

    int getLowestCommonAncestor(int firstValue, int secondValue);

    Integer getLowestCommonAncestorSecondVersion(int firstValue, int secondValue);

}
