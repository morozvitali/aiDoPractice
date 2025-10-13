package stream1.task16_comparator_8;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main1 {
    public void practice1() {
        List<String> words = List.of("sky", "banana",
                "apple", "grape", "orange", "plum");
        words.stream().sorted(Comparator.comparing((String s) -> s.chars().filter(ch -> "aeiou".indexOf(ch) >= 0).count()).thenComparing(Comparator.naturalOrder())).forEach(System.out::println);
    }

    public void practice2() {
        List.of("alpha", "arena", "java", "banana", "lava").stream()
                .map(w -> Map.entry(w, countOf(w, 'a')))
                .max(Comparator.comparing(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .orElse("empty");
    }

    public long countOf(String s, char ch) {
        return s.chars().filter(a -> "aeiou".indexOf(ch) >= 0).count();
    }

    public void practice3() {
        List.of(111, 123, 444, 1212).stream().map(n -> Map.entry(n, (int) String.valueOf(n)
                        .chars()
                        .distinct()
                        .count()))
                .max(Map.Entry.comparingByValue()).get().getKey();
    }

    public void practice4() {
        List.of("abc", "aaa", "zzz").stream()
                .map(a -> Map.entry(a, a.chars().sum()))
                .max(Comparator.comparing(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .orElse("нема");
    }

    public void practice5 () {
        List<String> words = List.of("sun", "star", "supernova", "apple");
        words.stream().filter(word -> word.startsWith("s")).max(Comparator.comparing(w->w.length())).orElse("немає слів на 's");
    }
    public void practice6 () {
        List.of("abc", "def", "gka", "lol").stream().sorted(
                Comparator.comparing(s->s.charAt(s.length() - 1)))
                        .collect(Collectors.toList());
    }

    public void practice7 () {
        List.of("java", "hello", "me", "zebra").stream().filter(w->w.contains("e"))
                .min(Comparator.comparing(word->word.length()))
                .orElse("empty value");
    }

    public void practice8 () {
        List.of(100, 1010, 5, 2000, 10).stream().sorted(Comparator.comparing(n->countOf(n, '0')));
    }
    public long countOf (int n, char ch){
        return String.valueOf(n).chars().filter(c->c == ch).count();
    }

    public void practice9 () {
        List.of("apple", "zebra", "sky", "education").stream()
                .sorted(Comparator
                        .comparing(a->countVowels(a)))
                .collect(Collectors.toList());
    }

    public long countVowels(String word) {
        return word.chars().filter(c->"aeiou".indexOf(c)>=0).count();
    }
}
