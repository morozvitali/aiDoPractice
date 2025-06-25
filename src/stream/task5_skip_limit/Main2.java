package stream.task5_skip_limit;
import java.util.Arrays;

public class Main2 {
    public void myReducer1 () {
        int[] numbers = {15, 3, 8, 22, 1, 10};
        System.out.println(
        Arrays.stream(numbers)
                .reduce(Integer.MAX_VALUE, (a,b) -> a<b ? a : b)
        );
    }


    public void myReducer2 () {
        String[] words = {"Java", "Python", "C++"};
        System.out.println(
        Arrays.stream(words).reduce((a,b) -> a + ", " + b)
                .orElse("")
        );
    }

    public void myReducer3() {
        int[] numbers = {123, 91, 77, 456, 18};
        System.out.println(
        Arrays.stream(numbers).reduce(0, (a,b) -> myCalc(a) >= myCalc(b) ? a : b)
                );
    }

    public int myCalc (int i) {
        String s = String.valueOf(i);
        return s.chars().map(c->c - '0').sum();

    }

    public static void main(String[] args) {
Main2 main2 = new Main2();
main2.myReducer1();
main2.myReducer2();
main2.myReducer3();
    }
}
