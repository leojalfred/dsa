import org.junit.Test;

import java.lang.module.FindException;

import static org.junit.Assert.assertEquals;

public class MyHashTableTest {
    @Test
    public void canSetAndGet() {
        MyHashTable<String, Integer> hashTable = new MyHashTable<>();
        hashTable.add(new Pair<>("cat", 999));
        hashTable.add(new Pair<>("dog", 123));
        hashTable.add(new Pair<>("bird", 765));

        assertEquals(Integer.valueOf(765), hashTable.get("bird"));
        assertEquals(Integer.valueOf(123), hashTable.get("dog"));
        assertEquals(Integer.valueOf(999), hashTable.get("cat"));
    }

    @Test
    public void settingExistingKeyUpdateValue() {
        MyHashTable<String, Integer> hashTable = new MyHashTable<>();
        hashTable.add(new Pair<>("cat", 999));
        hashTable.add(new Pair<>("cat", 1000));

        assertEquals(Integer.valueOf(1000), hashTable.get("cat"));
    }

    @Test(expected = FindException.class)
    public void errorsOnGettingNonexistentKey() {
        MyHashTable<String, Integer> hashTable = new MyHashTable<>();
        hashTable.get("cat");
    }

    @Test
    public void canSetAndGetWithCollisions() {
        MyHashTable<String, Integer> hashTable = new MyHashTable<>(1);
        hashTable.add(new Pair<>("cat", 999));
        hashTable.add(new Pair<>("dog", 123));
        hashTable.add(new Pair<>("bird", 765));

        assertEquals(Integer.valueOf(765), hashTable.get("bird"));
        assertEquals(Integer.valueOf(123), hashTable.get("dog"));
        assertEquals(Integer.valueOf(999), hashTable.get("cat"));
    }
}
