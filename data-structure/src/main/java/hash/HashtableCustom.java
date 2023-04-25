package hash;

import java.util.Map;
import java.util.Objects;

/**
 * Реализация хеш-таблицы, использующую метод цепочек при коллизиях
 *
 * @param <K> ключ
 * @param <V> значение
 */
public class HashtableCustom<K, V> {

    private final static int DEFAULT_CAPASITY = 16;
    private final static float LOAD_FACTOR = 0.75f;
    private int threshold = DEFAULT_CAPASITY;
    private Entry<K, V>[] buckets;
    private int size;

    public boolean contains(Object value) {
        if (value == null) {
            throw new NullPointerException();
        }
        for (int i = buckets.length - 1; i >= 0; i--) {
            Entry<K, V> entry = buckets[i];
            while (entry != null) {
                if (entry.value.equals(value)) {
                    return true;
                }
                entry = entry.next;
            }
        }
        return false;
    }

    public boolean containsKey(Object key) {
        int index = hash(key);
        Entry<K, V> entry = buckets[index];
        while (entry != null) {
            if (entry.key.equals(key)) {
                return true;
            }
            entry = entry.next;
        }
        return false;
    }

    public V get(Object key) {
        int index = hash(key);
        Entry<K, V> entry = buckets[index];
        while (entry != null) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
            entry = entry.next;
        }
        return null;
    }

    public V put(K key, V value) {
        int index = hash(key);
        Entry<K, V> entry = buckets[index];

        if (value == null) {
            throw new NullPointerException();
        }

        while (entry != null) {
            if (entry.key.equals(key)) {
                V newValue = entry.value;
                entry.value = value;
                return newValue;
            } else {
                entry = entry.next;
            }
        }

        if (++size > threshold) {
            rehash();
            index = hash(key);
        }

        entry = new Entry<K, V>(index, key, value);
        entry.next = buckets[index];
        buckets[index] = entry;

        return null;
    }

    public V remove(Object key) {
        int index = hash(key);

        Entry<K, V> entry = buckets[index];
        Entry<K, V> last = null;

        while (entry != null) {
            if (entry.key.equals(key)) {
                if (last == null) {
                    buckets[index] = entry.next;
                } else {
                    last.next = entry.next;
                }
                size--;
                return entry.value;
            }
            last = entry;
            entry = entry.next;
        }
        return null;
    }

    private void rehash() {
        Entry<K, V>[] oldBuckets = buckets;

        int newCapacity = (buckets.length * 2) + 1;
        threshold = (int) (newCapacity * LOAD_FACTOR);
        buckets = (Entry<K, V>[]) new Entry[newCapacity];

        for (int i = oldBuckets.length - 1; i >= 0; i--) {
            Entry<K, V> entry = oldBuckets[i];
            while (entry != null) {
                int index = hash(entry.key);
                Entry<K, V> dest = buckets[index];

                if (dest != null) {
                    Entry next = dest.next;
                    while (next != null) {
                        dest = next;
                        next = dest.next;
                    }
                    dest.next = entry;
                } else {
                    buckets[index] = entry;
                }
                Entry next = entry.next;
                entry.next = null;
                entry = next;
            }
        }
    }

    private int hash(Object key) {
        int hash = (key.hashCode() & Integer.MAX_VALUE) % buckets.length;
        return hash < 0 ? -hash : hash;
    }

    private static class Entry<K, V> implements Map.Entry<K, V> {
        final int hash;
        final K key;
        V value;
        HashtableCustom.Entry<K, V> next;

        protected Entry(int hash, K key, V value, HashtableCustom.Entry<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        protected Entry(int hash, K key, V value) {
            this.hash = hash;
            this.key = key;
            this.value = value;
        }

        protected Object clone() {
            return new HashtableCustom.Entry<>(hash, key, value,
                    (next == null ? null : (HashtableCustom.Entry<K, V>) next.clone()));
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public V setValue(V value) {
            if (value == null)
                throw new NullPointerException();

            V oldValue = this.value;
            this.value = value;
            return oldValue;
        }

        public boolean equals(Object o) {
            if (!(o instanceof Map.Entry<?, ?> e))
                return false;

            return (key == null ? e.getKey() == null : key.equals(e.getKey())) &&
                    (value == null ? e.getValue() == null : value.equals(e.getValue()));
        }

        public int hashCode() {
            return hash ^ Objects.hashCode(value);
        }

        public String toString() {
            return key.toString() + "=" + value.toString();
        }
    }

}
