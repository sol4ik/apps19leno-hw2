package ua.edu.ucu.collections.immutable;

public final class ImmutableLinkedList implements ImmutableList {
    private final int size;
    private final ImmutableNode head;
    private final ImmutableNode tail;

    public ImmutableLinkedList() {
        size = 0;
        head = null;
        tail = null;
    }

    public ImmutableLinkedList(int size, ImmutableNode head, ImmutableNode tail) {
        this.size = size;
        this.head = head;
        this.tail = tail;
    }

    public ImmutableNode getHead() {
        return head;
    }

    public ImmutableNode getTail() {
        return tail;
    }

    private void checkIndex(int idx) throws IndexOutOfBoundsException {
        if (idx > size || idx < 0)
            throw new IndexOutOfBoundsException();
    }
    
    public ImmutableList add(Object e) {
        ImmutableNode newHead;
        
        ImmutableNode curNode = newHead;

        return new ImmutableLinkedList(size + 1, newHead);
    }

    
    public ImmutableList add(int index, Object e) {
        return null;
    }

    
    public ImmutableList addAll(Object[] c) {
        return null;
    }

    
    public ImmutableList addAll(int index, Object[] c) {
        return null;
    }

    
    public Object get(int index) {
        return null;
    }

    
    public ImmutableList remove(int index) {
        return null;
    }

    
    public ImmutableList set(int index, Object e) {
        checkIndex(index);
        return null;
    }

    
    public int indexOf(Object e) {
        ImmutableNode curNode;
        curNode = head;
        for (int i = 0 ; i < size; i++) {
            if (curNode.getValue() == e)
                return i;
            curNode = curNode.getNext();
            return -1;
        }
    }

    
    public int size() {
        return size;
    }

    
    public ImmutableList clear() {
        return new ImmutableLinkedList(0, null, null);
    }

    
    public boolean isEmpty() {
        return (size == 0);
    }

    
    public Object[] toArray() {
        Object[] toReturn;
        toReturn = new Object[size];
        ImmutableNode curNode;
        curNode = head;
        for (int i = 0; i < size; i++) {
            toReturn[i] = curNode.getValue();
            curNode = curNode.getNext();
        }
        return toReturn;
    }

    public ImmutableLinkedList addFirst(Object e) {
        ImmutableNode newHead;
        newHead = new ImmutableNode(e, null, null);
        newHead.setNext(head.clone());
        ImmutableNode newTail;
        return new ImmutableLinkedList(size + 1, newHead, newTail);
    }

    public ImmutableLinkedList addLast(Object e) {
        ImmutableNode newHead;
        ImmutableNode newTail;
        return new ImmutableLinkedList(size + 1, newHead, newTail);
    }

    public Object getFirst() {
        return head.getValue();
    }

    public Object getLast() {
        return tail.getValue();
    }

    public ImmutableLinkedList removeFirst() {
        ImmutableNode newHead;
        ImmutableNode newTail;
        return new ImmutableLinkedList(size - 1, newHead, newTail);
    }

    public ImmutableLinkedList removeLast() {
        ImmutableNode newHead;
        ImmutableNode newTail;
        return new ImmutableLinkedList(size - 1, newHead, newTail);
    }
}
