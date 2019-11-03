package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;
import ua.edu.ucu.collections.immutable.Node;

public class Stack {
    private Node peek;
    private ImmutableLinkedList elements;

    public Stack() {
        peek = null;
        elements = new ImmutableLinkedList();
    }

    public Stack(ImmutableLinkedList elements) {
        this.peek = elements.getTail();
        this.elements = elements;
    }

    public Object getPeek() {
        if (peek != null) {
            return peek.getValue();
        }
        return null;
    }

    public Object pop() {
        if (elements.size() > 0) {
            Object toReturn = elements.getLast();
            elements = elements.removeLast();
            return toReturn;
        }
        else {
            return null;
        }
    }

    public void push(Object e) {
        elements = elements.addLast(e);
        peek = elements.getTail();
    }
}
