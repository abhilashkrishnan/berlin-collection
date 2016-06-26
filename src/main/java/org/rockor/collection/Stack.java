package org.rockor.collection;

/**
 * The <code>Stack</code> represents a last-in-first-out list of objects using linked list
 */
public class Stack<E> extends SinglyLinkedList<E> {

    public Stack() {

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
