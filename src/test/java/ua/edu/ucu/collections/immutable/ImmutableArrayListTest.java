package ua.edu.ucu.collections.immutable;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ImmutableArrayListTest {
    private ImmutableArrayList empty = new ImmutableArrayList();
    private ImmutableArrayList array = new ImmutableArrayList(3, new Integer[] {4, 2, 5});

    @Test
    public void add() {
        ImmutableArrayList newArray = (ImmutableArrayList) empty.add((Integer) 5);
        assertEquals(1, newArray.size());
        assertEquals(new Object[] {1}, newArray.toArray());
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
        int index = array.indexOf(4);
        assertEquals(0, index);
        index = empty.indexOf('a');
        assertEquals(-1, index);
    }

    @Test
    public void size() {
        assertEquals(0, empty.size());
        assertEquals(3, array.size());
    }

    @Test
    public void clear() {
        ImmutableArrayList cleared = (ImmutableArrayList) array.clear();
        assertEquals(0, cleared.size());
        assertEquals(new Object[] {}, cleared.toArray());
    }

    @Test
    public void isEmpty() {
        assertTrue(empty.isEmpty());
        assertFalse(array.isEmpty());
    }

    @Test
    public void toArray() {
        Integer[] arr = (Integer[]) array.toArray();
        assertEquals(new Integer[] {4, 2, 5}, arr);
    }
}
