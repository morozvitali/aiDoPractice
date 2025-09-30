package stream.task11_string_formater_goood;

import java.util.List;
import java.util.TreeMap;

public class BookPhone {
    TreeMap<String, String> treeMap = new TreeMap<>();
    public void add (String name, String phone) {
        treeMap.put(name, phone);
    }
    public String get (String name) {
        return treeMap.getOrDefault(name, "");
    }

    public List<String> getAll () {
        return treeMap.keySet().stream().toList();
    }
}
