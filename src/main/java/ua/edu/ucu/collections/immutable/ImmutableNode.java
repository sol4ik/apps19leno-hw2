package ua.edu.ucu.collections.immutable;

public class ImmutableNode {
    private final Object value;
    private ImmutableNode next;  // no final because we will be linking the nodes in the linkedList
    private ImmutableNode prev;

    public ImmutableNode(Object value, ImmutableNode next, ImmutableNode prev) {
        this.value = value;
        this.next = next;
        this.prev = prev;
    }

    public ImmutableNode(Object value) {
        this.value = value;
        this.next = null;
        this.prev = null;
    }

    public Object getValue() {
        return value;
    }

    public ImmutableNode getNext() {
        return next;
    }

    public void setNext(ImmutableNode next) {
        this.next = next;
    }

    public ImmutableNode getPrev() {
        return prev;
    }

    public void setPrev(ImmutableNode prev) {
        this.prev = prev;
    }

    public ImmutableNode clone() {
        return new ImmutableNode(value, next, prev);
    }
}
