package org.brelin.collection;

/**
 * The <code>LinkedQueue</code> is a first-in-first-out list of objects
 * @author Abhilash Krishnan
 */
public class LinkedQueue<E> extends LinkedList<E> {

    public LinkedQueue() {

    }

    public void enQueue(E e) {
        addLast(e);
    }

    public E deQueue() {
        E e = removeFirst();
        return e;
    }

    public boolean empty() {
        return size() == 0;
    }
}
