package stream.task18_flatMap_19;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main1 {
    public void practice1 () {
        List<String> sentences = List.of(
                "Java is powerful",
                "Streams are cool",
                "Java makes sense"
        );
        sentences.stream()
                .flatMap(sentence -> Arrays.stream(sentence.split(" ")))
                .distinct()
                .collect(Collectors.toList());
    }

    public void practice2 () {
        int[][] data = {
                {3, 11},
                {6, 7},
                {10}
        };

        Arrays.stream(data)
                .flatMap(arr -> Arrays.stream(arr)
                        .boxed())
                .filter(a->a%2==0)
                .min(Comparator.naturalOrder())
                .orElse(-1);



                .collect(Collectors.toList());
    }

}
