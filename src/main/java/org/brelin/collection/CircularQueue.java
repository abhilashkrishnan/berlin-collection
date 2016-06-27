package org.brelin.collection;

/**
 * @author Abhilash Krishnan
 */
public class CircularQueue<E> extends CircularLinkedList<E> {

    public CircularQueue() {

    }

    public void enQueue(E e) {
        add(e);
    }

    public E deQueue() {
        E e = removeEldest();
        return e;
    }

    public boolean empty() {
        return size() == 0;
    }
}
