package org.brelin.collection;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ACER on 26-06-2016.
 */
public class ArrayListTest {
    ArrayList<String> list;

    @org.junit.Before
    public void setUp() throws Exception {
        list = new ArrayList<>();
    }

    @org.junit.After
    public void tearDown() throws Exception {
        list = null;
    }

    @Test
    public void ensureCapacity() throws Exception {
        list.add("Mark");
        list.add("Zuck");
        list.add("Steve");
        list.add("Bill");
        list.add("Gates");
        list.add("Abhilash");
        list.add("Larry");
        list.add("Elison");
        list.add("Einstein");
        list.add("Nicola");
        list.add("Tesla");
        assertEquals(11, list.size());
    }


    @Test
    public void get() throws Exception {
        list.add("Mark");
        list.add("Zuck");
        list.add("Steve");
        assertEquals("Mark", list.get(0));
    }

    @Test
    public void add() throws Exception {
        assertTrue(list.add("Mark"));
    }

    @Test
    public void remove() throws Exception {
        list.add("Mark");
        list.add("Zuck");
        list.add("Steve");
        assertTrue(list.remove("Zuck"));
        assertFalse(list.remove("Bill"));
    }

}