package stream.task11__mapping_remake___;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Main2 {
    public void practice1 () {
        Arrays.stream("Hey fellow warriors".split(" ")).map(w-> w.length() < 5 ? w : new StringBuilder (w).reverse().toString()).collect(Collectors.joining(" "));
    }

    public void practice2 () {
        Arrays.stream("Java is amazing language for backend".split(" ")).map(a->a.length() < 5 ? a : "[...]").collect(Collectors.joining());
    }

    public void practice3 () {
        String [] str = "I love my keyboard very much".split(" ");

        String temp = str[0];
        str[0] = str[str.length -1];
        str[str.length -1] = temp;
        String.join(" ", str);
    }

    public void practice4 () {
        Arrays.stream("Hello world".split(" ")).map(w-> "(" + w + ")").collect(Collectors.joining(" "));
    }

    public void practice5 () {
        String response = Arrays.stream("madam speaks civic racecar now".split(" ")).filter(value -> new StringBuilder(value).reverse().toString().equals(value)).collect(Collectors.joining(" "));
    }



}
