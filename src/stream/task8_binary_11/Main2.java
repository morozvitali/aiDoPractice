package stream.task8_binary_11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main2 {
    public long practice1(int number) {
        return Integer.toBinaryString(number).chars().filter(c -> c == '1').count();
    }

    public long practice2(int number) {
        return Integer.toBinaryString(number).chars().filter(c -> c == '1').count();
    }

    public int practice3(int number) {
        int count = 0;
        while (number != 0) {
            if ((number & 1) == 1) {
                count++;
            }
            number = number >> 1;
        }
        return count;
    }

    public long practice4() {
        return Integer.toBinaryString(Integer.MAX_VALUE).chars().filter(c -> c == '1').count();
    }

    public boolean practice5(int a, int b) {
        return countBits(a) > countBits(b);
    }

    public long countBits(int number) {
        return Integer.toBinaryString(number).chars().filter(c -> c == '1').count();
    }

    public long practice6() {
        int[] arr = {1, 2, 3, 4};
        return Arrays.stream(arr).boxed().mapToLong(value -> Integer.toBinaryString(value).chars().filter(c -> c == '1').count()).sum();
    }

    public int practice7(int n) {
        int i = 1;
        while (true) {
            long counter = Integer
                    .toBinaryString(i)
                    .chars()
                    .filter(a -> a == '1')
                    .count();

            if (counter == n) {
                return i;
            }
            i++;
        }
    }

    public void practice8(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(i);
        }
        list.stream()
                .filter(value -> Integer.toBinaryString(value)
                        .chars().filter(c -> c == '1')
                        .count() % 2 == 0)
                .collect(Collectors.toList());
    }

    public boolean practice9 (int number) {
        return Integer
                .toBinaryString(number)
                .equals(new StringBuffer(Integer
                        .toBinaryString(number))
                        .reverse()
                        .toString());
    }


}
