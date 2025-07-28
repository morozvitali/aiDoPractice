package stream.task11__mapping;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Main2 {
    public void practice1 () {
        Arrays.stream("Hey fellow warriors".split(" ")).map(w-> w.length() < 5 ? w : new StringBuilder (w).reverse().toString()).collect(Collectors.joining(" "));
    }

}
