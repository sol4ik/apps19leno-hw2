package ua.edu.ucu.collections.immutable;

import java.util.Arrays;

public final class ImmutableArrayList implements ImmutableList {
    private final int size;
    private final Object[] elements;

    public ImmutableArrayList() {
        size = 0;
        elements = new Object[] {};
    }

    public ImmutableArrayList(int size, Object[] elements) {
        this.size = size;
        this.elements = Arrays.copyOf(elements, size);
    }

    private void checkIndex(int index) throws IndexOutOfBoundsException {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
    }

    public ImmutableList add(Object e) {
        Object[] newElements;
        newElements = Arrays.copyOf(elements, size);
        newElements[size - 1] = e;
        return new ImmutableArrayList(size + 1, newElements);
    }
    
    public ImmutableList add(int index, Object e) {
        checkIndex(index);

        Object[] newElements = new Object[size + 1];
        System.arraycopy(elements, 0, newElements, 0, index);
        newElements[index] = e;
        System.arraycopy(elements, index, newElements, index + 1,
                size - index - 1);
        return new ImmutableArrayList(size + 1, newElements);
    }
    
    public ImmutableList addAll(Object[] c) {
        Object[] newElements = new Object[size + c.length];
        System.arraycopy(elements, 0, newElements, 0, size);
        System.arraycopy(c, 0, newElements, size, c.length);
        return new ImmutableArrayList(size + c.length, newElements);
    }

    public ImmutableList addAll(int index, Object[] c) {
        Object[] newElements = new Object[size + c.length];
        System.arraycopy(elements, 0, newElements, 0, index);
        System.arraycopy(c, 0, newElements, index, c.length);
        System.arraycopy(elements, index, newElements, index + c.length,
                size - index - 1);
        return new ImmutableArrayList(size + c.length, newElements);
    }

    public Object get(int index) {
        checkIndex(index);
        return elements[index];
    }

    public ImmutableList remove(int index) {
        checkIndex(index);
        Object[] newElements = new Object[size - 1];
        for (int i = 0; i < size - 1; i++)
            if (i > index) {
                newElements[i] = elements[i];
            }
            else {
                newElements[i] = elements[i + 1];
            }
        return new ImmutableArrayList(size - 1, newElements);
    }
    
    public ImmutableList set(int index, Object e) {
        checkIndex(index);
        Object[] newElements;
        newElements = Arrays.copyOf(elements, size);
        newElements[index] = e;
        return new ImmutableArrayList(size - 1, newElements);
    }
    
    public int indexOf(Object e) {
        for (int i = 0; i < size; i++)
            if (elements[i] == e) {
                return i;
            }
        return -1;
    }

    public int size() {
        return size;
    }

    public ImmutableList clear() {
        return new ImmutableArrayList(0, new Object[] {});
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Object[] toArray() {
        Object[] toReturn;
        toReturn = Arrays.copyOf(elements, size);
        return toReturn;
    }

    @Override
    public String toString() {
        return Arrays.toString(elements);
    }
}
