package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;
import ua.edu.ucu.collections.immutable.Node;

public class Queue {
    private Node peek;
    private ImmutableLinkedList elements;

    public Queue() {
        peek = null;
        elements = new ImmutableLinkedList();
    }

    public Queue(ImmutableLinkedList elements) {
        this.peek = elements.getHead();
        this.elements = elements;
    }

    public Object getPeek() {
        if (peek != null) {
            return peek.getValue();
        }
        return null;
    }

    public Object dequeue() {
        if (elements.size() > 0) {
            Object toReturn = elements.getFirst();
            elements = elements.removeFirst();
            peek = elements.getHead();
            return toReturn;
        }
        else {
            return null;
        }
    }

    public void enqueue(Object e) {
        elements = elements.addLast(e);
        if (elements.size() == 1) {
            peek = elements.getHead();
        }
    }
}
