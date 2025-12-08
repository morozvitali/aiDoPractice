package stream2.task8_;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Main3 {
    public void practice1() {
        Optional<String> name = Optional.of("Java");
        name.stream().forEach(System.out::println);
    }

    public void practice2() {
        Optional<String> empty = Optional.empty();
        empty.stream().forEach(System.out::println);
    }

    public void practice3() {
        Optional<List<Integer>> maybeList = Optional.of(List.of(1, 2, 3));
        maybeList.stream()
                .flatMap(List::stream)
                .forEach(System.out::println);
    }

    public void practice4() {
        List<String> words = List.of("cat", "apple", "pear");

        Optional<String> found = words.stream()
                .filter(w -> w.length() > 4)
                .findFirst();
        found.stream().forEach(System.out::println);
    }

    public void practice5() {
        Stream<Optional<String>> optionals = Stream.of(
                Optional.of("A"),
                Optional.empty(),
                Optional.of("B")
        );
        List<String> list = optionals.flatMap(Optional::stream).toList();
        System.out.println(list);
    }

    public void practice6() {
        Optional<Optional<String>> nested = Optional.of(Optional.of("Hello"));
        nested.stream()
                .flatMap(Optional::stream)
                .forEach(System.out::println);

    }


}
