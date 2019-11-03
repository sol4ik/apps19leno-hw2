package ua.edu.ucu.collections.immutable;

import org.junit.Test;
import static org.junit.Assert.*;

public class ImmutableLinkedListTest {
    private ImmutableLinkedList empty = new ImmutableLinkedList();
    private ImmutableLinkedList list = new ImmutableLinkedList(new Object[] {2, 3, 4});

    @Test
    public void getHead() {
        assertNull(empty.getHead());
        assertEquals(2, list.getHead().getValue());
    }

    @Test
    public void getTail() {
        assertNull(empty.getTail());
        assertEquals(4, list.getTail().getValue());
    }

    @Test
    public void add() {
        assertEquals(new Object[] {1}, empty.add(1).toArray());
    }

    @Test
    public void testAdd() {
    }

    @Test
    public void addAll() {
    }

    @Test
    public void testAddAll() {
    }

    @Test
    public void getNode() {
    }

    @Test
    public void get() {
    }

    @Test
    public void remove() {
    }

    @Test
    public void set() {
    }

    @Test
    public void indexOf() {
    }

    @Test
    public void size() {
    }

    @Test
    public void clear() {
    }

    @Test
    public void isEmpty() {
    }

    @Test
    public void toArray() {
    }

    @Test
    public void addFirst() {
    }

    @Test
    public void addLast() {
    }

    @Test
    public void getFirst() {
    }

    @Test
    public void getLast() {
    }

    @Test
    public void removeFirst() {
    }

    @Test
    public void removeLast() {
    }

    @Test
    public void testToString() {
    }
}
