package stream.task5;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();

        main.myMin();
        main.myConcat();
        main.maxSum();

    }

    public void myMin() {
        int min = Arrays.stream(new int[]{9781, 7885, 7874, 7788, 8876, 5786, 798})
                .reduce(Integer.MAX_VALUE, (Integer::min));
        System.out.println(min);
    }

    public void myConcat() {
        String concat = Arrays.stream(new String[]{"Java", "Python", "C++"})
                .reduce((a, b) -> a + ", " + b)
                .orElse("");
        System.out.println(concat);
    }

    public void maxSum() {
        int max = Arrays.stream(new int[]{123, 91, 77, 456, 18})
                .reduce(0, (a, b) -> subSum(a) > subSum(b) ? a : b);
        System.out.println(max);
    }

        public int subSum(int number) {
            int sum = 0;
            while (number > 0) {
                sum += number % 10;
                number /= 10;
            }
            return sum;
        }
    }

