package stream3.task6_;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main1 {


    public String practice1(List<String> data) {
        return data.stream().filter(w -> w.contains("p"))
                .collect(Collectors.collectingAndThen(Collectors.toList(),
                        list -> {
                            if (list.size() != 1) {
                                throw new IllegalStateException("Expected only one word with 'p'");
                            }
                            return list.get(0);
                        }
                ));
    }

    public List <String> practice2 (List <String> words) {
        return words.stream()
                .filter(w->"aeiou"
                        .chars()
                        .allMatch(c->w.indexOf(c)>=0))
                .toList();
    }

    public List<Long> practice3 () {
        return new Random().ints(100, -100, 101)
                .mapToObj(String::valueOf)
                .map(Long::valueOf)
                .filter(n->n>0)
                .sorted(Comparator.reverseOrder())
                .limit(10)
                .toList();
    }

    public Integer practice4 () {
        return Stream.of("hi","hello","mango","go","halo","yo")
                .collect(Collectors.groupingBy(w->w.charAt(w.length()-1)))
                .size();
    }

    public List <String> practice5 (List <String> words) {
        return words.stream().peek(w-> System.out.println("Begin " + w))
                .map(String::toUpperCase)
                .peek(w-> System.out.println(" upper " + w))
                .filter(w->w.length() > 3)
                .toList();
    }

    public int practice6 (int n) {
        int [] digits = String.valueOf(n).chars().map(c->c-'0').toArray();
        return IntStream.range(0, digits.length).filter(i->i%2==1).map(i->digits[i]).reduce(1,(a,b)->a*b);
    }

    public Map <Integer, List<String>> practice7 (List <String> words) {
        return words.stream().filter(w-> !w.isBlank() && !isPalindrome(w))
                .collect(Collectors.groupingBy(String::length));
    }

    public static boolean isPalindrome (String s) {
        return new StringBuilder(s).reverse().equals(s);
    }

    public Integer practice8 () {
        return Stream.of(111,123,444,9087).max(Comparator.comparing(
                a->String.valueOf(Math.abs(a))
                        .chars()
                        .distinct()
                        .map(c->c-'0').count()))
                .orElse(-1);
    }


}

