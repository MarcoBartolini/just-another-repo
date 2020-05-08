package ie.just.another.java.repo;

import java.util.ArrayList;
import java.util.List;

public class SinglyLinkedList<T> {

    private T head;
    private SinglyLinkedList<T> tail;

    public SinglyLinkedList() {

    }

    public SinglyLinkedList(T head) {
        setHead(head);
    }

    public SinglyLinkedList(T head, SinglyLinkedList<T> tail) {
        setHead(head);
        setTail(tail);
    }

    public void setHead(T head) {
        this.head = head;
    }

    public void setTail(SinglyLinkedList<T> tail) {
        this.tail = tail;
    }

    public T head() {
        return this.head;
    }

    public SinglyLinkedList<T> tail() {
        return this.tail;
    }

    public List<T> asList() {
        return addToList(this,new ArrayList());
    }

    private List<T> addToList(SinglyLinkedList<T> linkedList, List<T> list) {
        if (linkedList != null) {
            list.add(linkedList.head);
            addToList(linkedList.tail, list);
        }
        return list;
    }

}
