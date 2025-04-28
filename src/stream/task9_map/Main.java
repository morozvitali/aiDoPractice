package stream.task9_map;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        String[] words = {"java", "python", "go"};
        int[] numbers = {2, 3, 4};
        String[] words2 = {"apple", "banana", "kiwi"};

        main.myLength(words);
        main.mySqrt(numbers);
        main.myUpperCase(words2);
    }

    public void myLength (String [] array) {
        Arrays.stream(array).map(a->a.length()).forEach(System.out::println);
    }

    public void mySqrt (int [] array) {
        Arrays.stream(array).map(a->a*a).forEach(System.out::println);
    }

    public void myUpperCase (String [] array) {
        Arrays.stream(array).map(a -> a.toUpperCase()).forEach(System.out::println);
    }
}
