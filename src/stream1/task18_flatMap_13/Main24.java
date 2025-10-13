package stream1.task18_flatMap_13;

import java.util.Arrays;
import java.util.List;

public class Main24 {

    public List<String> practice1() {
        List<String> sentences = List.of(
                "Java is powerful",
                "Streams are cool",
                "Java makes sense"
        );
        return sentences.stream().flatMap(w -> Arrays.stream(w.split(" "))).distinct().toList();
    }

    public int practice2() {
        int[][] data = {
                {3, 11},
                {6, 7},
                {10}
        };
        return Arrays.stream(data).flatMapToInt(Arrays::stream).min().orElse(-1);
    }

    public int practice3() {
        int[][] data = {
                {3, 11},
                {6, 7},
                {10}
        };
        return Arrays.stream(data).flatMapToInt(Arrays::stream).filter(a -> a % 2 == 0).min().orElse(-1);
    }

    public int practice4() {
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
        return Arrays.stream(data).flatMapToInt(Arrays::stream).filter(a->a%2==1).average().orElse(-1);
    }

    public int practice7 () {
        int[][] data = {
                {12},
                {24, 36}
        };
        return Arrays.stream(data).flatMapToInt(Arrays::stream).reduce(Main24::gcd).orElse(-1);
    }
    public static int gcd (int a, int b) {
        return b==0 ? a : gcd (a,b);
    }

    public List<Integer> practice8 (List<Object> input) {
        return input.stream().filter(i->i instanceof Integer).map(i->(Integer)i).toList();
    }

    public List <String> practice9 (List<Object> input) {
        return input.stream().filter(s->s instanceof String).map(s->(String)s).toList();
    }

    public List <Integer> practice10 (List<Object> input) {
        return input.stream().filter(v->v instanceof Integer && (Integer) v >10).map(v->(Integer)v).toList();
    }

    public List <Boolean> practice11 (List<Object> input) {
        return input.stream().filter(b->b instanceof Boolean && (Boolean) b == true).map(b->(Boolean)b).toList();
    }
}