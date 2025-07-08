package stream.task7_anymatch;

import java.util.List;

public class Main0 {

    public boolean practice1 () {
        List<Integer> list = List.of(3, -5, 7, 10);
        return list.stream().allMatch(a->a>=0);
    }



}
