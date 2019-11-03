package ua.edu.ucu.collections.immutable;

public class Node implements Cloneable{
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

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    @Override
    public Node clone() {
//        if (tail == null)
//            return new Node(value, null, prev.clone());
//        if (prev == null)
//            return new Node(value, next.clone(), null);
//        return new Node(value, next.clone(), prev.clone());
        return new Node(value, next, prev);
    }
}
