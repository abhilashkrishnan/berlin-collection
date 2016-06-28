package org.berlinframework.collection;

import java.util.Arrays;

/**
 * Resizable array implementation
 * @author Abhilash Krishnan
 */
public class ArrayList<E> {
    private static int EMPTY_LIST_SIZE = 10;

    transient Object[] elements;
    transient int size;

    public ArrayList() {
        this.elements = new Object[EMPTY_LIST_SIZE];
    }

    public int size() {
        return size;
    }

    void ensureCapacity(int minCapacity) {
        if(minCapacity > elements.length)
            grow(minCapacity);
    }

    void grow(int minCapacity) {
        int oldCapacity = elements.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);

        if(newCapacity - minCapacity < 0)
            newCapacity = minCapacity;
        elements = Arrays.copyOf(elements, newCapacity);
    }

    void rangeCheck(int index) {
        if(index < 0 || index > size)
            throw new ArrayIndexOutOfBoundsException();
    }

    public E get(int index) {
        rangeCheck(index);
        return (E) elements[index];
    }

    public boolean add(E e) {
        ensureCapacity(size + 1);
        elements[size++] = e;
        return true;
    }

    public E removeElementAt(int index) {
        E e;
        rangeCheck(index);
        e = (E) elements[index];
        fastRemove(index);
        return e;
    }

    public boolean remove(Object o) {
        if(o == null) {
            for(int index = 0; index < size; index++)
                if(elements[index] == null) {
                    fastRemove(index);
                    return true;
                }
        }else {
            for(int index = 0; index < size; index++)
                if(o.equals(elements[index])) {
                    fastRemove(index);
                    return true;
                }
        }
        return false;
    }

    void fastRemove(int index) {
        int moved = size - index - 1;
        if(moved > 0)
            System.arraycopy(elements, index+1, elements, index, moved);
        elements[--size] = null;
    }
}
