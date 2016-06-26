package org.rockor.collection;

/**
 * Created by ACER on 26-06-2016.
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
