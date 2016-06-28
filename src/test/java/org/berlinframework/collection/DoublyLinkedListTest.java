package org.berlinframework.collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ACER on 26-06-2016.
 */
public class DoublyLinkedListTest {
    DoublyLinkedList<String> list;

    @Before
    public void setUp() throws Exception {
        list = new DoublyLinkedList<>();
    }

    @After
    public void tearDown() throws Exception {
        list = null;
    }

    @Test
    public void addFirst() throws Exception {
        list.addFirst("Abhilash");
        list.addFirst("Mark");
        assertTrue(list.size() == 2);
    }

    @Test
    public void addLast() throws Exception {
        list.addFirst("Abhilash");
        list.addFirst("Mark");
        assertTrue(list.size() == 2);
    }

    @Test
    public void removeFirst() throws Exception {
        list.addFirst("Abhilash");
        list.addFirst("Mark");
        assertEquals("Mark", list.removeFirst());
        assertEquals("Abhilash", list.removeFirst());
    }

    @Test
    public void removeLast() throws Exception {
        list.addLast("Abhilash");
        list.addLast("Mark");
        assertEquals("Mark", list.removeLast());
        assertEquals("Abhilash", list.removeLast());
    }

}