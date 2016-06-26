package org.rockor.collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ACER on 26-06-2016.
 */
public class CircularSinglyLinkedListTest {

    CircularSinglyLinkedList<String> list;

    @Before
    public void setUp() throws Exception {
        list = new CircularSinglyLinkedList<>();
    }

    @After
    public void tearDown() throws Exception {
        list = null;
    }

    @Test
    public void add() throws Exception {
        list.add("Abhilash");
        list.add("Mark");
        assertTrue(list.size() == 2);
    }

    @Test
    public void removeFirst() throws Exception {
        list.add("Abhilash");
        list.add("Mark");
        //list.add("Larry");
        //list.add("Einstein");
        assertEquals("Abhilash", list.removeFirst());
        assertEquals("Mark", list.removeFirst());
        //assertEquals("Larry", list.removeFirst());
        //assertEquals("Einstein", list.removeFirst());
        //list.removeFirst();
    }

    @Test
    public void removeLast() throws Exception {
        list.add("Abhilash");
        list.add("Mark");
        //list.add("Sasha");
        //assertEquals("Sasha", list.removeLast());
        assertEquals("Mark", list.removeLast());
        assertEquals("Abhilash", list.removeLast());
        //list.removeLast();
    }

    @Test
    public void size() throws Exception {
        list.add("Abhilash");
        list.add("Mark");
        assertEquals(2, list.size());
        list.removeLast();
        assertEquals(1, list.size());
        list.removeLast();
        assertEquals(0, list.size());
    }
}