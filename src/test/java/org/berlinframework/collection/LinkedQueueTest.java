package org.berlinframework.collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Abhilash Krishnan
 */
public class LinkedQueueTest {
    LinkedQueue<String> queue;

    @Before
    public void setUp() throws Exception {
        queue = new LinkedQueue<>();
    }

    @After
    public void tearDown() throws Exception {
        queue = null;
    }

    @Test
    public void enQueue() throws Exception {
        queue.enQueue("Abhilash");
        queue.enQueue("Mark");
        assertTrue(queue.size() == 2);
    }

    @Test
    public void deQueue() throws Exception {
        queue.enQueue("Abhilash");
        queue.enQueue("Mark");
        assertEquals("Abhilash", queue.deQueue());
        assertEquals("Mark", queue.deQueue());
    }

    @Test
    public void empty() throws Exception {
        queue.enQueue("Abhilash");
        queue.enQueue("Mark");
        assertFalse(queue.empty());
        queue.deQueue();
        queue.deQueue();
        assertTrue(queue.empty());
    }

}