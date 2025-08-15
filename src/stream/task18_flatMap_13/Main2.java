package stream.task18_flatMap_13;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main2 {
    public void practice0 () {
        Stream.of(
                List.of(40, 55, 60),
                List.of(30, 70),
                List.of(65, 10, 90)
        ).flatMap(list->list.stream()).filter(a->a>50).collect(Collectors.toList());
    }

public List <String> practice1 () {
    List<String> sentences = List.of(
            "Java is powerful",
            "Streams are cool",
            "Java makes sense"
    );
    return sentences.stream().flatMap(sent-> Arrays.stream(sent.split(" "))).distinct().collect(Collectors.toList());
}

public int practice2 () {
    int[][] data = {
            {3, 11},
            {6, 7},
            {10}
    };
    return Arrays.stream(data).flatMapToInt(ar->Arrays.stream(ar)).filter(a->a%2==0).min().orElse(-1);
}

public int practice3 () {
    int[][] data = {
            {-3, 5},
            {2},
            {-1, 4}
    };
    return Arrays.stream(data).flatMapToInt(arr->Arrays.stream(arr)).filter(a->a>0).reduce((a,b)-> a*b).orElse(-1);
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

    return Arrays.stream(data).flatMapToInt(arr->Arrays.stream(arr)).filter(a->a%2==0).map(a->a*a).sum();
}

public double practice6 () {
    int[][] data = {
            {3, 9},
            {8, 12},
            {7}
    };
    return Arrays.stream(data).flatMapToInt(arr->Arrays.stream(arr)).filter(n->n%2 == 1).summaryStatistics().getAverage();
}

public List <Integer> practice8 () {
    return Stream.of(10, "hello", true, 42, false, "42")
            .filter(x -> x instanceof Integer)
            .map(i->(Integer)i)
            .toList();
    }

    public List <String> practice9 () {
        return Stream.of("hello", 1, 2.5, true, "world")
                .filter(value->value instanceof String).map(a->(String)a)
                .toList();
    }

public List <Integer> practice10 () {
        return Stream.of("a", 3, 15, 11, 9, "99")
                .filter(value -> value instanceof Integer && (Integer)value > 10)
                .map(value -> (Integer) value).toList();
}


}
