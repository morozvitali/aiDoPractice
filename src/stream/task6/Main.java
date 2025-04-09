package stream.task6;
import java.util.Arrays;
public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.myCollection());
        System.out.println(main.myString());
        System.out.println(main.myMult());
    }

    public String myCollection () {
        return Arrays.stream(new int[]{10, 20, 30})
                .mapToObj(String::valueOf)
                .reduce((a,b)-> a+ "|" + b)
                .orElse("empty value");
    }

    public String myString () {
        String [] array = new String [] {"apple", "pie", "banana", "kiwi", "arc", "kiss"};
        return Arrays.stream(array)
                .reduce(array[0], (a,b) -> a.length() < b.length() ? a : b);
    }

    public int myMult () {
        return Arrays.stream(new int [] {2, 3, 4, 5, 6, 7})
                .filter(a-> a%2 !=0)
                .reduce(1, (a,b) ->a*b);
    }
}