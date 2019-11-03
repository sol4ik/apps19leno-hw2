package ua.edu.ucu.collections.immutable;

public class Node {
    private Object value;
    private Node next;
    private Node prev;

    public Node(Object value, Node next, Node prev) {
        this.value = value;
        this.next = next;
        this.prev = prev;
    }

    public Node(Object value) {
        this.value = value;
        this.next = null;
        this.prev = null;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object val) {
        value = val;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node n {
        next = n;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node p) {
        prev = p;
    }

    public Node copy() {
//        if (tail == null)
//            return new Node(value, null, prev.clone());
//        if (prev == null)
//            return new Node(value, next.clone(), null);
//        return new Node(value, next.clone(), prev.clone());
        return new Node(value, next, prev);
    }
}
