package org.brelin.collection;

/**
 * The <code>ArrayStack</code> represents a last-in-first-out list of objects using <code>ArrayList</code>
 * @author Abhilash Krishnan
 */
public class ArrayStack<E> extends ArrayList<E> {

    public ArrayStack() {

    }

    public void push(E e) {
        add(e);
    }

    public E pop() {
        E e;

        int len = size();
        e = removeElementAt(len - 1);

        return e;
    }

    public boolean empty() {
        return size() == 0;
    }
}
