package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Queue {
    private Object peek;
    private ImmutableLinkedList elements;

    public Queue() {
        peek = null;
        elements = new ImmutableLinkedList();
    }

    public Queue(ImmutableLinkedList elements) {
        this.peek = elements.getFirst();
        this.elements = elements;
    }

    public Object getPeek() {
        return peek;
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
            peek = elements.getFirst();
        }
    }
}
