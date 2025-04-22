package collection.list.linkedlistrealisation.linked2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList <E> implements Iterable <E> {

    @Override
    public Iterator<E> iterator() {
        return null;
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




}
