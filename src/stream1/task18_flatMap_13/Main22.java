package stream1.task18_flatMap_13;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main22 {
    public List<String> practice1 () {
        List<String> sentences = List.of(
                "Java is powerful",
                "Streams are cool",
                "Java makes sense"
        );
        return sentences.stream().flatMap(s->Arrays.stream(s.split(" "))).distinct().toList();
    }

    public int practice2 () {
        int[][] data = {
                {3, 11},
                {6, 7},
                {10}
        };

        return Arrays.stream(data).flatMapToInt(Arrays::stream).min().orElse(-1);
    }

    public int practice3 () {
        int[][] data = {
                {-3, 5},
                {2},
                {-1, 4}
        };
        return Arrays.stream(data).flatMapToInt(Arrays::stream).filter(a->a>0).reduce((a,b)->a*b).orElse(-1);
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
        return Arrays.stream(data).flatMapToInt(Arrays::stream).filter(n->n%2==0).summaryStatistics().getAverage();
    }

    public int practice7 () {
        int[][] data = {
                {12},
                {24, 36}
        };
        return Arrays.stream(data).flatMapToInt(Arrays::stream).reduce(Main22::gcd).orElse(-1);
    }

    public static int gcd (int a, int b) {
        return b==0? a : gcd (b, a%b);
    }

    public List <Integer> practice8 (List <Object> list) {
        return list.stream().filter(o->o instanceof Integer).map(o->(Integer)o).toList();
    }

    public List <String> practice9 (List <Object> list) {
        return list.stream().filter(o->o instanceof String).map(o->(String)o).toList();
    }

    public List<Integer> practice10 (List<Object> list) {
        return list.stream().filter(o->o instanceof Integer && (Integer)o >10).map(o->(Integer)o).toList();
    }

    public List<Boolean> practice11 (List<Object>list) {
        return list.stream().filter(o->o instanceof Boolean && (Boolean) o == true).map(o->(Boolean)o).toList();
    }

    public List<String> practice12 (List <Object> list) {
        return list.stream().filter(o->o instanceof String).map(o->((String)o).toUpperCase()).toList();
    }

    public String practice13 (List <Object> list) {


        Map<Character, Long> map = list.stream().filter(w->w instanceof String).map(w->(String) w)
                .flatMap(w->w.chars().mapToObj(c->(char)c)).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return list.stream().filter(w->w instanceof String).map(w->(String) w)
                .flatMap(w->w.chars().mapToObj(c->(char)c))
                .map(ch->map.get(ch)>1 ? ")" : "(" )
                .collect(Collectors.joining());
    }
 }
