package ua.edu.ucu.collections.immutable;


import java.util.Arrays;

public final class ImmutableLinkedList implements ImmutableList {
    private final int size;
    private final Node head;
    private final Node tail;

    public ImmutableLinkedList() {
        size = 0;
        head = null;
        tail = null;
    }

    public ImmutableLinkedList(int size, Node head) {
        this.size = size;
        if (head == null) {
            this.head = null;
        }
        else {
            this.head = head.copy();
        }
        Node curNode = this.head;
        Node curPrev = null;
        Node curToCopyFrom = head;
        for (int i = 0; i < size; i++) {
            if (curNode == null) {
                continue;
            }
            curNode.setNext(curToCopyFrom.getNext().copy());
            curNode.setPrev(curPrev);

            curNode = curNode.getNext();
            curPrev = curNode;
            curToCopyFrom = curToCopyFrom.getNext();
        }
        if (curNode == null) {
            this.tail = null;
        }
        else {
            this.tail = curNode.copy();
            this.tail.setPrev(curNode.getPrev());
        }
    }

    public ImmutableLinkedList(Object[] elements) {
        size = elements.length;
        head = new Node(elements[0]);
        Node curNode = head;
        Node curPrev = null;
        for (int i = 1; i < size; i++) {
            curNode.setNext(new Node(elements[i]));
            curNode.setPrev(curPrev);
            curPrev = curNode;
            curNode = curNode.getNext();
        }
        tail = curNode;
    }

    public Node getHead() {
        if (head == null) {
            return null;
        }
        return head;
    }

    public Node getTail() {
        if (tail == null) {
            return null;
        }
        return tail;
    }

    private void checkIndex(int idx) throws IndexOutOfBoundsException {
        if (idx > size || idx < 0) {
            throw new IndexOutOfBoundsException();
        }
    }
    
    public ImmutableList add(Object e) {
        return addAll(size, new Object[] {e});
    }

    
    public ImmutableList add(int index, Object e) {
        return addAll(index, new Object[] {e});
    }

    
    public ImmutableList addAll(Object[] c) {
        return addAll(size, c);
    }

    
    public ImmutableList addAll(int index, Object[] c) {
        Object[] elements = new Object[size + c.length];
        Node newHead;
        if (head != null) {
            newHead = head.copy();
        }
        else {
            newHead = null;
            // means we will be adding dome values to the head of the list
        }
        Node curNode = newHead;
        for (int i = 0; i < index; i++) {
            if (curNode == null) {
                continue;
            }
            elements[i] = curNode.getValue();
            curNode = curNode.getNext();
        }
        for (int i = 0; i < c.length; i++) {
            elements[i + index] = c[i];
        }
        for (int i = index; i < size; i++) {
            elements[i + c.length] = curNode.getValue();
            curNode = curNode.getNext();
        }
        return new ImmutableLinkedList(elements);
    }

    public Node getNode(int index) {
        checkIndex(index);
        Node curNode;
        int idx = 0;
        curNode = head;
        for (int i = 0; i < index; i++) {
            curNode = curNode.getNext();
        }
        return curNode;
    }

    public Object get(int index) {
        return getNode(index).getValue();
    }
    
    public ImmutableList remove(int index) {
        checkIndex(index);
        Object[] elements = new Object[size - 1];
        Node curNode = head;
        for (int i = 0; i < index; i++) {
            elements[i] = curNode.getValue();
            curNode = curNode.getNext();
        }
        for (int i = index + 1; i < size - 1; i++) {
            elements[i - 1] = curNode.getValue();
            curNode = curNode.getNext();
        }
        return new ImmutableLinkedList(elements);
    }

    
    public ImmutableList set(int index, Object e) {
        checkIndex(index);
        Object[] elements = toArray();
        elements[index] = e;
        return new ImmutableLinkedList(elements);
    }

    
    public int indexOf(Object e) {
        Node curNode;
        curNode = head;
        for (int i = 0; i < size; i++) {
            if (curNode.getValue() == e) {
                return i;
            }
            curNode = curNode.getNext();
        }
        return -1;
    }

    
    public int size() {
        return size;
    }

    
    public ImmutableList clear() {
        return new ImmutableLinkedList();
    }

    
    public boolean isEmpty() {
        return size == 0;
    }

    
    public Object[] toArray() {
        Object[] toReturn;
        toReturn = new Object[size];
        Node curNode;
        curNode = head;
        for (int i = 0; i < size; i++) {
            toReturn[i] = curNode.getValue();
            curNode = curNode.getNext();
        }
        return toReturn;
    }

    public ImmutableLinkedList addFirst(Object e) {
        return (ImmutableLinkedList) add(0, e);
    }

    public ImmutableLinkedList addLast(Object e) {
        return (ImmutableLinkedList) add(size, e);
    }

    public Object getFirst() {
        return head.getValue();
    }

    public Object getLast() {
        return tail.getValue();
    }

    public ImmutableLinkedList removeFirst() {
        return (ImmutableLinkedList) remove(0);
    }

    public ImmutableLinkedList removeLast() {
        return (ImmutableLinkedList) remove(size - 1);
    }

    @Override
    public String toString() {
        Object[] array = toArray();
        return Arrays.toString(array);
    }
}
