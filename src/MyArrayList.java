import java.lang.module.FindException;
import java.util.Arrays;

public class MyArrayList<E> {
    static final int DEFAULT_CAPACITY = 10;
    private int size = 0;
    private Object[] elements;

    MyArrayList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    MyArrayList(int initialCapacity) {
        if (initialCapacity < 0) throw new IndexOutOfBoundsException();
        elements = new Object[initialCapacity];
    }

    public void add(E e) {
        if (size == elements.length) {
            int newCapacity = elements.length == 0 ? 1 : 2 * elements.length;
            System.out.println("Increased array capacity from " + elements.length + " to " + newCapacity);
            elements = Arrays.copyOf(elements, newCapacity);
        }

        elements[size] = e;
        size++;
    }

    public void add(int index, E e) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();

        if (size < elements.length) {
            for (int i = size - 1; i >= index; i--)
                elements[i + 1] = elements[i];

            elements[index] = e;
            size++;

            return;
        }

        int newCapacity = elements.length == 0 ? 1 : 2 * elements.length;
        Object[] newElements = new Object[newCapacity];
        System.arraycopy(elements, 0, newElements, 0, index);
        newElements[index] = e;
        System.arraycopy(elements, index, newElements, index + 1, elements.length - index);
        System.out.println("Increased array capacity from " + elements.length + " to " + newCapacity);

        elements = newElements;
        size++;
    }

    public Object get(int i) {
        if (i < 0 || i >= size) throw new IndexOutOfBoundsException();

        return elements[i];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(E e) {
        for (int i = 0; i < size; i++)
            if (elements[i] == e) return true;

        return false;
    }

    public int find(E e) {
        for (int i = 0; i < size; i++)
            if (elements[i] == e) return i;

        throw new FindException();
    }

    public void remove(E e) {
        boolean found = false;
        for (int i = 0; i < size; i++) {
            if (!found) {
                if (elements[i] == e) found = true;
                continue;
            }

            elements[i - 1] = elements[i];
        }

        if (found) size--;
        else throw new FindException();
    }
}