package org.brelin.collection;

/**
 * @author Abhilash Krishnan
 */
public class PriorityQueue<E> {

    transient int size = 0;
    transient  Node<E> head;

    public PriorityQueue() {

    }

    public int size() {
        return size;
    }

    void link(E e, Integer p) {
        Node<E> h = head;
        Node<E> newNode = new Node<>(e,p,null);

        if (h == null || p < h.priority) {
            newNode.next = h;
            head = newNode;
        } else {
            Node<E> next = null;
            for (Node<E> cur = h; cur.next != null && cur.next.priority <= p; cur = cur.next)
                next = cur.next;

            if (next == null) {
                newNode.next = h.next;
                h.next = newNode;
            }else {
                newNode.next = next.next;
                next.next = newNode;
            }
        }
        size++;
    }

    public void enQueue(E e, Integer p) {
        link(e, p);
    }

    E unlink(Node<E> h) {
        E e = h.item;
        size--;
        return e;
    }

    public E deQueue() {
        Node<E> h = head;
        head = h.next;
        E e = unlink(h);
        h = null;
        return e;
    }

    public boolean empty() {
        return size() == 0;
    }

    public Object[] toArray() {
        Object[] result = new Object[size];
        int i = 0;
        for (Node<E> x = head; x != null; x = x.next)
            result[i++] = x.item;
        return result;
    }

    private static class Node<E> {
        E item;
        Integer priority; //Lower value higher priority
        Node<E> next;

        Node(E element, Integer priority, Node<E> next) {
            this.item = element;
            this.priority = priority;
            this.next = next;
        }
    }
}
