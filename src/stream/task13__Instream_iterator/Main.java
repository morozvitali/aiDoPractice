package stream.task13__Instream_iterator;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        int[] numbers = {2, 8, 15, 21, 4, 9};
        System.out.println(main.maxValue(numbers));
    }

    public int maxValue (int [] array) {
        return Arrays.stream(array)
                .filter(a -> a%2 != 0)
                .reduce((a,b)-> a >= b ? a : b)
                .orElse(-1);
    }
}
