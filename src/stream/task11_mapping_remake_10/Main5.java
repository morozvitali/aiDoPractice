package stream.task11_mapping_remake_10;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main5 {
    public String practice1() {
        return Arrays.stream(("Hey fellow warriors").split(" "))
                .map(w -> w.length() > 5 ? new StringBuilder(w).reverse().toString() : w).collect(Collectors.joining(" "));
    }

    public String practice2(String s) {
        return Arrays.stream(s.split(" "))
                .map(w -> w.length() > 5 ? "[...]" : w)
                .collect(Collectors.joining());
    }

    public String practice3(String s) {
        String[] arr = s.split(" ");
        String temp = arr[0];
        arr[0] = arr[arr.length - 1];
        arr[arr.length - 1] = temp;
        return String.join(" ", arr);
        //return Arrays.stream(arr).collect(Collectors.joining(" "));
    }

    public String practice4(String s) {
        return Arrays.stream(s.split(" "))
                .map(w->"(" + w + ")")
                .collect(Collectors.joining(" "));
    }

    public String practice5 (String s) {
        return Arrays.stream(s.split(" "))
                .filter(w->w.contentEquals(new StringBuilder(w)
                        .reverse()))
                .collect(Collectors.joining(" "));
    }

    public String practice6 (String s) {
        return Arrays.stream(s.split(" "))
                .map(w->w.matches(".*[aeiouAEIOU].*") ? new StringBuilder(w).reverse().toString() : w)
                .collect(Collectors.joining(" "));
    }

    public String practice7 (String s) {
        StringBuilder sb = new StringBuilder();
        return IntStream.range(0, s.length() +1)
                .mapToObj(i -> sb.append(s.substring(0, i+1)).append("\n"))
                .collect(Collectors.joining());
    }


}
