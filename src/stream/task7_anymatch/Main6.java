package stream.task7_anymatch;

import java.util.List;

public class Main6 {
    public boolean practice1 () {
        List<Integer> list = List.of(3, -5, 7, 10);
        return list.stream().anyMatch(n-> n<0);
    }

    public boolean practice2 () {
        List<Integer> list = List.of(2, 5, 10, 20);
        return list.stream().allMatch(a->a>0);
    }

}
