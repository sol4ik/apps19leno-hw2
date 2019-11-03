package ua.edu.ucu.collections.immutable;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ImmutableArrayListTest {
    private ImmutableArrayList empty = new ImmutableArrayList();
    private ImmutableArrayList array = new ImmutableArrayList(3, new Integer[] {4, 2, 5});

    @Test
    public void add() {
        ImmutableArrayList newArray = (ImmutableArrayList) empty.add(5);
        assertEquals(1, newArray.size());
        assertEquals(new Object[] {5}, newArray.toArray());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAdd() {
        ImmutableArrayList newArray = (ImmutableArrayList) empty.add(2, 5);
    }

    @Test
    public void addAll() {
        ImmutableArrayList newArray = (ImmutableArrayList) array.addAll(new Object[] {3, 4});
        assertEquals(5, newArray.size());
        assertEquals(new Object[] {4, 2, 5, 3, 4}, newArray.toArray());
    }

    @Test
    public void testAddAll() {
        ImmutableArrayList newArray = (ImmutableArrayList) empty.addAll(0,  array.toArray());
        assertEquals(3, newArray.size());
        assertEquals(new Object[] {4, 2, 5}, newArray.toArray());
    }

    @Test
    public void get() {
        assertEquals(4, array.get(0));
    }

    @Test
    public void remove() {
        ImmutableArrayList newArray = (ImmutableArrayList) array.remove(2);
        assertEquals(new Object[] {4, 2}, newArray.toArray());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void set() {
        array.set(10, -5);
    }

    @Test
    public void testSet() {
        ImmutableArrayList newArray = (ImmutableArrayList) array.set(1, 3);
        assertEquals(new Object[] {4, 3, 5}, newArray.toArray());
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
