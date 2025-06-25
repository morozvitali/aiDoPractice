package stream.task99skip.task9_______;

import java.util.Arrays;

public class Main2 {

    public static void main(String[] args) {
        Main2 main2 = new Main2();
        main2.myMap1();
        main2.myMap2();
        main2.myMap3();
    }

    public void myMap1 () {
        String[] words = {"java", "python", "go"};
        Arrays.stream(words).map(a->a.length()).forEach(System.out::println);
    }

    public void myMap2 () {
        int[] numbers = {2, 3, 4};
        Arrays.stream(numbers).map(a->a*a).forEach(System.out::println);
    }

    public void myMap3 () {
        String[] words = {"apple", "banana", "kiwi"};
        Arrays.stream(words).map(a->a.toUpperCase()).forEach(System.out::println);
    }
}
