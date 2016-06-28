package org.berlinframework.collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Abhilash Krishnan
 */
public class PriorityQueueTest {
    PriorityQueue<String> queue;

    @Before
    public void setUp() throws Exception {
        queue = new PriorityQueue<>();
    }

    @After
    public void tearDown() throws Exception {
        queue = null;
    }

    @Test
    public void size() throws Exception {
        queue.enQueue("Abhilash", 5);
        queue.enQueue("Mark", 2);
        queue.enQueue("Sasha", 1);
        assertEquals(3, queue.size());
    }

    @Test
    public void enQueue() throws Exception {
        queue.enQueue("Abhilash", 3);
        queue.enQueue("Mark", 1);
        queue.enQueue("Sasha", 4);
        queue.enQueue("Larry", 2);
        assertEquals(4, queue.size());
    }

    @Test
    public void deQueue() throws Exception {
        queue.enQueue("Abhilash", 3);
        queue.enQueue("Mark", 1);
        queue.enQueue("Sasha", 4);
        queue.enQueue("Larry", 2);
        assertEquals("Mark", queue.deQueue());
        assertEquals("Larry", queue.deQueue());
        assertEquals("Abhilash", queue.deQueue());
        assertEquals("Sasha", queue.deQueue());

    }

    @Test
    public void toArray() throws Exception {
        queue.enQueue("Abhilash", 3);
        queue.enQueue("Mark", 1);
        queue.enQueue("Sasha", 4);
        queue.enQueue("Larry", 2);
        assertEquals(4, queue.toArray().length);
        for (Object o : queue.toArray())
            System.out.println(o.toString());
    }

    @Test
    public void empty() throws Exception {
        queue.enQueue("Abhilash", 3);
        assertFalse(queue.empty());
        queue.deQueue();
        assertTrue(queue.empty());
    }
}