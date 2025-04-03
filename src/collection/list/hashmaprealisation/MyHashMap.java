package collection.list.hashmaprealisation;

import java.util.LinkedList;

public class MyHashMap<K, V> {

    private static class Entry<K, V> {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private static final int INITIAL_CAPACITY = 16;
    private LinkedList<Entry<K, V>>[] buckets;

    public MyHashMap() {
        buckets = new LinkedList[INITIAL_CAPACITY];
    }

    private int getBucketIndex(K key) {
        return Math.abs(key.hashCode()) % buckets.length;
    }

    public void put(K key, V value) {
        /*
        Обчислює індекс масиву.
        Перевіряє, чи ключ вже існує.
        Якщо так – оновлює значення.
        Якщо ні – додає нову пару ключ-значення.
         */

        int bucketIndex = getBucketIndex(key);

        if (buckets[bucketIndex] == null) {
            buckets[bucketIndex] = new LinkedList<>();
        }

        for (Entry<K, V> entry : buckets[bucketIndex]) {
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
        }

        // додаємо новий елемент
        buckets[bucketIndex].add((new Entry<>(key, value)));
    }

    // отримання значення за ключем
    public V get (K key) {

/*
Обчислює індекс масиву.
Повертає значення за ключем,
якщо він є, інакше – null.
 */

        int bucketIndex = getBucketIndex(key);
        LinkedList<Entry<K,V>> bucket = buckets[bucketIndex];

        if(bucket == null) {
            return null;
        }

        for (Entry <K,V> entry : bucket) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null;
    }


    // отримання значення за ключем
    public boolean remove(K key) {

        /*  remove
Обчислює індекс масиву.
Видаляє пару ключ-значення,
якщо вона є, і повертає true.
Якщо немає – повертає false.
 */

        int bucketIndex = getBucketIndex(key);
        LinkedList<Entry<K, V>> bucket = buckets[bucketIndex];

        if (bucket == null) return false;

        for (Entry<K, V> entry : bucket) {

            if (entry.key.equals(key)) {
                bucket.remove(entry);
                return true;
            }
        }
        return false;
    }
}



