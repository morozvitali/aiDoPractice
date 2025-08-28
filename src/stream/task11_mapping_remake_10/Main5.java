package stream.task11_mapping_remake_10;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Main5 {
    public String practice1 () {
        return Arrays.stream(("Hey fellow warriors").split(" "))
                .map(w->w.length() >5 ? new StringBuilder(w).reverse().toString() : w).collect(Collectors.joining(" "));
    }

public String practice2 (String s) {
        return Arrays.stream(s.split(" "))
                .map(w->w.length() >5 ? "[...]" : w)
                .collect(Collectors.joining());
}

}
