package stream2.task10_;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main1 {
    public void practice1() {
        IntSummaryStatistics stats = IntStream.of(5, 10, 15, 20).summaryStatistics();
        System.out.println(stats.getAverage());
    }

    public IntSummaryStatistics practice2() {
        List<Product> products = List.of(
                new Product("Apple", 10),
                new Product("Pear", 8),
                new Product("Mango", 12)
        );

        IntSummaryStatistics stats = products.stream().collect(Collectors.summarizingInt(Product::getPrice));
        return stats;
    }

    public Map<String, Double> practice3 () {
        List<Product> items = List.of(
                new Product("fruit", 10),
                new Product("fruit", 20),
                new Product("veg", 5)
        );

        return items.stream().collect(Collectors.groupingBy(Product::getFruit, Collectors.averagingInt(Product::getPrice)));
    }

    public Map <String, IntSummaryStatistics> practice4 () {
        List<Product> items = List.of(
                new Product("fruit", 10),
                new Product("fruit", 20),
                new Product("veg", 5)
        );
        return items.stream().collect(Collectors.groupingBy(Product::getFruit, Collectors.summarizingInt(Product::getPrice)));
    }



}

class Product {
    String fruit;
    static int number;

    Product(String fruit, int number) {
        this.fruit = fruit;
        this.number = number;
    }

    public int getPrice() {
        return number;
    }

    public String getFruit () {
        return fruit;
    }
}