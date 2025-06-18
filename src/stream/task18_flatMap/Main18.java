package stream.task18_flatMap;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class Main18 {
    public List<Integer> practice1 () {
        List<List<Integer>> weeklyData = List.of(
                List.of(40, 55, 60),
                List.of(30, 70),
                List.of(65, 10, 90)
        );

        return weeklyData.stream()
                .flatMap(list->list.stream())
                .collect(Collectors.toList()).stream().filter(a->a<50).toList();
    }

    public int practice1_1 () {
        int[] numbers = {3, 11, 6, 7, 10};
        return Arrays.stream(numbers).filter(n->n%2==0).reduce((a,b)-> a<b ? a : b).orElse(-1);
    }

    public int practice1_2 () {
        int[] numbers = {-3, 5, 2, -1, 4};
        return Arrays.stream(numbers).filter(a->a<0).reduce((a,b)->a*b).orElse(1);
    }

    public int practice1_3 () {
        int[] numbers = {3, 9, 8, 12, 7};
        return Arrays.stream(numbers).filter(a->a%3==0).reduce((a,b)-> a>b ?a : b).orElse(-1);
    }

    public int practice1_4 () {
        int[] numbers = {2, 3, 4};
        return Arrays.stream(numbers).filter(a->a%2==0).map(n->n*n).reduce((a,b) -> a+b).orElse(-1);
    }

    public int practice2 () {
        int[][] data = {
                {3, 11},
                {6, 7},
                {10}
        };

        return Arrays.stream(data).flatMapToInt(a-> Arrays.stream(a)).reduce((a,b)->a<b?a:b).orElse(-1);
    }

    public int practice3 () {
        int[][] data = {
                {-3, 5},
                {2},
                {-1, 4}
        };
        return Arrays.stream(data).flatMapToInt(a->Arrays.stream(a)).filter(a->a>=0).reduce((a,b)->a+b).orElse(-1);
    }

    public int practice4 () {
        int[][] data = {
                {3, 9},
                {8, 12},
                {7}
        };
        return Arrays.stream(data).flatMapToInt(a->Arrays.stream(a)).filter(a->a%3==0).reduce((a,b)-> Math.max(a, b)).orElse(-1);
    }

    public int practice5 () {
        int[][] data = {
                {2, 3},
                {4}
        };
        return Arrays.stream(data).flatMapToInt(ar->Arrays.stream(ar)).filter(a->a%2==0).map(n->n*n).reduce((a,b)-> a+b).orElse(-1);
    }

    public int practice6 () {
        int[][] data = {
                {3, 5},
                {7}
        };

        int [] flat =  Arrays.stream(data).flatMapToInt(ar->Arrays.stream(ar)).filter(a->a%2 != 0).toArray();

        IntSummaryStatistics stat = Arrays.stream(flat).summaryStatistics();
        return stat.getCount() == 0 ? -1 : (int) stat.getAverage();
    }

    public int practice7 () {
        int[][] data = {
                {12},
                {24, 36}
        };
        return Arrays.stream(data).flatMapToInt(ar->Arrays.stream(ar)).reduce((a,b) -> gcd(a,b)).orElse(-1);

    }

    public int gcd (int a, int b) {
        return b==0 ? a : gcd(b, a%b);
    }

    public List <Integer> practice8 () {
        return List.of(10, "hello", true, 42, false, "42")
                .stream()
                .filter(x->x instanceof Integer)
                .map(a->(Integer)a)
                .collect(Collectors.toList());
    }

    public List <String> practice9 () {
        return List.of("hello", 1, 2.5, true, "world")
                .stream()
                .filter(a->a instanceof String)
                .map(a->(String)a)
                .collect(Collectors.toList());
    }

    public List <Integer> practice10 () {
        return List.of("a", 3, 15, 11, 9, "99").stream().filter(a-> a instanceof Integer).map(a->(Integer)a).filter(n->n>10).collect(Collectors.toList())
    }


}
