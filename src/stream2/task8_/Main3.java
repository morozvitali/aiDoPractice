package stream2.task8_;

import java.util.Optional;

public class Main3 {
    public void practice1 () {
        Optional<String> name = Optional.of("Java");
        name.stream().forEach(System.out::println);
     }

    public void practice2 () {
        Optional <String> empty = Optional.empty();
        empty.stream().forEach(System.out::println);
    }




}
