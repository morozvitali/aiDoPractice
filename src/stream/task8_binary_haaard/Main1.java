package stream.task8_binary_haaard;

import java.util.Arrays;

public class Main1 {
    public int practice1 (int number) {
        String binary = Integer.toBinaryString(number);
        return (int) binary.chars().filter(c->c == '1').count();
    }

    public long practice2 (int number) {
        return Integer.toBinaryString(number).chars().filter(c->c == '1').count();
    }

    public int practice3 (int number) {
        int count = 0;
        while (number != 0) {
            if ((number & 1) ==1 ) {
                count++;
            }
            number = number >> 1; //
        }
        return count;
    }

    public long practice4 () {
        return Integer.toBinaryString(Integer.MAX_VALUE).chars().filter(c->c=='1').count();
    }

    public boolean practice5 (int a, int b) {
        long countFirst = Integer.toBinaryString(a).chars().filter(c->c == '1').count();
        long countSecond = Integer.toBinaryString(b).chars().filter(c->c == '1').count();
        return countFirst == countSecond;
    }

    public long practice6 () {
        int[] arr = {1, 2, 3, 4};
        return Arrays.stream(arr)
                .mapToLong(a->Integer.toBinaryString(a).chars().filter(c->c=='1').count()).sum();
    }

    public int practice7 (int n) {
        int i = 1;
        while (true) {
            long counter = Integer
                    .toBinaryString(i)
                    .chars()
                    .filter(a->a=='1')
                    .count();

            if ( counter == n) {
                return i;
            }
            i++;
        }
    }
}
