package org.rockor.collection;

/**
 * The <code>Stack</code> represents a last-in-first-out list of objects
 * @author Abhilash Krishnan
 */
public class Stack<E> extends ArrayList<E> {

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
