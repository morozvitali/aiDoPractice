package stream.task11_string_formater_goood;

import java.util.*;

public class PhoneBook1 {
    private Map<String, Set<String>> phoneBook = new HashMap<>();
    public void add (String surname, String phone) {
        phoneBook.computeIfAbsent(surname, k->new HashSet<>()).add(phone);
    }
    public Set <String> get(String surname) {
        return phoneBook.getOrDefault(surname, Collections.emptySet());
    }
}
