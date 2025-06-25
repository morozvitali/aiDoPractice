package stream.task99skip.task3____________;

import java.util.Arrays;
import java.util.List;

public class Main5 {
    public List<String> myFiltering () {
        String sentence = "Every orange is an amazing object";
        String [] array = sentence.split(" ");
        return Arrays.stream(array).map(a->a.toLowerCase())
                .filter(s->"aeiou".indexOf(s.charAt(0))>=0)
                .toList();
    }

    public Long myFiltering2 () {
        String sentence = "Programming in Java is so enjoyable and educational";
        String [] array= sentence.split(" ");
        return Arrays.stream(array).filter(a->counter(a)>2).count();
    }

    public Long counter (String string) {
        return string.chars().filter(c->"aeiou".indexOf(c) >=0).count();
    }

    public void myFiltering3 () {
        String sentence = "Programming in Java is so enjoyable and educational";
        String[] array = sentence.split(" ");
        Arrays.stream(array)
        .map(String::toUpperCase)
                .filter(a->a.length()>=3 && a.length() <=5)
                .forEach(System.out::println);
    }
}
