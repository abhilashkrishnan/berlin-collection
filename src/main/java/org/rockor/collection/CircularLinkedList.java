package org.rockor.collection;

/**
 * Circular linked list implementation using singly linked list
 * @author Abhilash Krishnan
 */
public class CircularLinkedList<E> {
    transient int size = 0;

    transient Node<E> head;

    public CircularLinkedList() {

    }

    public int size() {
        return size;
    }

    void link(E e) {
        Node<E> h = head;
        Node<E> newNode = new Node<>(e, h);
        head = newNode;

        if (h == null) {
            head.next = newNode;
        }
        else {
            Node<E> next = null;
            for (Node<E> cur = h; cur.next != h; cur = cur.next)
                next = cur.next;

            if (next != null)
                next.next = newNode;
            else h.next = newNode;
        }

        size++;
    }

    E unlink(Node<E> n) {
        E e = n.item;
        size--;
        return e;
    }

    E unlinkEldest(Node<E> p) {
        Node<E> h = head;
        Node<E> prev = null;
        for (Node<E> cur = h; cur.next != h; cur = cur.next)
            prev = cur;

        if(prev != null)
            prev.next = p.next;
        head = p.next;
        return unlink(p);
    }

    E unlinkRecent(Node<E> h) {
        Node<E> next = null;
        for (Node<E> cur = h; cur.next != h; cur = cur.next)
            next = cur.next;

        if(next != null) {
            next.next = h.next;
            head = h.next;
        }

        return unlink(h);
    }

    public void add(E e) {
        link(e);
    }

    /**
     * Remove the eldest added element
     * @return eldest added element
     */
    public E removeEldest() {
        E e = null;
        Node<E> h = head;

        if(h == null)
            throw new NoElementException();

        if (h.next == h) {
            e = unlink(h);
            head = null;
        }
        else {
            Node<E> next = null;
            for (Node<E> cur = h; cur.next != h; cur = cur.next)
                next = cur.next;

            if (next != null)
                e = unlinkEldest(next);
        }
        return e;
    }

    /**
     * Remove the recent added element
     * @return the recent added element
     */
    public E removeRecent() {
        E e;
        Node<E> h = head;

        if (h == null)
            throw new NoElementException();
        else if(h.next == h) {
            e = unlink(h);
            head = null;
        }
        else {
            e = unlinkRecent(h);
        }

        return e;
    }

    private static class Node<E> {
        E item;
        Node<E> next;

        Node(E element, Node<E> next) {
            this.item = element;
            this.next = next;
        }
    }
}
