package stream2.task8_;

import java.util.Optional;

public class Main1 {

    public void practice1 () {
        Optional <String> name = Optional.of("JAVA");
        name.stream().forEach(System.out::println);
    }



}
