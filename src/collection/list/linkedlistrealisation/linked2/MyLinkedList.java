package collection.list.linkedlistrealisation.linked2;

import java.util.Iterator;

public class MyLinkedList <E> implements Iterable <E> {

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    private static class Node <E> {
        E value;
        Node <E> next;

        Node (E value) {
            this.value = value;
        }
    }

    private Node <E> head;
    private int size =0;


}
