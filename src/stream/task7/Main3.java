package stream.task7;

import java.util.Arrays;

public class Main3 {

    public void filtering () {

        Arrays.stream(new String [] {"apple", "banana", "book", "car", "blue"})
                .filter(a->a.startsWith("b"))
                .forEach(System.out::println);
    }


    public void filtering2 () {

        Arrays.stream(new int [] {3, 10, 14, 9, 20, 25, 8})
                .filter(a-> a>10 && a%2 ==0)
                .forEach(System.out::print);
    }
}
