package stream.task9_map;

import java.util.Arrays;

public class Main3 {


    public void myMap1 () {
        Arrays.stream(new String [] {"java", "python", "go"})
                .map(a->a.length())
                .forEach(System.out::println);
    }

    public void myMap2 () {
        Arrays.stream(new int [] {2,3,4,5})
                .map(a->a*a)
                .forEach(System.out::println);
    }

    public void myMap3 () {
        Arrays.stream(new String [] {"apple", "banana", "kiwi"})
                .map(a->a.toUpperCase())
                .forEach(System.out::println);
    }
}
