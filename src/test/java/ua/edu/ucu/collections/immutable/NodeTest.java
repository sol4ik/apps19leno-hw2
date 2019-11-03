package ua.edu.ucu.collections.immutable;

import org.junit.Before;
import org.junit.Test;
import org.omg.CORBA.COMM_FAILURE;

import static org.junit.Assert.*;

public class NodeTest {
    private Node first;
    private Node second;
    private Node third;
    private Node forth;

    @Before
    public void setUp(){
        first = new Node(0);
        third = new Node("-2");
        second = new Node(null, third, forth);
        third.setPrev(second);
        forth = new Node(13, second, null);
    }

    @Test
    public void getValue() {
        assertEquals(0, first.getValue());
        assertEquals("-2", third.getValue());
        assertNull(second.getValue());
    }

    @Test
    public void setValue() {
        first.setValue("zero");
        assertEquals("zero", first.getValue());
    }

    @Test
    public void getPrev() {
        assertEquals(second, third.getPrev());
        assertNull(forth.getPrev());
    }

    @Test
    public void setPrev() {
        first.setPrev(third);
        assertEquals(third, first.getPrev());
    }

    @Test
    public void getNext() {
        assertEquals(third, second.getNext());
        assertNull(third.getNext());
    }

    @Test
    public void setNext() {
        first.setNext(forth);
        assertEquals(forth, first.getNext());
    }

//    @Test
//    public void clone() {
//
//    }
}