import java.util.Arrays;

public class MyList<E> {
    public static final int DEFAULT_CAPACITY = 3;
    private int size = 0;
    private Object[] elements;

    MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public void add(E e) {
        if (size == elements.length)
            elements = Arrays.copyOf(elements, elements.length * 2);

        elements[size] = e;
        size++;
    }

    @SuppressWarnings("unchecked")
    public E get(int i) {
        if (i < 0 || i >= size)
            throw new IndexOutOfBoundsException("Index: " + i + " Size: " + size);

        return (E) elements[i];
    }
}
