package stream.task1__sorting__to_bucket;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main2 {

    public static List<Integer> myMethod (int [] array) {
        return Arrays.stream(array)
                .filter(a->a%2==0)
                .map(a->a*a)
                .boxed()
                .sorted((a,b) -> b-a)
                .collect(Collectors.toList());
    }
    public static void main(String[] args) {
        int[] numbers = {3, 6, 1, 9, 4, 8, 2};
        System.out.print(myMethod(numbers).toString());
    }
}
