package stream.task11__mapping;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Main1 {
    public String practice1 () {
        return Arrays.stream("Hey fellow warriors".split(" "))
                .map(a->a.length() < 5 ? a : new StringBuilder(a).reverse().toString())
                .collect(Collectors.joining(" "));
    }

    public String practice2 () {
        return Arrays
                .stream("Java is amazing language for backend"
                        .split(" "))
                .map(a->a.length() <5 ? a : "[...]")
                .collect(Collectors
                        .joining(" "));
    }

    public String practice3 () {
        String [] str = "I love my keyboard very much".split(" ");
        String temp = str[0];
        str[0] = str[str.length-1];
        str[str.length-1]=temp;
        return String.join(" ", str);
    }

    public String ractice4 () {
        return Arrays.stream("Hello world".split(" ")).map(a->"(" + a + ")").collect(Collectors.joining(" "));
    }

    public String practice5 () {
        return Arrays
                .stream("madam speaks civic racecar now"
                        .split(" "))
                .filter(a-> a.equals(new StringBuilder(a)
                        .reverse().toString()))
                .collect(Collectors
                        .joining(" "));
    }
}
