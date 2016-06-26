package org.rockor.collection;

/**
 * The <code>Queue</code> is a first-in-first-out list of objects
 * @author Abhilash Krishnan
 */
public class Queue<E> extends ArrayList<E> {

    public Queue() {

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
