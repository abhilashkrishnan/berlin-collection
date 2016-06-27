package org.brelin.collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Abhilash Krishnan
 */
public class ArrayStackTest {
    ArrayStack<String> stack;

    @Before
    public void setUp() throws Exception {
        stack = new ArrayStack<>();
    }

    @After
    public void tearDown() throws Exception {
        stack = null;
    }

    @Test
    public void push() throws Exception {
        stack.push("Abhilash");
        stack.push("Mark");
        assertTrue(stack.size() == 2);
    }

    @Test
    public void pop() throws Exception {
        stack.push("Abhilash");
        stack.push("Mark");
        assertEquals("Mark", stack.pop());
        assertEquals("Abhilash", stack.pop());
    }

    @Test
    public void empty() throws Exception {
        stack.push("Abhilash");
        assertFalse(stack.empty());
        stack.pop();
        assertTrue(stack.empty());
    }

}