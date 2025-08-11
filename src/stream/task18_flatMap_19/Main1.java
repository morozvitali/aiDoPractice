package stream.task18_flatMap_19;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main1 {
    public void practice1 () {
        List<String> sentences = List.of(
                "Java is powerful",
                "Streams are cool",
                "Java makes sense"
        );
        sentences.stream()
                .flatMap(sentence -> Arrays.stream(sentence.split(" ")))
                .distinct()
                .collect(Collectors.toList());
    }

    public int practice2 () {
        int[][] data = {
                {3, 11},
                {6, 7},
                {10}
        };

        return Arrays.stream(data)
                .flatMap(arr -> Arrays.stream(arr)
                        .boxed())
                .filter(a->a%2==0)
                .min(Comparator.naturalOrder())
                .orElse(-1);
    }

    public int practice3 () {
        int[][] data = {
                {-3, 5},
                {2},
                {-1, 4}
        };

        return Arrays.stream(data)
                .flatMap(arr->Arrays.stream(arr)
                        .boxed())
                .filter(value -> value > 0)
                .reduce((a,b)->a*b)
                .orElse(-1);
    }

    public int practice4 () {
        int[][] data = {
                {3, 9},
                {8, 12},
                {7}
        };

        return Arrays.stream(data)
        .flatMapToInt(arr->Arrays.stream(arr))
                .filter(value->value%3==0)
                .max()
                .orElse(-1);
    }

    public int practice5 () {
        int[][] data = {
                {2, 3},
                {4}
        };

        return Arrays.stream(data).flatMapToInt(arr->Arrays.stream(arr))
                .filter(a->a%2==0)
                .map(a->a*a)
                .sum();
    }

    public void practice6 () {
        int[][] data = {
                {3, 5},
                {7}
        };

        IntSummaryStatistics stats = Arrays.stream(data).flatMapToInt(Arrays::stream).filter(a->a%2!=0).summaryStatistics();
        int result = stats.getCount() == 0 ? -1 : (int) stats.getAverage();
    }

    public void practce7 () {
        int[][] data = {
                {12},
                {24, 36}
        };
        Arrays.stream(data).flatMapToInt(Arrays::stream).reduce(Main1::gcd).orElse(-1);
    }
    public static int gcd (int a, int b) {
        return b==0 ? a :gcd (b, a%b);
    }

    public List <Integer> practice8 () {
        List <Object> list = List.of(10, "hello", true, 42, false, "42");

        return list.stream().filter(value -> value instanceof Integer).map(value -> (Integer) value).collect(Collectors.toList());
    }

    public List <String> practice9 () {
        List <Object> list = List.of("hello", 1, 2.5, true, "world");
        return list.stream().filter(value-> value instanceof String).map(value-> (String) value).toList();
    }

    public List <Integer> practice10 () {
        List <Object> list = List.of("a", 3, 15, 11, 9, "99");
        return list.stream().filter(value -> value instanceof Integer && (Integer)value > 10).map(value->(Integer)value).toList();
    }

    public List <Boolean> practice11 () {
        List <Object> list = List.of("yes", true, false, true, 1);
        return list.stream().filter(val -> val instanceof Boolean && (Boolean) val == true).map(val->(Boolean)val).toList();
    }

    public List <String> practice12 () {
        List <Object> list = List.of("hi", 123, "bye", false);
        return list.stream().filter(val->val instanceof String).map(val-> ((String) val).toUpperCase()).toList();
    }

    public String practice13 (String sentence) {
        Map<Character, Long> map = sentence.toLowerCase().chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(c->c, Collectors.counting()));
        return sentence.chars().mapToObj(c->(char)c).map(ch->map.get(ch) >1 ? ")" : "(")
                .collect(Collectors.joining());
    }


 }
