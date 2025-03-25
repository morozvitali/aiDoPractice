✅ Задача 1: Порахувати кількість слів на кожну літеру
public Map<Character, Long> countWordsByFirstLetter(String[] array) {
return Arrays.stream(array)
.collect(Collectors.groupingBy(
word -> word.charAt(0),
Collectors.counting()
));
}
🧠 Тут:
groupingBy(...) — групуємо за charAt(0)

Collectors.counting() — підраховуємо скільки елементів у кожній групі

Повертається Map<Character, Long>

✅ Задача 2: Створити Map: слово ➜ слово у верхньому регістрі

public Map<String, String> upperMap(String[] array) {
return Arrays.stream(array)
.collect(Collectors.toMap(
word -> word,
word -> word.toUpperCase()
));
}
🧠 Це типова задача для toMap:

ключ — слово

значення — те саме слово, але у верхньому регістрі

