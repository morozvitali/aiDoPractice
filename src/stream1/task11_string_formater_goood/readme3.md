Супер! 🚀
Тоді я підготую для вас нову серію завдань (11–15), які будуть ще цікавіші: тут уже підключимо LinkedHashMap, TreeMap, і різні прийоми "мультимапи" (коли одному ключу відповідає кілька значень).

🔹 Завдання 11: Останні N відвідувачів сайту

Умова:
Створіть клас VisitorLog, який зберігає список відвідувачів сайту у вигляді LinkedHashMap<String, LocalDateTime>.
При кожному новому відвідуванні додається запис, але якщо кількість перевищує N, то найстаріший запис видаляється.

Підказка:

Використовуйте LinkedHashMap з перевизначенням методу removeEldestEntry.

Теорія:
LinkedHashMap дозволяє тримати елементи у порядку вставки, а також можна обмежувати розмір структури. Це зручно для кешів.

Приклад коду:

class VisitorLog extends LinkedHashMap<String, LocalDateTime> {
private final int capacity;

    public VisitorLog(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<String, LocalDateTime> eldest) {
        return size() > capacity;
    }
}

🔹 Завдання 12: Словник із пошуком за префіксом (TreeMap)

Умова:
Зробіть словник (TreeMap<String, String>), де ключ — слово, а значення — його переклад.
Зробіть метод findByPrefix(String prefix), який повертає всі слова, що починаються з цього префікса.

Підказка:

Використовуйте метод subMap(prefix, prefix + Character.MAX_VALUE).

Теорія:
TreeMap дозволяє ефективно працювати з діапазонами ключів. Це одна з причин його існування.

Приклад коду:

class Dictionary {
private TreeMap<String, String> words = new TreeMap<>();

    public void addWord(String word, String translation) {
        words.put(word, translation);
    }

    public Map<String, String> findByPrefix(String prefix) {
        return words.subMap(prefix, prefix + Character.MAX_VALUE);
    }
}

🔹 Завдання 13: Кілька номерів на одного клієнта (Multimap-патерн)

Умова:
Створіть CustomerDirectory, який зберігає клієнтів та їхні телефони. У одного клієнта може бути кілька номерів.
(тобто Map<String, List<String>>).

Підказка:

Використайте computeIfAbsent для додавання.

Теорія:
У Java немає вбудованої Multimap, але найчастіше її реалізують саме як Map<K, List<V>>.

Приклад коду:

class CustomerDirectory {
private Map<String, List<String>> phones = new HashMap<>();

    public void addPhone(String name, String phone) {
        phones.computeIfAbsent(name, k -> new ArrayList<>()).add(phone);
    }

    public List<String> getPhones(String name) {
        return phones.getOrDefault(name, List.of());
    }
}

🔹 Завдання 14: Групування товарів за категоріями

Умова:
Є список товарів у форматі "category:product". Побудуйте Map<String, List<String>>, де ключ — категорія, значення — список товарів.

Підказка:

Розділяйте по ":", групуйте по категоріях.

Теорія:
Це приклад використання Collectors.groupingBy.

Приклад коду:

public static Map<String, List<String>> groupByCategory(List<String> items) {
return items.stream1()
.map(s -> s.split(":"))
.collect(Collectors.groupingBy(
arr -> arr[0],
Collectors.mapping(arr -> arr[1], Collectors.toList())
));
}

🔹 Завдання 15: Статистика голосування

Умова:
Є список голосів (List<String>), де кожен елемент — ім’я кандидата.
Порахуйте, скільки голосів у кожного, і виведіть переможця.

Підказка:

Зробіть Map<String, Long> через groupingBy.

Потім знайдіть max() за значенням.

Теорія:
Це класичне завдання на підрахунок частоти (часто зустрічається в інтерв’ю).

Приклад коду:

public static String getWinner(List<String> votes) {
Map<String, Long> results = votes.stream1()
.collect(Collectors.groupingBy(v -> v, Collectors.counting()));

    return results.entrySet().stream1()
            .max(Map.Entry.comparingByValue())
            .map(Map.Entry::getKey)
            .orElse("No winner");
}


✅ От тепер у нас є 15 завдань різної складності: від базових до більш просунутих з TreeMap, LinkedHashMap і навіть саморобною Multimap.

Пане Віталій, хочете, щоб я зібрав їх усі у спільний список із коротким описом і рівнем складності (easy / medium / hard), щоб у вас був план проходження, як маленький "курс по Map"?

