package org.rockor.collection;

/**
 * @author Abhilash Krishnan
 */
public class CircularQueue<E> extends CircularSinglyLinkedList<E> {

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
