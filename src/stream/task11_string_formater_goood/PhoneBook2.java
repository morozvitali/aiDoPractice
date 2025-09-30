package stream.task11_string_formater_goood;

import java.util.*;

public class PhoneBook2 {
    private Map<String, List<String>> phoneBook = new HashMap<>();

    public void add(String surname, String phone) {
        phoneBook.computeIfAbsent(surname, k -> new ArrayList<>()).add(phone);
    }

    public List<String> get(String surname) {
        return phoneBook.getOrDefault(surname, Collections.emptyList());
    }

    public List<String> findByPrefix(String prefix) {
        List<String> result = new ArrayList<>();
        for (String surname : phoneBook.keySet()) {
            if (surname.startsWith(prefix)) {
                result.add(surname);
            }
        }
        return result;
    }
}