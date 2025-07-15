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

}
