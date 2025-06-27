package stream.task13__Instream_iterator;

import java.util.Comparator;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class Main6 {

    public static void practice2() {
        IntStream.iterate(2, i -> i + 2).limit(10).forEach(System.out::println);
    }

    public static void main(String[] args) {
        Main6.practice14("programmingisfun");

    }

    public void practice3() {
        IntStream.iterate(1, i -> i+2).limit(10)
                .forEach(System.out::println);
    }

    public void practice4 () {
        IntStream.iterate(50, i->i-5).limit(10)
                .forEach(System.out::println);
    }

    public void practice5 () {
        IntStream.iterate(1,i-> i+1).limit(10)
                .forEach(System.out::println);
    }

    public void practice6 () {
        IntStream.iterate(17, i->i+10).limit(9)
                .forEach(System.out::println);
    }

    public void practice7 () {
        IntStream.iterate(1, i->i * 2).limit(10)
                .forEach(System.out::println);
    }

    public void practice8 () {
        IntStream.iterate(1, i ->i+3).filter(a -> a%2 == 0)
                .limit(10).forEach(System.out::println);
    }

    public void practice9 () {
        IntStream.iterate(1, i->i+1).
                map(a->a*a)
                .filter(a->a%5 != 0)
                .limit(10)
                .forEach(System.out::println);
    }

    public void practice10 () {
        IntStream.iterate(1, i->i+1).skip(5).filter(a->a%5==0).limit(10);
    }

    public void practice11 () {
        IntStream.iterate(1, i-> i+1).takeWhile(new IntPredicate() {
            int sum = 0;
            @Override
            public boolean test(int i) {
                sum = sum + i;
                return sum < 50;
            }
        }).forEach(System.out::println);
    }

     public void practice12 () {
        IntStream.iterate(1, i-> i+1)
                .map(a->a*a)
                .distinct()
                .limit(5)
                .forEach(System.out::println);
     }

    public static void practice13(String s) {
        s.chars().distinct().limit(10)
                .forEach(c->System.out.println((char)c));
    }

    public static void practice14 (String s) {
        s.chars().mapToObj(ch->(char)ch)
                .filter(ch -> "aeiou".indexOf(ch) >= 0)
                .forEach(System.out::println);

    }

    public static void practice15 () {
        IntStream.rangeClosed(1,20)
                .map(i->i*i)
                .peek(i->System.out.println("LOG " + i))
                .filter(i->i%4==0)
                .forEach(System.out::println);
    }

    public static String practice16 () {
        List<String> words = List.of("sky", "apple", "banana", "cat", "loop");

        return words.stream()
                .filter(w->w.chars().distinct().count() < w.length())
                .min(Comparator.comparing(a->String.valueOf(a.length())))
                        .orElse("Немає");
    }

    public static int practice17 () {
        List<Integer> nums = List.of(23, 70, 172, 88, 45, 27, 97, 21);
            return nums.stream().filter(a->String.valueOf(a).contains("7"))
                    .max((a,b) -> Integer.compare(a,b))
                    .orElse(-1);
    }

    public static void practice18 () {
        List<String> words = List.of("sky", "banana",
                "apple", "grape", "orange", "plum");

        words.stream()
                .sorted(Comparator
                        .comparing((String w) -> w.chars()
                                .filter(ch->"aoeou".indexOf(ch)>=0).count())
                .thenComparing(Comparator
                        .naturalOrder())).forEach(System.out::println);
    }
}
