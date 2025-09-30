package stream.task11_string_formater_goood;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
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

    public void remove(String surname, String phone) {
        if (phoneBook.containsKey(surname)) {
            phoneBook.get(surname).remove(phone);
        }
    }

    public List<String> findSurnameByPhone(String phone) {
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : phoneBook.entrySet()) {
            if (entry.getValue().contains(phone)) {
                result.add(entry.getKey());
            }
        }
        return result;
    }

    public List<String> getAllSurnamesSorted() {
        return phoneBook.keySet().stream().sorted().toList();
    }

    public int countPhones(String surname) {
        return phoneBook.getOrDefault(surname, Collections.emptyList()).size();
    }

    public List<String> getSurrnamesSortedByPhones() {
        return phoneBook.entrySet().stream().sorted((a, b) -> Integer.compare(b.getValue().size(), a.getValue().size())).map(Map.Entry::getKey).toList();
    }

    public void merge(PhoneBook2 other) {
        for (Map.Entry<String, List<String>> entry : other.phoneBook.entrySet()) {
            phoneBook.merge(entry.getKey(), entry.getValue(), (oldSet, newSet) -> {
                oldSet.addAll(newSet);
                return oldSet;
            });
        }
    }


}