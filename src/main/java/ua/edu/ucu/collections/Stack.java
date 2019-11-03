package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;
import ua.edu.ucu.collections.immutable.ImmutableNode;

public class Stack {
    private ImmutableNode peek;
    private ImmutableLinkedList elements;

    public Stack() {
        peek = null;
        elements = new ImmutableLinkedList();
    }

    public Stack(ImmutableLinkedList elements) {
        this.peek = elements.getHead();
        this.elements = elements;
    }

    public Object getPeek () {
        if (peek != null)
            return peek.getValue();
        return null;
    }

    public Object pop() {
        Object toReturn = elements.getLast();
        elements = elements.removeLast();
        return toReturn;
    }

    public void enqueue(Object e) {
        elements = elements.addLast(e);
        peek = elements.getTail();
    }
}
