package stream1.task18_flatMap_13;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main21 {

    public void practice () {
        List<String> sentences = List.of(
                "Java is powerful",
                "Streams are cool",
                "Java makes sense"
        );
        sentences.stream().flatMap(w-> Arrays.stream(w.split(" "))).distinct().toList();
    }

    public Integer practice2 () {
        int[][] data = {
                {3, 11},
                {6, 7},
                {10}
        };
        return Arrays.stream(data).flatMapToInt(Arrays::stream).filter(a->a%2==0)
                .min().orElse(-1);
    }

    public Integer practice3 () {
        int[][] data = {
                {-3, 5},
                {2},
                {-1, 4}
        };
        return Arrays.stream(data).flatMapToInt(Arrays::stream).filter(a->a>0).reduce((a,b)->a*b).orElse(-1);
    }

    public Integer practice4 () {
        int[][] data = {
                {3, 9},
                {8, 12},
                {7}
        };
        return Arrays.stream(data).flatMapToInt(Arrays::stream).filter(a->a%3==0)
                .max().orElse(-1);
    }

    public int practice5 () {
        int[][] data = {
                {2, 3},
                {4}
        };

        return Arrays.stream(data).flatMapToInt(Arrays::stream).filter(a->a%2==0).map(a->a*a)
                .sum();
    }

    public Double practice6 () {
        int[][] data = {
                {3, 5},
                {7}
        };
        return Arrays.stream(data).flatMapToInt(Arrays::stream).filter(a->a%2==1)
                .summaryStatistics().getAverage();
    }

    public int practice7 () {

        int[][] data = {
                {12},
                {24, 36}
        };

        return Arrays.stream(data).flatMapToInt(Arrays::stream).reduce(Main21::gcd).orElse(-1);
    }

    public static int gcd (int a, int b) {
        return b==0 ? a : gcd (b, a%b);
    }

    public List <Integer> practice8 (List<Object> input) {
        return input.stream().filter(a-> a instanceof Integer).map(i -> (Integer) i).toList();
    }

    public List<String> practice9 (List<Object> input) {
        return input.stream().filter(s->s instanceof String).map(s->(String)s).toList();
    }

    public List <Integer> practice10 () {
        return Stream.of("a", 3, 15, 11, 9, "99")
                .filter(a->a instanceof Integer && (Integer)a >10)
                .map(a->(Integer)a).toList();
    }

    public List <Boolean> practice11 (List<Object> input) {
        return input.stream().filter(v->v instanceof Boolean && (Boolean) v == true).map(v->(Boolean)v).toList();
    }

}
