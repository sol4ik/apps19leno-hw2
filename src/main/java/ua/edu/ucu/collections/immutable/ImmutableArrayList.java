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
        return addAll(size, new Object[] {e});
    }
    
    public ImmutableList add(int index, Object e) {
        return addAll(index, new Object[] {e});
    }
    
    public ImmutableList addAll(Object[] c) {
        return addAll(size, c);
    }

    public ImmutableList addAll(int index, Object[] c) {
        Object[] newElements = new Object[size + c.length];
        for (int i = 0; i < index; i++) {
            newElements[i] = elements[i];
        }
        for (int i = 0; i < c.length; i++) {
            newElements[index + i] = c[i];
        }
        for (int i = index; i < size; i++) {
            newElements[i + c.length] = elements[i];
        }
        return new ImmutableArrayList(size + c.length, newElements);
    }

    public Object get(int index) {
        checkIndex(index);
        return elements[index];
    }

    public ImmutableList remove(int index) {
        checkIndex(index);
        Object[] newElements = new Object[size - 1];
        for (int i = 0; i < index; i++) {
            newElements[i] = elements[i];
        }
        for (int i = index + 1; i < size - 1; i++) {
            newElements[i] = elements[i + 1];
        }
        return new ImmutableArrayList(size - 1, newElements);
    }
    
    public ImmutableList set(int index, Object e) {
        checkIndex(index);
        Object[] newElements = Arrays.copyOf(elements, size);
        newElements[index] = e;
        return new ImmutableArrayList(size, newElements);
    }
    
    public int indexOf(Object e) {
        for (int i = 0; i < size; i++) {
            if (elements[i] == e) {
                return i;
            }
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
