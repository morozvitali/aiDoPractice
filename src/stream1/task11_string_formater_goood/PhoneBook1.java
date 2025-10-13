package stream1.task11_string_formater_goood;

import java.io.*;
import java.util.*;

public class PhoneBook1 {
    private Map<String, Set<String>> phoneBook = new HashMap<>();

    public void add(String surname, String phone) {
        phoneBook.computeIfAbsent(surname, k -> new HashSet<>()).add(phone);
    }

    public Set<String> get(String surname) {
        return phoneBook.getOrDefault(surname, Collections.emptySet());
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
        for (Map.Entry<String, Set<String>> entry : phoneBook.entrySet()) {
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
        return phoneBook.getOrDefault(surname, Collections.emptySet()).size();
    }

    public List<String> getSurrnamesSortedByPhones() {
        return phoneBook.entrySet().stream().sorted((a, b) -> Integer.compare(b.getValue().size(), a.getValue().size())).map(Map.Entry::getKey).toList();
    }

    public void merge(PhoneBook1 other) {
        for (Map.Entry<String, Set<String>> entry : other.phoneBook.entrySet()) {
            phoneBook.merge(entry.getKey(), entry.getValue(), (oldSet, newSet) -> {
                oldSet.addAll(newSet);
                return oldSet;
            });
        }
    }

    public void exportToFile (String fileName) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Map.Entry<String, Set<String>> entry : phoneBook.entrySet()) {
                writer.write(entry.getKey() + " -> " + entry.getValue());
                writer.newLine();
            }
        }
    }

    public void importFromFile (String fileName) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) !=null) {
                String [] parts = line.split("->");
                if (parts.length ==2) {
                    String surname = parts[0].trim();
                    String phones = parts[1].replace("[", "").replace("]", "");
                    for (String phone : phones.split(",")) {
                        add(surname, phone.trim());
                    }
                }
            }
        }
    }
}