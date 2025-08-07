package stream.task99skip.task13__Instream_iterator;

import java.util.Comparator;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class Main7 {
    public void practice1 () {
        IntStream.iterate(10, i->i-1).limit(10).forEach(System.out::println);
    }

    public void practice2 () {
        IntStream.iterate(2, i->i+2).limit(10).forEach(System.out::println);
    }

    public void practice3 () {
        IntStream.iterate(1, i-> i+1).limit(10).forEach(System.out::println);
    }

    public void practice4 () {
        IntStream.iterate(5, i->i+5).limit(10).forEach(System.out::println);
    }

    public void practice5 () {
        IntStream.iterate(1,i->i+1).limit(10).map(a->a*a).forEach(System.out::println);
    }

    public void practice6 () {
        IntStream.iterate(17, i->i+1).limit(9).forEach(System.out::println);
    }

    public void practice7 () {
        IntStream.iterate(1, i->i*2).limit(10).forEach(System.out::println);
    }

    public void practice8 () {
        IntStream.iterate(1, i-> i+1).filter(a->a%2==0).map(a->a+3).limit(10).forEach(System.out::println);
    }

    public void practice9 () {
        IntStream.iterate(1, i->i+1).filter(a->a%10 != 5).limit(10).forEach(System.out::println);
    }

    public void practice10 () {
        IntStream.iterate(1, i-> i+1).filter(a->a%5==0).skip(5).limit(10).forEach(System.out::println);
    }

    public void practice11 () {
        IntStream.iterate(1, i->i+1).takeWhile(new IntPredicate() {
            int sum = 0;
            @Override
            public boolean test(int i) {
                sum = sum + i;
                return sum < 50;
            }
        }).forEach(System.out::println);
    }

    public void practice12 () {
        "programmingisfun"
                .chars()
                .distinct()
                .limit(10)
                .forEach(ch -> System.out.println((char)ch));
    }

    public void practice13 () {
        "streamprocessing".chars()
                .mapToObj(c->(char)c)
                .filter(ch-> "aeiou".indexOf(ch)>=0)
                .forEach(System.out::println);
    }

    public void practice14 () {
        IntStream.rangeClosed(1,20)
                .map(a->a*a)
                .peek(a-> System.out.println("Log " + a))
                .filter(a-> a%4 == 0)
                .forEach(System.out::println);
    }

    public String practice15 () {
        List<String> words = List.of("sky",
                "apple", "banana", "cat", "loop");
        return words.stream()
                .filter(w->w.chars().distinct().count() < w.length())
                .reduce((a,b)-> a.length() < b.length() ? a : b).orElse("empty");
    }

    public void practice16 () {
        List<Integer> nums = List.of(23, 70, 172,
                88, 45, 27, 97, 21);
        nums.stream().filter(a->String.valueOf(a).contains("7")).max(Integer::compareTo)
                .orElse(-1);
    }

    public void practice17 () {
        List<String> words = List.of("sky", "banana",
                "apple", "grape", "orange", "plum");
        words.stream()
                .sorted(Comparator.comparing((String w) -> w.chars()
                        .filter(ch-> "aeiou".indexOf(ch) >= 0)
                        .count()).thenComparing(Comparator.naturalOrder()))
                .forEach(System.out::println);
    }
}
