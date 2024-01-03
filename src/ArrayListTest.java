import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayListTest {
    @Test
    public void increasesCapacityFromDefault() {
        ArrayList<Integer> list = new ArrayList<>();

        assertTrue(list.isEmpty());
        list.add(1);
        assertFalse(list.isEmpty());

        list.add(2);
        list.add(3);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);
        list.add(11);

        assertEquals(4, (int) list.get(4));
        assertEquals(2, (int) list.get(1));
        assertEquals(11, (int) list.get(11));
        assertEquals(12, list.size());
        assertFalse(list.contains(99));
        assertTrue(list.contains(7));
    }

    @Test
    public void increasesCapacityFromInitial() {
        ArrayList<Integer> list = new ArrayList<>(0);

        assertTrue(list.isEmpty());
        list.add(1);
        assertFalse(list.isEmpty());

        assertEquals(1, list.get(0));
        assertEquals(1, list.size());
        assertFalse(list.contains(57));
        assertTrue(list.contains(1));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void errorsOnNegativeInitialCapacity() {
        new ArrayList<>(-1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void errorsOnNegativeOutOfBoundsGet() {
        ArrayList<Integer> list = new ArrayList<>();
        list.get(-4);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void errorsOnPositiveOutOfBoundsGet() {
        ArrayList<Integer> list = new ArrayList<>();
        list.get(100);
    }

    @Test
    public void insertsAtIndexWithoutIncreasingCapacity() {
        ArrayList<Integer> list = new ArrayList<>();

        assertTrue(list.isEmpty());
        list.add(1);
        assertFalse(list.isEmpty());

        list.add(2);
        list.add(3);
        list.add(1, 99);

        assertEquals(1, (int) list.get(0));
        assertEquals(99, (int) list.get(1));
        assertEquals(2, (int) list.get(2));
        assertEquals(4, list.size());
        assertFalse(list.contains(42));
        assertTrue(list.contains(99));
    }

    @Test
    public void insertsAtIndexWithIncreasingCapacity() {
        ArrayList<Integer> list = new ArrayList<>(1);

        assertTrue(list.isEmpty());
        list.add(1);
        assertFalse(list.isEmpty());

        list.add(2);
        list.add(3);
        list.add(1, 99);

        assertEquals(1, (int) list.get(0));
        assertEquals(99, (int) list.get(1));
        assertEquals(2, (int) list.get(2));
        assertEquals(4, list.size());
        assertFalse(list.contains(84));
        assertTrue(list.contains(3));
    }
}
