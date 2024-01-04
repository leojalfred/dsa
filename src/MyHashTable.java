import java.lang.module.FindException;
import java.util.LinkedList;

public class MyHashTable<K, V> {
    private static final int DEFAULT_TABLE_CAPACITY = 10;
    LinkedList<Pair<K, V>>[] table;

    @SuppressWarnings("unchecked")
    MyHashTable() {
        table = new LinkedList[DEFAULT_TABLE_CAPACITY];
        init();
    }

    @SuppressWarnings("unchecked")
    MyHashTable(int capacity) {
        table = new LinkedList[capacity];
        init();
    }

    private void init() {
        for (int i = 0; i < table.length; i++)
            table[i] = new LinkedList<>();
    }

    public void put(Pair<K, V> pair) {
        int i = pair.getKey().hashCode() % table.length;
        for (Pair<K, V> p : table[i]) {
            if (p.getKey() == pair.getKey()) {
                p.value = pair.value;
                return;
            }
        }

        table[i].add(pair);
    }

    public V get(K key) {
        int i = key.hashCode() % table.length;
        for (Pair<K, V> pair : table[i]) {
            if (pair.getKey() == key) {
                System.out.println("Index: " + i + ", Size: " + (table[i].size()));
                return pair.value;
            }
        }

        throw new FindException();
    }
}

