package Method_of_ArrayList;

import java.util.Arrays;

public class MyList<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;

    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public MyList(int capacity) {
        elements = new Object[capacity];
    }

    private void ensureCapa() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }

    public boolean add(E e) {
        if (size == elements.length) {
            ensureCapa();
        }
        elements[size++] = e;
        return true;
    }

    public void get() {
        for (int i = 0; i < size; i++) {
            System.out.println(elements[i]);
        }
    }

    public void add(int index, E element) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + index);
        }
        if (size == elements.length) {
            ensureCapa();
        }
        for (int i = size; i >= index; i--) {
            elements[i] = elements[i - 1];
        }

        elements[index] = element;
        size++;

//        for (int i = 0; i <= size; i++) {
//            if (i == index) {
//                elements[size] = elements[i];
//                elements[i] = element;
//            }
//        }
//        for (int i = index + 1; i < size; i++) {
//            E temp = (E) elements[i];
//            elements[i] = elements[size];
//            elements[size] = temp;
//        }
//        size++;
    }

    public E remove(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + index);
        }
        for (int i = index; i < size; i++) {
            elements[i] = elements[i + 1];
        }
        size--;
        return (E) elements;
    }

    public int size() {
        return size;
    }

    public E clone() {
        Object[] newElements = new Object[size];
        newElements = elements;
        return (E) newElements;
    }

    public boolean contains(E o) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(o)) {
                return true;
            }
        }
        return false;
    }

    public int indexOf(E o) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = elements[size];
        }
        size = 0;
    }

    public E get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + index);
        }
        for (int j = 0; j < size; j++) {
            if (j == index) {
                return (E) elements[j];
            }
        }
        return (E) elements[size];
    }

    public void ensureCapacity(int minCapacity) {
        elements = Arrays.copyOf(elements, minCapacity);
    }
}

