package org.rockor.collection;

import org.rockor.collection.SinglyLinkedList;

import static org.junit.Assert.*;

/**
 * @author Abhilash Krishnan
 */
public class SinglyLinkedListTest {
    SinglyLinkedList<String> list;

    @org.junit.Before
    public void setUp() throws Exception {
        list = new SinglyLinkedList<>();
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
    public void push() throws Exception {
        list.push("Mark");
        assertNotNull(list.head);
        assertNotNull(list.tail);
    }

    @org.junit.Test
    public void pop() throws Exception {
        list.push("Mark");
        list.push("Steve");
        String s = list.pop();
        assertEquals("Steve", s);
        s = list.pop();
        assertEquals("Mark", s);
    }

    @org.junit.Test
    public void toArray() throws Exception {
        list.push("Mark");
        list.push("Steve");
        list.push("Larry");
        Object[] arr = list.toArray();
        assertNotNull(arr);
        assertTrue(arr.length == 3);
    }
}