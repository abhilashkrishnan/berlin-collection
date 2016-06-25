package org.rockor.collection;

/**
 * Singly-linked list implementation.
 *
 * @author Abhilash Krishnan
 * @param <E> the type of the elements held in this list
  */
public class SinglyLinkedList<E> {

    transient int size = 0;

    transient Node<E> head;
    transient Node<E> tail;

    public SinglyLinkedList() {

    }

    private void linkHead(E e) {
        Node<E> h = head;
        Node<E> newNode = new Node<>(e, h);
        head = newNode;
        if(h == null) {
            tail = newNode;
        }
        size++;
    }

    public void addFirst(E e){
        linkHead(e);
    }

    private void linkTail(E e) {
        Node<E> t = tail;
        Node<E> newNode = new Node<>(e, null);
        tail = newNode;
        if(t == null)
            head = newNode;
        else
            t.next = newNode;
        size++;
    }

    public void addLast(E e) {
        linkTail(e);
    }

    private E unlinkHead(Node<E> h) {
        final E element = h.item;
        Node<E> next = h.next;
        h.item = null;
        h.next = null;
        head = next;
        if(next == null)
            tail = null;
        size--;
        return element;
    }

    private E unlinkTail(Node<E> t) {
        E element = t.item;
        t.item = null;
        t.next = null;

        Node<E> pre = null;

        for(Node<E> cur = head; cur.next != null; ) {
            pre = cur;
            cur = cur.next;
        }

        if(pre == null)
            head = pre;
        else
            pre.next = null;

        tail = pre;
        size--;
        return element;
    }

    public E removeFirst() {
        Node<E> h = head;
        if(h == null)
            throw new NoElementException();
        return unlinkHead(h);
    }

    public E removeLast() {
        Node<E> t = tail;
        if(t == null)
            throw new NoElementException();
        return unlinkTail(t);
    }

    public void push(E e) {
        addFirst(e);
    }

    public E pop() {
        return removeFirst();
    }

    public Object[] toArray() {
        Object[] result = new Object[size];
        int i=0;
        for(Node<E> x = head; x != null; x = x.next)
            result[i++] = x.item;
        return result;
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
