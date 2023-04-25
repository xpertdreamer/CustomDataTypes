package customhashmap;

import java.util.Objects;

public class CustomHashMap<K, V> {
    private int CAPACITY = 10;
    private MapBucket[] bucket;
    private int size = 0;

    public CustomHashMap() {
        this.bucket = new MapBucket[CAPACITY];
    }

    private int getHash(K key) {
        return (key.hashCode() & 0xfffffff) % CAPACITY;
    }

    private KeyValueEntry getEntry(K key) {
        int hash = getHash(key);
        for (int i = 0; i < bucket[hash].getEntries().size(); i++) {
            KeyValueEntry keyValueEntry = bucket[hash].getEntries().get(i);
            if (keyValueEntry.getKey().equals(key)) {
                return keyValueEntry;
            }
        }
        return null;
    }

    public boolean containsKey(K key) {
        int hash = getHash(key);
        return !(Objects.isNull(bucket[hash]) || Objects.isNull(getEntry(key)));
    }

    public V put(K key, V value) {
        if (containsKey(key)) {
            KeyValueEntry entry = getEntry(key);
            V temp = (V)entry.getValue();
            entry.setValue(value);
            return temp;
        } else {
            int hash = getHash(key);
            if (bucket[hash] == null) {
                bucket[hash] = new MapBucket();
            }
            bucket[hash].addEntry(new KeyValueEntry<>(key, value));
            size++;
            return null;
        }
    }

    public V get(K key) {
        return containsKey(key) ? (V) getEntry(key).getValue() : null;
    }

    public void remove(K key) {
        if (containsKey(key)) {
            int hash = getHash(key);
            bucket[hash].removeEntry(getEntry(key));
            size--;
        }
    }

    public int size() {
        return size;
    }
}
