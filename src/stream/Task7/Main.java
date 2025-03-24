package stream.Task7;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        String[] words = {"apple", "banana", "book", "car", "blue"};
        int[] numbers = {3, 10, 14, 9, 20, 25, 8};
        Main main = new Main();
        main.wordPrinter(words);
        main.numberPrinter(numbers);
    }

    public void wordPrinter (String [] array) {
        Arrays.stream(array)
                .filter(a -> a
                .toLowerCase()
                .charAt(0) == 'b').forEach(System.out::println);
    }
    
    public void numberPrinter (int [] array) {
        Arrays.stream(array)
                .filter(a-> a % 2 == 0 && a > 10)
                .forEach(System.out::println);
    }
}
