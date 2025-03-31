package stream.Task7;

import java.util.Arrays;

public class Main2 {
    public void myFilter () {
        String[] words = {"apple", "banana", "book", "car", "blue"};
        Arrays.stream(words).filter(a->a.charAt(0)=='b').forEach(System.out::println);
    }

    public void myFilter2 () {
        int[] numbers = {3, 10, 14, 9, 20, 25, 8};
        Arrays.stream(numbers).filter(a -> a % 2 == 0 && a > 10).forEach(System.out::println);
    }

    public static void main(String[] args) {
        Main2 main2 = new Main2();
        main2.myFilter();
        main2.myFilter2();
    }
}
