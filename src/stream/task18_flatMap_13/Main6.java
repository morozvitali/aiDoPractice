package stream.task18_flatMap_13;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main6 {
    public List <Integer> practice0 () {
        List<List<Integer>> weeklyData = List.of(
                List.of(40, 55, 60),
                List.of(30, 70),
                List.of(65, 10, 90)
        );
        return weeklyData.stream().flatMap(list->list.stream()).filter(a->a>50).collect(Collectors.toList());
    }

    public List <String> practice1 () {
        List<String> sentences = List.of(
                "Java is powerful",
                "Streams are cool",
                "Java makes sense"
        );
        return sentences.stream().flatMap(s -> Arrays.stream(s.split(" "))).distinct().map(String::toLowerCase).collect(Collectors.toList());
    }

    public int practice2 () {
        int[][] data = {
                {3, 11},
                {6, 7},
                {10}
        };
        return Arrays.stream(data).flatMapToInt(arr->Arrays.stream(arr)).boxed().min(Comparator.naturalOrder()).orElse(-1);
    }

    public int practice4 () {
        int[][] data = {
                {3, 9},
                {8, 12},
                {7}
        };
        return Arrays.stream(data).flatMapToInt(arr->Arrays.stream(arr)).filter(a->a%3==0).max().orElse(-1);
    }

    public int practice5 () {
            int[][] data = {
                    {2, 3},
                    {4}
            };
            return Arrays.stream(data).flatMapToInt(arr->Arrays.stream(arr)).filter(a->a%2==0).sum();
    }
    public int practice6 () {
        int[][] data = {
                {3, 5},
                {7}
        };
        return  (int) Arrays.stream(data).flatMapToInt(arr->Arrays.stream(arr)).filter(a->a%2==1).summaryStatistics().getAverage();
    }

    public void practice8 () {
        Stream.of(10, "hello", true, 42, false, "42").filter(value-> value instanceof Integer)
                .map(i->(Integer)i)
                .toList();
    }

    public List <String> practice9 () {
        return Stream.of("hello", 1, 2.5, true, "world").filter(value-> value instanceof String).map(value->(String)value).toList();
    }

    public List <Integer> practice10 () {
        return Stream.of("a", 3, 15, 11, 9, "99").filter(value-> value instanceof Integer && (Integer) value > 10).toList();
    }



}
