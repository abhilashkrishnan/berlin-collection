package org.rockor.collection;

/**
 * Circular linked list implementation using <code>SinglyLinkedList</code>
 * @author Abhilash Krishnan
 */
public class CircularSinglyLinkedList<E> extends SinglyLinkedList<E> {

    public CircularSinglyLinkedList() {

    }

    public  void link(E e) {
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

    public E unlink(Node<E> n) {
        E e = n.item;
        size--;
        return e;
    }

    public E unlinkFirst(Node<E> p) {
        Node<E> h = head;
        Node<E> prev = null;
        for (Node<E> cur = h; cur.next != h; cur = cur.next)
            prev = cur;

        if(prev != null)
            prev.next = p.next;
        head = p.next;
        return unlink(p);
    }

    public E unlinkLast(Node<E> h) {
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
     * Removes the first inserted element
     * @return first inserted element
     */
    public E removeFirst() {
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
                e = unlinkFirst(next);
        }
        return e;
    }

    /**
     * Remove the last inserted element
     * @return the last inserted element
     */
    public E removeLast() {
        E e;
        Node<E> h = head;

        if (h == null)
            throw new NoElementException();
        else if(h.next == h) {
            e = unlink(h);
            head = null;
        }
        else {
            e = unlinkLast(h);
        }

        return e;
    }
}
