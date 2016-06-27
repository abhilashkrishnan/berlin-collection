package org.brelin.collection;

/**
 * The <code>LinearQueue</code> represents a first-in-first-out list of objects using <code>ArrayList</code>
 * @author Abhilash Krishnan
 */
public class LinearQueue<E> extends ArrayList<E> {

    public LinearQueue() {

    }

    public void enQueue(E e) {
        add(e);
    }

    public E deQueue() {
        E e = removeElementAt(0);
        return e;
    }

    public boolean empty() {
        return size() == 0;
    }
}
