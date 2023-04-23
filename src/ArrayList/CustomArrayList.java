package ArrayList;

import java.util.*;

public class CustomArrayList<E> extends AbstractList<E> {
    private int size = 0;
    private Object elements[];
    private static final int DEFAULT_CAPACITY = 10;

    CustomArrayList(){
        elements = new Object[DEFAULT_CAPACITY];
    }

    CustomArrayList(int capacity){
        elements = new Object[capacity];
    }

    @Override
    public E get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index " + index + "out of bounds for length " + size);
        }
        return (E)elements[index];
    }

    @Override
    public int size() {
        return size;
    }

    public void add(int index, E element){
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for length " + size);
        }
        ensureCapacity();
        for(int i = size-1; i >= index; i--){
            elements[i+1] = elements[i];
        }
        elements[index] = element;
        size++;
    }

    private void ensureCapacity(){
        int newSize = elements.length + 1;
        elements = Arrays.copyOf(elements, newSize);
    }

    public E delete(int index){
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index " + index + "out of bounds for length " + size);
        }
        Object item = elements[index];
        for(int i = index; i < size-1; i++){
            elements[i] = elements[i+1];
        }
        size--;
        return (E)item;
    }
}
