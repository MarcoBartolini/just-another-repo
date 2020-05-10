package ie.just.another.java.repo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SinglyLinkedList<T> {

    private int size = 0;
    private Node<T> head;

    public static class Node<T> {

        private final T data;
        private Node<T> next;
        private int index;

        Node(T d) {
            data = d;
        }

        public T getData() {
            return data;
        }

        public Node<T> getNext() {
            return next;
        }

        @Override
        public String toString() {
            return new StringBuilder("data: ").append(data).append(" index: ").append(index).toString();
        }
    }

    public SinglyLinkedList<T> addAll(Collection<T> collectionToAdd) {
        for (T element : collectionToAdd) {
            this.add(element);
        }
        return this;
    }

    public SinglyLinkedList<T> add(T data) {

        Node<T> nodeToAdd = new Node<>(data);

        if (this.head == null) {
            this.head = nodeToAdd;
        } else {
            Node<T> last = this.head;
            while (last.next != null) {
                last = last.next;
            }
            nodeToAdd.index = last.index + 1;
            last.next = nodeToAdd;

        }
        size++;
        return this;
    }

    public SinglyLinkedList<T> clear() {
        if (this.head != null) {
            this.head = null;
        }
        size = 0;
        return this;
    }

    public T get(int index) {
        Node<T> element = this.head;
        while (element != null) {
            if (element.index == index) {
                return element.data;
            }
            element = element.next;
        }
        return null;
    }

    public int size() {
//        this is easier to maintain, but it doesn't perform on large numbers due to the O(n) notation
//        int size = 0;
//        Node element = this.head;
//        while(element != null) {
//            element = element.next;
//            size += 1;
//        }
        return size;
    }

    public T getHead() {
        return head.data;
    }

    public void display() {
        Node<T> element = this.head;
        while (element != null) {
            System.out.println(element);
            element = element.next;
        }
    }

    public List<T> asList() {
        return addToList(this.head, new ArrayList<T>());
    }

    // just to exercise on recursion
    private List<T> addToList(Node<T> node, List<T> list) {
        if (node != null) {
            list.add(node.data);
            addToList(node.next, list);
        }
        return list;
    }

}
