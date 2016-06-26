package org.rockor.collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Abhilash Krishnan
 */
public class LinearQueueTest {
    LinearQueue<String> queue;

    @Before
    public void setUp() throws Exception {
        queue = new LinearQueue<>();
    }

    @After
    public void tearDown() throws Exception {
        queue = null;
    }

    @Test
    public void enQueue() throws Exception {
        queue.enQueue("Abhilash");
        queue.enQueue("Sasha");
        assertEquals(2, queue.size());
    }

    @Test
    public void deQueue() throws Exception {
        queue.enQueue("Abhilash");
        queue.enQueue("Sasha");
        assertEquals("Abhilash", queue.deQueue());
        assertEquals("Sasha", queue.deQueue());
    }

    @Test
    public void empty() throws Exception {
        queue.enQueue("Abhilash");
        assertFalse(queue.empty());
        queue.deQueue();
        assertTrue(queue.empty());
    }

}