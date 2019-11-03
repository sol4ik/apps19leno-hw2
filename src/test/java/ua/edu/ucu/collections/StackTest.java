package ua.edu.ucu.collections;

import org.junit.Test;
import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

import static org.junit.Assert.*;

public class StackTest {
    private Stack stack = new Stack(new ImmutableLinkedList(new Object[] {4, 2, 9, 11}));
    private Stack empty = new Stack();


    @Test
    public void getPeek() {
        assertEquals(11, stack.getPeek());
    }

    @Test
    public void pop() {
        assertEquals(11, stack.pop());
        assertEquals(9, stack.getPeek());
    }

    @Test
    public void push() {
        empty.push(11);
        assertEquals(11, empty.getPeek());
    }
}
