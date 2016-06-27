package org.rockor.collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ACER on 26-06-2016.
 */
public class CircularLinkedListTest {

    CircularLinkedList<String> list;

    @Before
    public void setUp() throws Exception {
        list = new CircularLinkedList<>();
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
    public void removeFirstElement() throws Exception {
        list.add("Abhilash");
        list.add("Mark");
        //list.add("Larry");
        //list.add("Einstein");
        assertEquals("Abhilash", list.removeEldest());
        assertEquals("Mark", list.removeEldest());
        //assertEquals("Larry", list.removeEldest());
        //assertEquals("Einstein", list.removeEldest());
        //list.removeEldest();
    }

    @Test
    public void removeLast() throws Exception {
        list.add("Abhilash");
        list.add("Mark");
        //list.add("Sasha");
        //assertEquals("Sasha", list.removeRecent());
        assertEquals("Mark", list.removeRecent());
        assertEquals("Abhilash", list.removeRecent());
        //list.removeRecent();
    }

    @Test
    public void size() throws Exception {
        list.add("Abhilash");
        list.add("Mark");
        assertEquals(2, list.size());
        list.removeRecent();
        assertEquals(1, list.size());
        list.removeRecent();
        assertEquals(0, list.size());
    }
}