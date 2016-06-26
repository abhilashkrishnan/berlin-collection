package org.rockor.collection;

/**
 * The <code>Queue</code> is a first-in-first-out list of objects
 * @author Abhilash Krishnan
 */
public class Queue<E> extends SinglyLinkedList<E> {

    public Queue() {

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
