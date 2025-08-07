package stream.task11__mapping_remake___;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main3 {
    public void practice () {
        Arrays.stream("Hey fellow warriors".split(" "))
                .map(word->word.length() >= 5 ? new StringBuilder().append(IntStream.range(0, word.length()).mapToObj(i->String.valueOf(word.charAt(word.length()-1 -i)))
                        .collect(Collectors.joining())):word).collect(Collectors.joining(" "));
    }
}
