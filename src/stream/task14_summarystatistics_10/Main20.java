package stream.task14_summarystatistics_10;

import java.util.Arrays;

public class Main20 {
        public Long practice() {
            int[] numbers = {2, 4, 2, 6, 8, 4, 10, 10, 12};
            return Arrays.stream(numbers).filter(a->a%2==0)
                    .distinct()
                    .summaryStatistics().getCount();
        }


}
