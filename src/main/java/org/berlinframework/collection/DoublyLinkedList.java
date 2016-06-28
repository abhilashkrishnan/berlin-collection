package org.berlinframework.collection;

/**
 * Doubly linked list implementation
 * @author Abhilash Krishnan
 */
public class DoublyLinkedList<E> {

    transient int size = 0;

    transient Node<E> head;
    transient Node<E> tail;

    public DoublyLinkedList() {

    }

    public int size() {
        return size;
    }

    void linkHead(E e) {
        Node<E> h = head;
        Node<E> newNode = new Node<>(null, e, head);
        head = newNode;
        if(h == null)
            tail = newNode;
        size++;
    }

    void linkTail(E e) {
        Node<E> t = tail;
        Node<E> newNode = new Node<>(tail, e, null);
        tail = newNode;
        if(t == null)
            head = newNode;
        size++;
    }

    E unlinkHead(Node<E> h) {
        E e = h.item;
        Node<E> next = h.next;
        head = next;
        if (next == null)
            tail = null;
        else next.prev = null;
        size--;
        return e;
    }

    E unlinkTail(Node<E> t) {
        E e = t.item;
        Node<E> prev = t.prev;
        tail = prev;
        if (prev == null)
            head = null;
        else prev.next = null;
        size--;
        return e;
    }

    public void addFirst(E e) {
        linkHead(e);
    }

    public void addLast(E e) {
        linkTail(e);
    }

    public E removeFirst() {
        E e;
        Node<E> h = head;
        if(h == null)
            throw new NoElementException();

        e = unlinkHead(h);
        return e;
    }

    public E removeLast() {
        E e;
        Node<E> t = tail;
        if(t == null)
            throw new NoElementException();
        e = unlinkTail(t);
        return e;
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

        Node<E> prev;
        Node<E> next;

        Node(Node<E> prev, E item, Node<E> next) {
            this.prev = prev;
            this.item = item;
            this.next = next;
        }
    }
}
