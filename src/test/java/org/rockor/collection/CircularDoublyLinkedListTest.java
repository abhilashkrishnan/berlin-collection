package org.rockor.collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ACER on 26-06-2016.
 */
public class CircularDoublyLinkedListTest {

    CircularDoublyLinkedList<String> list;

    @Before
    public void setUp() throws Exception {
        list = new CircularDoublyLinkedList<>();
    }

    @After
    public void tearDown() throws Exception {
        list = null;
    }

    @Test
    public void size() throws Exception {
        list.add("Abhilash");
        list.add("Mark");
        assertEquals(2, list.size());
    }

    @Test
    public void add() throws Exception {
        list.add("Abhilash");
        list.add("Mark");
        list.add("Sasha");
        list.add("Larry");
        assertEquals(3, list.size());
    }

    @Test
    public void removeEldest() throws Exception {
        list.add("Abhilash");
        list.add("Mark");
        list.add("Sasha");
        list.add("Larry");
        list.add("Bill");
        assertEquals("Abhilash", list.removeEldest());
        assertEquals("Mark", list.removeEldest());
        assertEquals("Sasha", list.removeEldest());
        assertEquals("Larry", list.removeEldest());
        assertEquals("Bill", list.removeEldest());
    }

    @Test
    public void removeRecent() throws Exception {
        list.add("Abhilash");
        list.add("Mark");
        list.add("Sasha");
        list.add("Larry");
        assertEquals("Larry", list.removeRecent());
        assertEquals("Sasha", list.removeRecent());
        assertEquals("Mark", list.removeRecent());
        assertEquals("Abhilash", list.removeRecent());
    }

}