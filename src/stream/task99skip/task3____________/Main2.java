package stream.task99skip.task3____________;

import java.util.Arrays;

public class Main2 {

    public String myReducer (String sentence) {
        String [] array = sentence.split(" ");
        return Arrays.stream(array)
                .reduce(array[0],(a,b) -> counter(a) > counter(b) ? a : b);
    }

    public int counter (String word) {
        return (int) word.toLowerCase()
                .chars()
                .filter(c->"aeiou".indexOf(c)>=0)
                .count();
    }
}
