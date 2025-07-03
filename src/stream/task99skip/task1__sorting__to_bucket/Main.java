package stream.task99skip.task1__sorting__to_bucket;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] numbers = {3, 6, 1, 9, 4, 8, 2};
        int[] result = filtering(numbers);
        System.out.println(Arrays.toString(result)); // [4, 16, 36, 64]
    }

    public static int [] filtering(int[] arr) {
        return (int[]) Arrays.stream(arr)
                .filter(x -> x % 2 == 0)
                .map(x -> x * x)
                .boxed()
                .sorted((a, b) -> b - a)
                .mapToInt(Integer::intValue)
                .toArray();
    }
}