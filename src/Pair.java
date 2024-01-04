public class Pair<K,V> {
    private final K key;
    public V value;

    Pair(K k, V v) {
        key = k;
        value = v;
    }

    public K getKey() {
        return key;
    }
}
