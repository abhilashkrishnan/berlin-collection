package org.rockor.collection;

import static org.junit.Assert.*;

/**
 * @author Abhilash Krishnan
 */
public class LinkedListTest {
    LinkedList<String> list;

    @org.junit.Before
    public void setUp() throws Exception {
        list = new LinkedList<>();
    }

    @org.junit.After
    public void tearDown() throws Exception {
        list = null;
    }

    @org.junit.Test
    public void addFirst() throws Exception {
        list.addFirst("Mark");
        assertNotNull(list.head);
        assertNotNull(list.tail);
    }

    @org.junit.Test
    public void addLast() throws Exception {
        list.addLast("Mark");
        assertNotNull(list.head);
        assertNotNull(list.tail);
    }


    @org.junit.Test
    public void removeFirst() throws Exception {
        list.addFirst("Mark");
        list.addFirst("Steve");
        String s = list.removeFirst();
        assertEquals("Steve", s);
        s = list.removeFirst();
        assertEquals("Mark", s);
    }

    @org.junit.Test
    public void removeLast() throws Exception {
        list.addLast("Mark");
        list.addLast("Steve");

        String s = list.removeLast();
        assertEquals("Steve", s);
        s = list.removeLast();
        assertEquals("Mark", s);
    }

    @org.junit.Test
    public void toArray() throws Exception {
        list.addFirst("Mark");
        list.addFirst("Steve");
        list.addFirst("Larry");
        Object[] arr = list.toArray();
        assertNotNull(arr);
        assertTrue(arr.length == 3);
    }
}