package stream1.task11_string_formater_goood;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductCatalog1 {
    private Map<String, Double> products = new HashMap<>();

    public void addProduct(String name, double price) {
        products.put(name, price);
    }

    public Double getPrice(String name) {
        return products.get(name);
    }

    public List<String> getAllProductsSorted() {
        return products.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .toList();
    }

    public Map<String, Integer> countWords(String text) {
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : text.toLowerCase().split("\\W+")) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        return wordCount;
    }
}