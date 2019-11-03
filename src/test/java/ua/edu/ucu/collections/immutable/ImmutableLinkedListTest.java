package ua.edu.ucu.collections.immutable;

import org.junit.Test;

import java.util.Arrays;

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
        assertEquals(new Object[] {2, 1, 3, 4}, list.add(1, 1).toArray());
    }

    @Test
    public void addAll() {
        assertEquals(new Object[] {10, 9}, empty.addAll(new Object[] {10, 9}).toArray());
    }

    @Test
    public void testAddAll() {
        assertEquals(new Object[] {2, 1, 1, 3, 4},
                list.add(1, new Object[] {1, 1}).toArray());
    }

    @Test
    public void getNode() {
        assertEquals(3, list.getNode(1).getValue());
    }

    @Test
    public void get() {
        assertEquals(2, list.get(0));
    }

    @Test
    public void remove() {
        assertEquals(new Object[] {2, 3}, list.remove(2).toArray());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void set() {
        empty.set(2, 3);
    }

    @Test
    public void testSet() {
        assertEquals(new Object[] {1, 3, 4}, list.set(0, 1).toArray());
    }

    @Test
    public void indexOf() {
        assertEquals(0, list.indexOf(2));
        assertEquals(-1, empty.indexOf(2));
    }

    @Test
    public void size() {
        assertEquals(3, list.size());
        assertEquals(0, empty.size());
    }

    @Test
    public void clear() {
        ImmutableLinkedList newEmpty = (ImmutableLinkedList) list.clear();
        assertTrue(newEmpty.isEmpty());
    }

    @Test
    public void isEmpty() {
        assertTrue(empty.isEmpty());
        assertFalse(list.isEmpty());
    }

    @Test
    public void toArray() {
        assertEquals(new Object[] {2, 3, 4}, list.toArray());
    }

    @Test
    public void addFirst() {
        assertEquals(new Object[] {0, 2, 3, 4}, list.addFirst(0).toArray());
    }

    @Test
    public void addLast() {
        assertEquals(new Object[] {10}, empty.addFirst(10).toArray());
    }

    @Test
    public void getFirst() {
        assertEquals(2, list.getFirst());
    }

    @Test
    public void getLast() {
        assertEquals(4, list.getLast());
    }

    @Test
    public void removeFirst() {
        assertEquals(new Object[] {3, 4}, list.removeFirst().toArray());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void removeLast() {
        empty.removeLast();
    }

    @Test
    public void testToString() {
        assertEquals(Arrays.toString(new Object[] {2, 3, 4}), list.toString());
    }
}
