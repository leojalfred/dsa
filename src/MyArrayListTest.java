import org.junit.Test;

import java.lang.module.FindException;

import static org.junit.Assert.*;

public class MyArrayListTest {
    @Test
    public void canGetAndSetFromDefaultCapacity() {
        MyArrayList<Integer> list = new MyArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);

        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(3, list.get(2));
    }

    @Test
    public void canGetAndSetIncreasingFromDefaultCapacity() {
        MyArrayList<Integer> list = new MyArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);
        list.add(11);

        assertEquals(1, list.get(0));
        assertEquals(5, list.get(4));
        assertEquals(11, list.get(10));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void errorsOnNegativeOutOfBoundsGet() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.get(-4);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void errorsOnPositiveOutOfBoundsGet() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.get(100);
    }

    @Test
    public void canGetAndSetFromInitialCapacity() {
        MyArrayList<Integer> list = new MyArrayList<>(5);

        list.add(1);
        list.add(2);
        list.add(3);

        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(3, list.get(2));
    }

    @Test
    public void canGetAndSetIncreasingFromInitialCapacity() {
        MyArrayList<Integer> list = new MyArrayList<>(0);

        list.add(1);
        list.add(2);
        list.add(3);

        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(3, list.get(2));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void errorsOnNegativeInitialCapacity() {
        new MyArrayList<>(-1);
    }

    @Test
    public void sizeReturnsExpectedValue() {
        MyArrayList<Integer> list = new MyArrayList<>();

        assertEquals(0, list.size());

        list.add(1);
        assertEquals(1, list.size());

        list.add(2);
        assertEquals(2, list.size());

        list.add(3);
        assertEquals(3, list.size());
    }

    @Test
    public void isEmptyIsTrueBeforeAdding() {
        MyArrayList<Integer> list = new MyArrayList<>();
        assertTrue(list.isEmpty());
    }

    @Test
    public void isEmptyIsFalseAfterAdding() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(1);

        assertFalse(list.isEmpty());
    }

    @Test
    public void containsExpectedValue() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(123);

        assertTrue(list.contains(123));
    }

    @Test
    public void doesNotContainUnexpectedValue() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(123);

        assertFalse(list.contains(321));
    }

    @Test
    public void insertsAtIndexWithoutIncreasingCapacity() {
        MyArrayList<Integer> list = new MyArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(1, 99);

        assertEquals(1, list.get(0));
        assertEquals(99, list.get(1));
        assertEquals(2, list.get(2));
        assertEquals(4, list.size());
        assertFalse(list.contains(42));
        assertTrue(list.contains(99));
    }

    @Test
    public void insertsAtIndexIncreasingCapacity() {
        MyArrayList<Integer> list = new MyArrayList<>(0);

        list.add(1);
        list.add(2);
        list.add(1, 99);
        list.add(3);

        assertEquals(1, list.get(0));
        assertEquals(99, list.get(1));
        assertEquals(2, list.get(2));
        assertEquals(4, list.size());
        assertFalse(list.contains(84));
        assertTrue(list.contains(3));
    }

    @Test
    public void findsElement() {
        MyArrayList<Integer> list = new MyArrayList<>(1);

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(1, 99);

        assertEquals(1, list.find(99));
    }

    @Test(expected = FindException.class)
    public void errorsUponNotFindingElement() {
        MyArrayList<Integer> list = new MyArrayList<>(1);
        list.find(345);
    }

    @Test
    public void removesFoundElement() {
        MyArrayList<Integer> list = new MyArrayList<>();

        list.add(837);
        list.add(9);
        list.add(-826347);
        list.add(9967);
        list.add(-86);

        list.remove(9);

        assertEquals(837, list.get(0));
        assertEquals(-826347, list.get(1));
        assertEquals(9967, list.get(2));
        assertEquals(4, list.size());
        assertFalse(list.contains(9));
    }

    @Test(expected = FindException.class)
    public void errorsUponNotFindingElementToRemove() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.remove(8237);
    }
}