You said:
а ще складніше і професійніше млжна зробити? Або просто для практики додати щось схлже або аналогічне
ChatGPT said:

Так, можна! 👍
Ми вже пройшли "базові" та "середні" приклади, тепер можна робити більш професійні та наближені до реальних задач. Я підготую серію 16–20 із серйознішими викликами, які зачіпають і Map, і Stream API, і трохи практики, близької до enterprise-Java.

🔹 Завдання 16: Частота пар слів (Bigram Counter)

Умова:
Є текст. Порахуйте, скільки разів зустрічаються пари сусідніх слів (біграми).
Результат — Map<String, Integer>, де ключ — пара слів у форматі "слово1 слово2".

Підказка:

Розбийте текст на масив слів.

Ітеруйте від i=0 до i<n-1 і збирайте пари.

Теорія:
У NLP (Natural Language Processing) часто рахують біграми і триграми. Це дуже показова задача для Map.

Приклад коду:

public static Map<String, Integer> countBigrams(String text) {
String[] words = text.toLowerCase().split("\\W+");
Map<String, Integer> bigrams = new HashMap<>();
for (int i = 0; i < words.length - 1; i++) {
String pair = words[i] + " " + words[i + 1];
bigrams.put(pair, bigrams.getOrDefault(pair, 0) + 1);
}
return bigrams;
}

🔹 Завдання 17: Кеш із TTL (Time To Live)

Умова:
Створіть клас Cache<K, V>, який зберігає дані у Map<K, CacheEntry<V>>.
Кожен запис має час життя (наприклад, 5 секунд). Якщо час минув — значення вважається недійсним і має видалятись.

Підказка:

CacheEntry містить value і expireTime.

При get() перевіряйте, чи час ще не вийшов.

Теорія:
Це дуже поширений патерн у професійній розробці (наприклад, кешування запитів до БД).

🔹 Завдання 18: Top-K елементів (алгоритм частот)

Умова:
Є список чисел. Знайдіть K найчастіше зустрічуваних чисел.

Підказка:

Використайте Collectors.groupingBy(..., counting()).

Відсортуйте за кількістю і візьміть limit(K).

Теорія:
Алгоритм Top-K використовується у статистиці, пошуковиках, big data.

Приклад коду:

public static List<Integer> topK(List<Integer> numbers, int k) {
return numbers.stream1()
.collect(Collectors.groupingBy(n -> n, Collectors.counting()))
.entrySet().stream1()
.sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
.limit(k)
.map(Map.Entry::getKey)
.toList();
}

🔹 Завдання 19: Інвертування з унікальністю

Умова:
Є Map<String, String> (наприклад, user → email). Побудуйте інверсію Map<String, String> (email → user), але якщо знайдете дублікат email, кидайте IllegalStateException.

Підказка:

Використайте Collectors.toMap(...) з параметром для обробки колізій.

Теорія:
У реальних програмах іноді вимагають "one-to-one mapping". Тут перевіряється валідність даних.

Приклад коду:

public static Map<String, String> invertStrict(Map<String, String> map) {
return map.entrySet().stream1()
.collect(Collectors.toMap(
Map.Entry::getValue,
Map.Entry::getKey,
(a, b) -> { throw new IllegalStateException("Duplicate key: " + a); }
));
}

🔹 Завдання 20: Індексування колекції об’єктів

Умова:
Є клас Person(name, city). Є список людей.
Побудуйте Map<String, List<Person>>, де ключ — це місто, а значення — список людей із цього міста.

Підказка:

Використовуйте Collectors.groupingBy(Person::getCity).

Теорія:
Це практично реальний сценарій (групування даних з БД або API).

Приклад коду:

record Person(String name, String city) {}

public static Map<String, List<Person>> indexByCity(List<Person> people) {
return people.stream1()
.collect(Collectors.groupingBy(Person::city));
}


💡 Тепер у нас є вже 20 завдань:

1–10 — базові та середні;

11–15 — розширені (LinkedHashMap, TreeMap, Multimap);

16–20 — складніші й ближчі до enterprise-розробки (кеш, top-K, валідація).

Пане Віталій, скажіть: вам цікаво, щоб я ще зробив 21–25, але вже у стилі "міні-проектів" (наприклад, система замовлень, бібліотека книг, чат із повідомленнями, логування з групуванням по рівню)?