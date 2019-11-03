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
        this.head = head.copy();

        Node curToCopyFrom = head;
        Node curPrev = null;
        Node curNode = this.head;

        for (int i = 0; i < size; i++) {
            curNode.setNext(curToCopyFrom.getNext().copy());
            curNode.setPrev(curPrev);

            curNode = curNode.getNext();
            curPrev = curNode;
            curToCopyFrom = curToCopyFrom.getNext();
        }
        this.tail = curNode.copy();
        this.tail.setPrev(curNode.getPrev());
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
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
        Node newHead;
        if (head != null) {
            newHead = head.copy();
        }
        else {
            newHead = new Node(null);
            // means we will be adding dome values to the head of the list
        }
        Node curNode = newHead;
        Node curPrev = null;
        Node curToCopyFrom = head;
        for (int i = 0; i < index; i++) {
            curNode.setNext(curToCopyFrom.getNext().copy());
            curNode.setPrev(curPrev);

            curPrev = curNode;
            curNode = curNode.getNext();
            curToCopyFrom = curToCopyFrom.getNext();
        }
        for (int i = 0; i < c.length; i++) {
            curNode.setNext(new Node(c[i], null, curPrev));
            curPrev = curNode;
            curNode = curNode.getNext();
        }
        for (int i = index + c.length; i < size; i++) {
            curNode.setNext(curToCopyFrom.getNext().copy());
            curNode.setPrev(curPrev);

            curPrev = curNode;
            curNode = curNode.getNext();
            curToCopyFrom = curToCopyFrom.getNext();
        }
        return new ImmutableLinkedList(size + c.length, newHead);
    }

    public Node getNode(int index) {
        checkIndex(index);
        Node curNode;
        if (index < size / 2) {
            int idx = 0;
            curNode = head;
            while (idx != index) {
                curNode = curNode.getNext();
                idx++;
            }
        }
        else {
            int idx = size - 1;
            curNode = tail;
            while (idx != index) {
                curNode = curNode.getPrev();
                idx--;
            }
        }
        return curNode;
    }

    public Object get(int index) {
        return getNode(index).getValue();
    }
    
    public ImmutableList remove(int index) {
        checkIndex(index);
        ImmutableLinkedList toReturn =
                new ImmutableLinkedList(size - 1, head);
        Node curNode = toReturn.getNode(index).getPrev();
        curNode.setNext(curNode.getNext().getNext());
        return toReturn;
    }

    
    public ImmutableList set(int index, Object e) {
        checkIndex(index);
        ImmutableLinkedList toReturn;
        toReturn = new ImmutableLinkedList(size, head);
        Node curNode = toReturn.getNode(index);
        curNode.setValue(e);
        return toReturn;
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
        return new ImmutableLinkedList(size - 1, head.getNext());
    }

    public ImmutableLinkedList removeLast() {
        return new ImmutableLinkedList(size - 1, head);
    }

    @Override
    public String toString() {
        Object[] array = toArray();
        return Arrays.toString(array);
    }
}
