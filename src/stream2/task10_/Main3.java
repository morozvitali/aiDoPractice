package stream2.task10_;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main3 {
    public void practice1 () {
        IntSummaryStatistics stats = IntStream.of(5,109,15,20).summaryStatistics();
        System.out.println(stats);
    }

    public void practice2 () {
        List<Product> products = List.of(
                new Product("Apple", 10),
                new Product("Pear", 8),
                new Product("Mango", 12)
        );

        IntSummaryStatistics stats = products.stream()
                .collect(Collectors.summarizingInt(Product::getPrice));
        System.out.println(stats);
    }

}
