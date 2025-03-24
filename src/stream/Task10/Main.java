package stream.Task10;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String[] words = {"hi", "apple", "go", "banana", "car"};
        int[] numbers = {1, 2, 3, 4, 5};
        String[] words2 = {"apple", "banana", "apricot", "cherry", "avocado"};

        Main main = new Main();
        System.out.println(main.myLength(words));
        System.out.println(main.mySqrt(numbers).toString());
        System.out.println(main.myA(words2));
    }


    public List<Integer> myLength (String [] array) {
        return Arrays.stream(array)
                .filter(a -> a.length() > 3)
                .map(a -> a.length())
                .toList();
    }

    public int [] mySqrt (int [] array) {
        return Arrays.stream(array)
                .filter(a -> a%2 != 0)
                .map(a -> a*a)
                .toArray();
    }

    public List <String> myA (String [] array) {
        return Arrays.stream(array)
                .filter(a-> a.charAt(0) == 'a')
                .map(a->a.toUpperCase())
                .collect(Collectors.toList());
    }
}
