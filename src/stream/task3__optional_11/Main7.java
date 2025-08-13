package stream.task3__optional_11;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Main7 {
    public void practice1() {
        List<Integer> numbers = List.of(3, 8, 10, 15, 4);
        numbers.stream().filter(value -> value % 5 == 0).findFirst().orElse(-1);
    }

    public int practice2() {
        Optional<Integer> value = Optional.of(7);
        return value.map(n -> n * n).orElse(-1);
    }

    public String practice3() {
        Optional<String> sentence = Optional.of("strr");
        return sentence.filter(s -> s.length() > 5).orElse("");
    }

    public String practice4() {
        Optional<String> name = Optional.of("Vitalii");
        return name.map(n -> "Hello" + n + "!").orElse("");
    }

    public void practice5() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        numbers.stream()
                .max(Comparator.naturalOrder())
                .ifPresentOrElse(value -> System.out.println("max " + value),
                () -> System.out.println("empty"));
    }

    public void practice6 () {
        Optional <String> sentence = Optional.of("admin@site.com");
        sentence.map(s->s.toLowerCase()).filter(s->s.contains(".com"))
                .orElseThrow(()-> new IllegalArgumentException("invalid email"));
    }

    public void practice7 () {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        numbers.stream().min(Integer::compareTo)
                .ifPresentOrElse(value -> System.out.println("min " + value), ()-> System.out.println("empty list"));
    }

    public void practice8 () {
        List <String> words = List.of("Java", "Spring");
        words.stream().findFirst().map(value->value.length()).ifPresentOrElse(len -> System.out.println(" " + len), () -> System.out.println("list is empty"));
    }

}
