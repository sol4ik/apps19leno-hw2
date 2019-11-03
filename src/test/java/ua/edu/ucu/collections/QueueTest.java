package ua.edu.ucu.collections;

import org.junit.Test;
import ua.edu.ucu.collections.immutable.ImmutableLinkedList;
import ua.edu.ucu.collections.immutable.Node;

import static org.junit.Assert.*;

public class QueueTest {
    private Queue queue = new Queue(new ImmutableLinkedList(new Object[] {4, 2, 9, 11}));
    private Queue empty = new Queue();

    @Test
    public void getPeek() {
        assertEquals(4, queue.getPeek());
    }

    @Test
    public void dequeue() {
        assertEquals(4, queue.dequeue());
    }

    @Test
    public void enqueue() {
        empty.enqueue('a');
        assertEquals('a', empty.getPeek());
    }
}
