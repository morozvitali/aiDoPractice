package patterns.iterator3.list;

import java.util.Iterator;

public class MyList<T> implements Iterable<T> {
    private T[] items; // масив з елементами
    private int size = 0; // розмір масиву

    public MyList(int capacity) {
        items = (T[]) new Object[capacity];  // конструктор який змінній ітемс
        // присвоює масив з кількістью
    }

    public void add(T item) {
        if (size == items.length) {
            throw new RuntimeException("List is full");
        }
        items[size++] = item; //
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }

    ///             реалізація ітератору                ///
    private class MyIterator implements Iterator<T> {
        private int index = 0;
        private boolean canRemove = false;

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public T next() {
            canRemove = true;
            return items[index++];
        }

        @Override
        public void remove() {
            if (!canRemove) {
                throw new IllegalStateException("Remove called without next()");
            }
            for (int i = index - 1; i < size - 1; i++) {
                items[i] = items[i + 1];
            }
            items[--size] = null;
            index--;
            canRemove = false;
        }
    }
}



















