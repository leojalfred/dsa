import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class MyListTest {
    @Test(expected = IndexOutOfBoundsException.class)
    public void testMyList() {
        MyList<Integer> list = new MyList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(3);
        list.add(4);
        assertEquals(4, (int) list.get(4));
        assertEquals(2, (int) list.get(1));
        assertEquals(3, (int) list.get(2));

        list.get(6);
    }


    @Test(expected = IndexOutOfBoundsException.class)
    public void testNegative() {
        MyList<Integer> list = new MyList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(3);
        list.add(4);
        list.get(-1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testList() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(3);
        list.add(4);
        assertEquals(4, (int) list.get(4));
        assertEquals(2, (int) list.get(1));
        assertEquals(3, (int) list.get(2));

        list.get(6);
    }
}
