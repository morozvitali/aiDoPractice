package stream.task7_anymatch;

import java.util.Arrays;

public class Main4 {
    public void myFilter () {
        String[] words = {"apple", "banana", "book", "car", "blue"};
        Arrays.stream(words).filter(w-> w.charAt(0) == 'b').forEach(System.out::println);
    }

    public static void main(String[] args) {
        Main4 m = new Main4();
        m.myFilter();
        m.myFilter2();
    }

    public void myFilter2 () {
        int[] numbers = {3, 10, 14, 9, 20, 25, 8};
        Arrays.stream(numbers).filter(a->a>=20).forEach(System.out::println);
    }
}
