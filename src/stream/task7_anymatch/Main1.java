package stream.task7_anymatch;

import java.util.List;

public class Main1 {
    public boolean practice1 () {
        List<Integer> list = List.of(3, -5, 7, 10);
        return list.stream().anyMatch(a-> a < 0);
    }


}
