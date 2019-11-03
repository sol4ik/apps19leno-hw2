package ua.edu.ucu.collections;

import org.junit.Test;
import ua.edu.ucu.collections.immutable.ImmutableLinkedList;
import ua.edu.ucu.collections.immutable.Node;

import static org.junit.Assert.*;

public class QueueTest {
    private Queue queue = new Queue(new ImmutableLinkedList(3, new Node(3), new Node(2)));
    private Queue empty = new Queue();

    @Test
    public void getPeek() {
    }

    @Test
    public void dequeue() {
    }

    @Test
    public void enqueue() {
    }
}
