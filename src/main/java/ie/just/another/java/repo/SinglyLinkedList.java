package ie.just.another.java.repo;

import java.util.ArrayList;
import java.util.List;

public class SinglyLinkedList<T> {

    private Node<T> head;

    private static class Node<T> {

        T data;
        Node next;

        // Constructor
        Node(T d) {
            data = d;
        }
    }

    public SinglyLinkedList insert(T data) {

        Node<T> nodeToAdd = new Node(data);

        if (this.head == null) {
            this.head = nodeToAdd;
        } else {
            Node<T> last = this.head;
            while (last.next != null) {
                last = last.next;
            }

            last.next = nodeToAdd;
        }

        return this;
    }

    public List<T> asList() {
        return addToList(this.head, new ArrayList());
    }

    private List<T> addToList(Node<T> node, List<T> list) {
        if (node != null) {
            list.add(node.data);
            addToList(node.next, list);
        }
        return list;
    }

}
