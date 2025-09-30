package stream.task11_string_formater_goood;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductCatalog1 {
    private Map<String, Double> products = new HashMap <> ();
    public void addProduct (String name, double price) {
        products.put(name, price);
    }

    public Double getPrice (String name) {
        return products.get(name);
    }

    public List<String> getAllProductsSorted() {
        return products.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .toList();
    }



}
