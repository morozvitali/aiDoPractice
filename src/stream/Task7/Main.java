package stream.Task7;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        String[] words = {"apple", "banana", "book", "car", "blue"};
        Main main = new Main();
        main.printer(words);
    }

    public void printer (String [] array) {
        Arrays.stream(array)
                .filter(a -> a
                .toLowerCase()
                .charAt(0) == 'b').forEach(System.out::println);
    }
}
