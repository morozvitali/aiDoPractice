
**original class for List <String>**
-
import java.util.*;
public class PhoneBook2 {
private Map<String, List<String>> phoneBook = new HashMap<>();
public void add(String surname, String phone) {
phoneBook.computeIfAbsent(surname, k -> new ArrayList<>()).add(phone);
}
public List<String> get(String surname) {
return phoneBook.getOrDefault(surname, Collections.emptyList());
}
}



**1. Уникати дублювання номерів**

-
Завдання:
Зробіть так, щоб у телефонному довіднику у 
одного прізвища не зберігалися дублікати телефонів.

Підказка:
Замість List використовуйте Set.

Теорія:
Set – це колекція, яка не дозволяє зберігати однакові елементи. 
Якщо додати той самий номер ще раз, він проігнорується.

Приклад рішення:

import java.util.*;

public class PhoneBook {
private Map<String, Set<String>> phoneBook = new HashMap<>();

    public void add(String surname, String phone) {
        phoneBook.computeIfAbsent(surname, k -> new HashSet<>()).add(phone);
    }

    public Set<String> get(String surname) {
        return phoneBook.getOrDefault(surname, Collections.emptySet());
    }

    public static void main(String[] args) {
        PhoneBook pb = new PhoneBook();
        pb.add("Іваненко", "123");
        pb.add("Іваненко", "123");
        pb.add("Іваненко", "456");
        System.out.println(pb.get("Іваненко")); // [123, 456]
    }
}

2. Пошук за частиною прізвища

Завдання:
Зробіть метод, який повертає всіх абонентів, 
у кого прізвище починається з певних літер (наприклад, "Іва").

Підказка:
Пройдіться по всіх ключах Map і перевіряйте startsWith(...).

Теорія:
У Java метод String.startsWith(prefix) дозволяє перевірити, 
чи починається рядок із заданого префікса.

Приклад рішення:

public List<String> findByPrefix(String prefix) {
List<String> result = new ArrayList<>();
for (String surname : phoneBook.keySet()) {
if (surname.startsWith(prefix)) {
result.addAll(phoneBook.get(surname));
}
}
return result;
}

3. Видалення номера

Завдання:
Реалізуйте метод remove(String surname, String phone), 
який видаляє конкретний номер у конкретного прізвища.

Підказка:
Список чи множина мають метод remove.

Теорія:
При видаленні важливо перевіряти, чи існує ключ і номер.

Приклад рішення:

public void remove(String surname, String phone) {
if (phoneBook.containsKey(surname)) {
phoneBook.get(surname).remove(phone);
}
}

4. Пошук за номером

Завдання:
Реалізуйте метод findSurnameByPhone(String phone), 
який шукає прізвище за номером телефону.

Підказка:
Доведеться пройтись по всіх записах Map.

Теорія:
entrySet() дозволяє працювати і з ключами, і зі значеннями.

Приклад рішення:

public List<String> findSurnameByPhone(String phone) {
List<String> result = new ArrayList<>();
for (Map.Entry<String, List<String>> entry : phoneBook.entrySet()) {
if (entry.getValue().contains(phone)) {
result.add(entry.getKey());
}
}
return result;
}

5. Сортування прізвищ

Завдання:
Виведіть усі прізвища у відсортованому вигляді.

Підказка:
Використовуйте TreeSet або stream().sorted().

Теорія:
У TreeSet ключі зберігаються у відсортованому порядку.

Приклад рішення:

public List<String> getAllSurnamesSorted() {
return phoneBook.keySet().stream()
.sorted()
.toList();
}

6. Підрахунок кількості номерів

Завдання:
Зробіть метод countPhones(String surname), 
який повертає кількість телефонів у людини.

Підказка:
Використовуйте size().

Теорія:
Метод size() повертає кількість елементів у колекції.

Приклад рішення:

public int countPhones(String surname) {
return phoneBook.getOrDefault(surname, Collections.emptySet()).size();
}

7. Телефонний довідник із сортуванням за кількістю номерів

Завдання:
Зробіть метод, який повертає список усіх прізвищ, 
відсортованих за кількістю номерів (від найбільшої кількості до найменшої).

Підказка:
Використовуйте stream().sorted() із власним компаратором.

Теорія:
Comparator.comparingInt(...).reversed() дозволяє 
сортувати за числовими значеннями у зворотному порядку.

Приклад рішення:

public List<String> getSurnamesSortedByPhones() {
return phoneBook.entrySet().stream()
.sorted((a, b) -> Integer.compare(b.getValue().size(), a.getValue().size()))
.map(Map.Entry::getKey)
.toList();
}

8. Телефонний довідник із декількома джерелами

Завдання:
Об’єднайте два телефонні довідники в один.

Підказка:
Проходьте по ключах другого довідника і додавайте в перший.

Теорія:
Метод putAll працює лише з простими значеннями, тут треба merge.

Приклад рішення:

public void merge(PhoneBook other) {
for (Map.Entry<String, Set<String>> entry : other.phoneBook.entrySet()) {
phoneBook.merge(entry.getKey(), entry.getValue(),
(oldSet, newSet) -> { oldSet.addAll(newSet); return oldSet; });
}
}

9. Експорт у текстовий файл

Завдання:
Зробіть метод exportToFile(String fileName), 
який записує весь довідник у текстовий файл.

Підказка:
Використайте BufferedWriter.

Теорія:
Вивід у файл робиться так само, як у консоль, 
тільки замість System.out використовується Writer.

Приклад рішення:

import java.io.*;

public void exportToFile(String fileName) throws IOException {
try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
for (Map.Entry<String, Set<String>> entry : phoneBook.entrySet()) {
writer.write(entry.getKey() + " -> " + entry.getValue());
writer.newLine();
}
}
}

10. Імпорт із текстового файлу

Завдання:
Зробіть метод importFromFile(String fileName), який читає файл 
(у форматі Прізвище -> [телефони]) і додає у довідник.

Підказка:
Використайте BufferedReader і split("->").

Теорія:
Метод split(regex) ділить рядок за заданим роздільником.

Приклад рішення:

public void importFromFile(String fileName) throws IOException {
try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
String line;
while ((line = reader.readLine()) != null) {
String[] parts = line.split("->");
if (parts.length == 2) {
String surname = parts[0].trim();
String phones = parts[1].replace("[", "").replace("]", "");
for (String phone : phones.split(",")) {
add(surname, phone.trim());
}
}
}
}
}


Пане Віталій, ці 10 завдань утворюють цілу міні-систему телефонного довідника – 
від простого збереження до сортувань, пошуків і навіть файлів 📚⚡

Хочете, щоб я оформила всі ці 10 завдань в один готовий клас із усіма методами
(щоб можна було одразу запускати і тестувати)?