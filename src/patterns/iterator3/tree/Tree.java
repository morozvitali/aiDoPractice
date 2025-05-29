package patterns.iterator3.tree;

import java.util.Iterator;
import java.util.Stack;

public class Tree<T> implements Iterable {
    private Node<T> root;

    public Tree(Node<T> root) {
        this.root = root;  // 1 створюємо дерево Трее з коренем рут
    }

    @Override
    public Iterator<T> iterator() {
        return new TreeIterator(root); // 2 створюємо метод ітератор
    }

    private class TreeIterator implements Iterator<T> {
        private Stack <Node<T>> stack = new Stack<>(); // використали клас стак
        // щоб мати посилання і обробляти їх

        public TreeIterator(Node<T> root) {
            pushLeft(root);
        }

        private void pushLeft(Node<T> node) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        @Override
        public T next() {
            Node<T> current = stack.pop();
            if (current.right != null) {
                pushLeft(current.right);
            }
            return current.value;
        }
    }
}

    class TestTreeIterator {
    public static void main(String[] args) {
        Node<Integer> root = new Node<>(5);
        root.left = new Node<>(3);
        root.right = new Node<>(7);
        root.left.left = new Node<>(2);
        root.left.right = new Node<>(4);
        root.right.left = new Node<>(6);
        root.right.right = new Node<>(8);

        Tree<Integer> tree = new Tree<>(root);

        for (Object value : tree) {
            System.out.print(value + " ");
        }
    }
}
