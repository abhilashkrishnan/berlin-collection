package org.brelin.collection;

/**
 * The <code>DeQueue</code> represents double ended queue
 */
public class DeQueue<E> extends LinkedList<E> {

    public DeQueue() {

    }

    public void enQueueFirst(E e) {
        addFirst(e);
    }

    public void enQueueLast(E e) {
        addLast(e);
    }

    public E deQueueFirst() {
        E e = removeFirst();
        return e;
    }

    public E deQueueLast() {
        E e = removeLast();
        return e;
    }

    public boolean empty() {
        return size() == 0;
    }
}
