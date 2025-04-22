package collection.list.linkedlistrealisation.linked2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList <E> implements Iterable <E> {

    @Override
    public Iterator<E> iterator() {
        return new MyIterator();  /// реалізували ітератор, для обходу колекції по for (E e : list)
    }

    /* -----------------M-Y-----I-T-E-R-A-T-O-R----------------- */

            private class MyIterator implements Iterator <E> { //  реалізуємо інтерфейс ітератор з логікою
            /// для hasNext, next, remove

                private Node <E> current = head; // вузол що ще не пройдено
                private Node <E> previous = null; // попередній вузол який був повернутий у next
                private Node <E> beforePrevious = null; // для реалізації remove (щоб після видалення додати всі посилання на попередній і до нього)
                private boolean canRemove = false; // прапорець яеий дозволяє чи забороняє remove (щоб не виклкикати remove двічі без next)

            public E get (int index) {
                checkIndex(index);
                Node <E> current = head;  // знов, створюмо місце де зберігаються посилання які оброблятимо
                for (int i = 0; i<index; i++) {
                    current = current.next; // перебираємо значення і отримуємо посилання і значення на наступний нод, поки
                    // і < index і повернемо посилання на нод
                }
                return current.value;
            }

                private void checkIndex (int index) {
                    if (index < 0 || index >= size) {  // перевіряємо індекс, більше нуля і менше розміру
                        throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
                    }

                }

                //------------M-E-T-H-O-D----A-D-D---B-Y----I-N-D-E-X-----------//

                public void add (int index, E value) {
                    checkIndex (index);

                    Node <E> newNode = new Node<>(value);

                    if (index == 0) {  // вставимо в початок
                        newNode.next = head;    // head == null взагалі то, тому newNode.next = null
                                head = newNode; // це наш новий нод
                    }

                    else {
                        // Знаходимо вузол перед index
                        Node<E> current = head;
                        for (int i = 0; i < index - 1; i++) {
                            current = current.next;
                        }
                        // Вставляємо новий вузол після current
                        newNode.next = current.next;
                        current.next = newNode;
                    }
                    size++;
                }



                @Override
                public E next() {
                    if (!hasNext()) throw new NoSuchElementException(); // кидаємо помилку в тому разі якщо є спроба
                    // звернутися до наступного елементу без перевірки, наприклад while (it.hasNext()) {it.next} //
                    // лист може мати легальні null тому кожного разу перевіряємо hasNext() перед next():

                    E value = current.value; // отримуємо посилання на наступне значення - ми його повернемо пізніше у return

                    beforePrevious = previous; // зсуваємо значення
                    previous = current;
                    current = current.next;
                    canRemove = true;

                    return value;   // повертає посилання на значення наступного ноду який отримали
                }

                @Override
                public boolean hasNext() {
                    return current != null; // якщо поточний елемент отримав порожнє посилання, тобто current повернув null
                }

                /* --------------R-E-M-O-V-E------------- */

                @Override
                public void remove() {

                    if (!canRemove) {
                        throw  new IllegalStateException (" next must be called before remove()"); // захист щоб не
                        // викликати метод remove() на тому самому елементі кілька разів
                    }

                    if (previous == head) {// Видаляємо перший елемент
                    head = current; // оновлюємо head
                    } else {
                        // Перестрибуємо вузол, який треба видалити
                        beforePrevious.next = current;
                    }

                    // післ видалення previous уже не існує в списку
                    previous = null;
                    canRemove = false; // не можна викликати remove двічі підряд
                    size--; // --


                }
            }

    /* ----------------M-Y--------N-O-D-E----------------- */

    private static class Node <E> {
        E value;
        Node <E> next;

        Node (E value) {
            this.value = value;
        }
    }

    private Node <E> head;
    private int size = 0;

/* ----------------A-D-D--------M-E-T-H-O-D----------------- */

    public void add (E value) {

        Node <E> newNode = new Node <> (value); //додали новий нод, саме зараз він має значення яке передаємо [[value E]] і next = null
        if (head == null) {   // перевірка, чи не пустий ліст
            head = newNode;     //якщо пустий то це перший елемент і нод має те саме значення  [[value E]] і next = null
        } else { // інакше ліст не порожній
            Node <E> current = head;    // Створюємо тимчасову змінну яка нам допомогатиме перебирати вузли і шукати саме потрібний
            while (current.next != null) {  // а для цього перебираємо всі вузли до самого останнього у котрого значення next == null
                current = current.next; // за цім шматочком коду ми знаходимо наступний обьєкт, він працює як i++
                // і таким чином ми отримуємо посилання на наступний нод
            }
            current.next = newNode; // це самий останній нод в якому next == null і цьому ноду ми створюємо посилання на наш newNode
        }
            size++; // збільшимо кількість елементів після операції додавання
    }

    public E removeFirst() {
        if (head == null) {  // якщо лист пустий то видаляти перший елемент неможна
            throw new NoSuchElementException("Список порожній"); // повернемо помилку
        }

        E value = head.value; // зберігаємо посилання на елемент який будемо видаляти
        head = head.next; // значенню голови (першого елемента) присвоюємо значенню яке у нього у next
        size--; // якщо все добре зменшуємо лист
        return value; // повертаємо те що видалили (посилання на елемент який тепер не в листі)
    }

    public void addFirst (E value) {
        Node <E> newNode = new Node <> (value); // створили нод зі значенням value
        newNode.next = head;    // додаємо до нашого ноду посилання на перший нод який зараз називається head
        head = newNode;     // посилання на head перекидаємо з першого елемента який був на наш створений нод
        size++; // ++
    }

    public int size () {
        return size;
    }



}
