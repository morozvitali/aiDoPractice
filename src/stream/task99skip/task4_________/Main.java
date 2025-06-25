package stream.task99skip.task4_________;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.mySum();
        main.myMult();
        main.myConcat();
        main.myMax();
    }

    public void mySum() {
        int sum = Arrays.stream(new int[]{1, 2, 3, 4, 5})
                .reduce(0, (a, b) -> a + b);
        System.out.println(sum);
    }

    public void myMult() {
        int mult = Arrays.stream(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}).reduce(1, (a, b) -> a * b);
        System.out.println(mult);
    }

    public void myConcat() {
        String concat = Arrays.stream(new String[]{"Java ", "Python ", "C++ "})
                .reduce("", (a,b)-> a + b);
        System.out.println(concat);
    }

    public void myMax() {
        int max = Arrays.stream(new int [] {1,5,7,4,9,10000})
                .reduce (0, Integer::max);
        System.out.println(max);
    }
}

