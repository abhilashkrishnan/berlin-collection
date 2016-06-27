package org.rockor.collection;

/**
 * The <code>LinkedStack</code> represents a last-in-first-out list of objects using linked list
 */
public class LinkedStack<E> extends LinkedList<E> {

    public LinkedStack() {

    }

    public void push (E e) {
        addFirst(e);
    }

    public E pop () {
        E e = removeFirst();
        return e;
    }

    public boolean empty() {
        return size() == 0;
    }
}
