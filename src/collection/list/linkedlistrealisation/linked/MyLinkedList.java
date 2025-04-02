package collection.list.linkedlistrealisation.linked;

import java.util.Iterator;

public class MyLinkedList<E> implements MyList<E> {
    private Node<E> head;
    private int size;

    @Override
    public Iterator<E> iterator() {
        return new MyIterator();
    }

    private static class Node<E> {
        E data;
        Node<E> next;

        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public void add(E el) {
        Node newNode = new Node<E>(el, null);
        size++;
        if (head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }


    @Override
    public E get(int index) {

        if (size <= index) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int counter = 0;

        Node<E> curNode = head;
        while (index != counter) {
            curNode = curNode.next;
            counter++;
        }


        return curNode.data;
    }

    @Override
    public int mySize() {
        return size;
    }


    private class MyIterator implements Iterator <E> {
        private Node<E> currentValue = head;

        @Override
        public boolean hasNext() {
            return head != null && currentValue != null;
        }

        @Override
        public E next() {
            if (head == null) {
                return null;
            }

            E data = currentValue.data;
            currentValue = currentValue.next;
            return data;
        }
    }
}
