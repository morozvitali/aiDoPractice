package collection.list.linkedlistrealisation.linked;

import java.util.Iterator;

public class MyLinkedList <E>  implements MyList<E> {
        private Node <E> head;
    private static class Node <E> {
        E data;
        Node<E> next;

        public Node (E data, Node <E> next) {
            this.data = data;
            this.next = next;
        }
    }

/*
 TODO
 realisation of methods
 */


    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public boolean add(E el) {
        Node newNode = new Node <E> (el,null);

        if (head ==null) {
            head = newNode;
        }



        return true;
    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public int mySize() {
        return 0;
    }

    @Override
    public void add(int index, Object el) {




    }

    @Override
    public void remove(int index) {

    }

    @Override
    public Iterator iterator() {
        return null;
    }
}
