import java.lang.module.FindException;
import java.util.LinkedList;

public class MyHashTable<K, V> {
    private static final int DEFAULT_TABLE_CAPACITY = 10;
    @SuppressWarnings("unchecked")
    LinkedList<Pair<K, V>>[] table = new LinkedList[DEFAULT_TABLE_CAPACITY];

    MyHashTable() {
        for (int i = 0; i < table.length; i++)
            table[i] = new LinkedList<>();
    }

    public void add(Pair<K, V> pair) {
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
        for (Pair<K, V> pair : table[i])
            if (pair.getKey() == key)
                return pair.value;

        throw new FindException();
    }
}

