package stream.task15_grouping_20;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main12 {
    public void practice1 () {
        String[] words = {"sky", "apple",
                "dry", "orange", "sun"};
        Arrays.stream(words).collect(Collectors.toMap(Function.identity(), w->w.chars().anyMatch()))
    }

    public void practice2 () {

    }
}
