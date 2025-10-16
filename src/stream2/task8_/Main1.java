package stream2.task8_;

import java.util.Optional;

public class Main1 {

    public void practice1 () {
        Optional <String> name = Optional.of("JAVA");
        name.stream().forEach(System.out::println);
    }

    public void practice2 () {
        Optional <String> empty = Optional.empty();
        empty.stream().forEach(System.out::println); // empty result, nothing
    }


}
