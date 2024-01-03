import java.util.Arrays;

public class ArrayList<E> {
    static final int DEFAULT_CAPACITY = 10;
    private int size = 0;
    private Object[] elements;

    ArrayList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    ArrayList(int initialCapacity) {
        if (initialCapacity < 0) throw new IndexOutOfBoundsException();
        elements = new Object[initialCapacity];
    }

    public void add(Object e) {
        if (size == elements.length) {
            int newCapacity = elements.length == 0 ? 1 : 2 * elements.length;
            System.out.println("Increased array capacity from " + elements.length + " to " + newCapacity);
            elements = Arrays.copyOf(elements, newCapacity);
        }

        elements[size] = e;
        size++;
    }

    public void add(int index, Object e) {
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
        System.out.println("Doubled array capacity from " + elements.length + " to " + newCapacity);

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

    public boolean contains(E x) {
        for (Object e : elements)
            if (e == x) return true;

        return false;
    }
}