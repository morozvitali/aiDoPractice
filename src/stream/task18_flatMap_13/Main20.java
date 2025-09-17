package stream.task18_flatMap_13;

import java.util.Arrays;
import java.util.List;

public class Main20 {
    public List<String> practice1 () {
        List<String> sentences = List.of(
                "Java is powerful",
                "Streams are cool",
                "Java makes sense"
        );
        return (sentences.stream().flatMap(w->Arrays.stream(w.split(" ")))).distinct().toList();
    }

    public int practice2 () {
        int[][] data = {
                {3, 11},
                {6, 7},
                {10}
        };

        return Arrays.stream(data).flatMapToInt(Arrays::stream).filter(a->a%2==0).min().orElse(-1);
    }

    public int practice3 () {
        int[][] data = {
                {-3, 5},
                {2},
                {-1, 4}
        };

        return Arrays.stream(data).flatMapToInt(Arrays::stream).reduce((a,b) -> a*b).orElse(-1);
    }

    public int practice4 () {
        int[][] data = {
                {3, 9},
                {8, 12},
                {7}
        };
        return Arrays.stream(data).flatMapToInt(Arrays::stream).filter(a->a%3==0).max().orElse(-1);
    }

    public int practice5 () {
        int[][] data = {
                {2, 3},
                {4}
        };
        return Arrays.stream(data).flatMapToInt(Arrays::stream).map(a->a*a).sum();
    }

    public Double practice6 () {
        int[][] data = {
                {3, 5},
                {7}
        };
        return Arrays.stream(data).flatMapToInt(Arrays::stream).filter(a->a%2!=0).summaryStatistics().getAverage();
    }

    public int practice7 () {

        int[][] data = {
                {12},
                {24, 36}
        };

        return Arrays.stream(data).flatMapToInt(Arrays::stream).reduce(Main20::gcd).orElse(-1);
    }
    public static int gcd (int a,int b) {
        return b==0 ? a:gcd (b, a%b);
    }


}