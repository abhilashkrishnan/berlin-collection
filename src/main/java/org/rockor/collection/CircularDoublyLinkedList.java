package org.rockor.collection;

/**
 * Circular linked list implementation using doubly linked list
 * @author Abhilash Krishnan
 */
public class CircularDoublyLinkedList<E> {
    transient int size = 0;

    transient Node<E> head;

    public int size() {
        return size;
    }

    void link(E e) {
        Node<E> h = head;

        Node<E> newNode = new Node<>(null, e, head);
        head = newNode;

        if (h == null) {
            newNode.prev = newNode;
            newNode.next = newNode;
        } else {
            Node<E> prev = null;

            for(Node<E> cur = h; cur.next != h; cur = cur.next)
                prev = cur.next;

            if (prev == null) {
                newNode.prev = h;
                h.prev = newNode;
                h.next = newNode;
            }
            else {
                newNode.prev = prev;
                prev.next = newNode;
                h.prev = newNode;
                //prev.prev = h;
            }
        }

        size++;
    }

    E unlink(Node<E> n) {
        E e = n.item;
        return e;
    }

    E unlinkEldest(Node<E> h) {
        E e = null;

        if(h.prev == h && h.next == h) {
            e = unlink(h);
            head = null;
        } else {
            Node<E> p = h.prev;

            if (p != null) {
                e = p.item;
                Node<E> n = p.prev;
                if (n != null)
                    n.next = head;
                head.prev = n;
            }
        }

        size--;
        return e;
    }

    E unlinkRecent(Node<E> h) {
        E e = unlink(h);

        if(h.prev == h && h.next == h)
            head = null;
        else {
            Node<E> p = h.prev;

            if (p != null)
                p.next = h.next;

            head = h.next;
            head.prev = p;
        }
        size--;
        return e;
    }

    public void add(E e) {
        link(e);
    }

    public E removeEldest() {
        Node<E> h = head;

        if (h == null)
            throw new NoElementException();

        E e = unlinkEldest(h);

        return e;
    }

    public E removeRecent() {
        Node<E> h = head;

        if (h == null)
            throw new NoElementException();

        E e = unlinkRecent(h);
        return e;
    }


    private static class Node<E> {
        E item;

        Node<E> prev;
        Node<E> next;

        Node(Node<E> prev, E element, Node<E> next) {
            this.prev = prev;
            this.item = element;
            this.next = next;
        }
    }

}
