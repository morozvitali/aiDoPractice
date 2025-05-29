package patterns.iterator3.tree;

public class Node<T> {
    T value; //тут ініціються посилання, зараз воно пусе
    Node<T> left; // посилання на елемент зліва
    Node <T> right; // справа

    public Node (T value) {
        this.value = value; // тут зберігаються значення
    }
}
