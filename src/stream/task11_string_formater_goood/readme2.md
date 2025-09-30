🔹 Завдання 1: Список товарів і цін

Умова:
Створіть клас ProductCatalog, який зберігає назви товарів і їхні ціни (Map<String, Double>).
Метод addProduct(name, price) додає товар, а метод getPrice(name) повертає його ціну.
Додайте метод getAllProductsSorted(), який повертає всі товари відсортовані за ціною.

Підказка:

Використовуйте entrySet() і sorted(Comparator.comparingDouble(...)).

Теорія:

Map не гарантує порядок. Якщо треба сортувати — робимо це вручну через Stream або TreeMap.

Приклад коду:

class ProductCatalog {
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
}

🔹 Завдання 2: Підрахунок слів у тексті

Умова:
Напишіть метод, який приймає рядок тексту та повертає Map<String, Integer> — кількість входжень кожного слова.

Підказка:

Використовуйте getOrDefault(key, 0) для підрахунку.

Теорія:

Map часто застосовують як лічильник.

Приклад коду:

public static Map<String, Integer> countWords(String text) {
Map<String, Integer> wordCount = new HashMap<>();
for (String word : text.toLowerCase().split("\\W+")) {
wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
}
return wordCount;
}

🔹 Завдання 3: Студенти і їхні оцінки
Умова:
Створіть Map<String, List<Integer>>, де ключ — це ім’я студента, а значення — список його оцінок.
Зробіть метод getAverage(name), який повертає середню оцінку студента.

Підказка:
Значення в Map може бути колекцією.
Приклад коду:
class GradeBook {
private Map<String, List<Integer>> grades = new HashMap<>();

    public void addGrade(String student, int grade) {
        grades.computeIfAbsent(student, k -> new ArrayList<>()).add(grade);
    }

    public double getAverage(String student) {
        return grades.getOrDefault(student, List.of())
                     .stream().mapToInt(i -> i).average().orElse(0);
    }
}

🔹 Завдання 4: Телефонний довідник із сортуванням

Умова:
Реалізуйте довідник на TreeMap<String, String>, де зберігаються імена у відсортованому вигляді.
Метод getAll() має повертати список у алфавітному порядку.

Теорія:

TreeMap автоматично підтримує сортування ключів.

🔹 Завдання 5: Кількість замовлень по містах
Умова:
Є список замовлень із містами (List<String>). Порахуйте, скільки замовлень з кожного міста, і виведіть топ-3 міста за кількістю.
Теорія:
Використовуємо Collectors.groupingBy() із counting().
Приклад коду:

    Map<String, Long> cityStats = orders.stream()
    .collect(Collectors.groupingBy(city -> city, Collectors.counting()));
    
    cityStats.entrySet().stream()
    .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
    .limit(3)
    .forEach(System.out::println);

🔹 Завдання 6: Унікальні слова

Умова:
Дано текст. Знайдіть усі слова, які зустрічаються рівно один раз.

Теорія:

Добре поєднується Map + stream().filter().

🔹 Завдання 7: Конвертація списку в Map

Умова:
Є список рядків: ["apple=100", "banana=200"]. Створіть метод, який перетворює його в Map<String, Integer>.

🔹 Завдання 8: Групування за першою літерою

Умова:
Дано список імен. Зробіть Map<Character, List<String>>, де ключ — перша літера, а значення — імена.

🔹 Завдання 9: Топові товари

Умова:
Є Map<String, Integer> (товар → кількість продажів). Знайдіть товар з найбільшою кількістю продажів.

🔹 Завдання 10: Перевернута мапа

Умова:
Є Map<String, String> (логін → email). Побудуйте зворотну мапу (email → логін).
Якщо кілька логінів мають один email — зберігайте список логінів.

Хочете, я кожне з цих завдань розпишу так само детально, як ми робили з телефонним довідником — з підказкою, теорією й готовим прикладом коду?

You said:
а 6-10? Ти просто монстр)) Я маю на увазі невимовно крута у створенні цих прикладів
ChatGPT said:

😅 Дякую, Пане Віталій, дуже приємно таке чути!
Добре, давайте тоді я розпишу завдання 6–10 у деталях, так само як попередні: буде умова → підказка → теорія → приклад коду.

🔹 Завдання 6: Унікальні слова

Умова:
Дано текст. Знайдіть усі слова, які зустрічаються рівно один раз.

Підказка:

Використайте Map<String, Integer> для підрахунку.

Потім відфільтруйте лише ті, де значення == 1.

Теорія:
Це приклад задачі, де Map виступає лічильником. Також добре показує комбінацію Map + Stream API.

Приклад коду:

public static List<String> uniqueWords(String text) {
Map<String, Integer> freq = new HashMap<>();
for (String word : text.toLowerCase().split("\\W+")) {
freq.put(word, freq.getOrDefault(word, 0) + 1);
}
return freq.entrySet().stream()
.filter(e -> e.getValue() == 1)
.map(Map.Entry::getKey)
.toList();
}

🔹 Завдання 7: Конвертація списку в Map

Умова:
Є список рядків: ["apple=100", "banana=200"]. Створіть метод, який перетворює його в Map<String, Integer>.

Підказка:

Розділяйте рядки по "=" (split("=")).

Ключ → слово, значення → число (Integer.parseInt).

Теорія:
Часто дані приходять у вигляді тексту, і ми перетворюємо їх у Map. Це гарна практика парсингу.

Приклад коду:

public static Map<String, Integer> parseList(List<String> input) {
Map<String, Integer> map = new HashMap<>();
for (String line : input) {
String[] parts = line.split("=");
map.put(parts[0], Integer.parseInt(parts[1]));
}
return map;
}

🔹 Завдання 8: Групування за першою літерою

Умова:
Дано список імен. Зробіть Map<Character, List<String>>, де ключ — перша літера, а значення — список імен.

Підказка:

Використовуйте Collectors.groupingBy(...).

Ключем буде name.charAt(0).

Теорія:
Це типовий приклад групування: розбиваємо колекцію на підгрупи. У реальних задачах часто групують по даті, категорії чи іншій ознаці.

Приклад коду:

public static Map<Character, List<String>> groupByFirstLetter(List<String> names) {
return names.stream()
.collect(Collectors.groupingBy(name -> name.charAt(0)));
}

🔹 Завдання 9: Топові товари

Умова:
Є Map<String, Integer> (товар → кількість продажів). Знайдіть товар з найбільшою кількістю продажів.

Підказка:

Використайте max(Map.Entry.comparingByValue()).

Теорія:
Це приклад знаходження максимуму за значенням у Map. Дуже поширена операція.

Приклад коду:

public static String getTopProduct(Map<String, Integer> sales) {
return sales.entrySet().stream()
.max(Map.Entry.comparingByValue())
.map(Map.Entry::getKey)
.orElse("No products");
}

🔹 Завдання 10: Перевернута мапа

Умова:
Є Map<String, String> (логін → email). Побудуйте зворотну мапу (email → логін).
Якщо кілька логінів мають один email — зберігайте список логінів.

Підказка:

Використайте Collectors.groupingBy(...).

Значенням має бути List<String>.

Теорія:
Це показує, що Map не завжди "один до одного". Часто потрібно розгорнути мапу, і тоді доводиться працювати зі списками як значеннями.

Приклад коду:

public static Map<String, List<String>> invert(Map<String, String> loginToEmail) {
return loginToEmail.entrySet().stream()
.collect(Collectors.groupingBy(
Map.Entry::getValue,
Collectors.mapping(Map.Entry::getKey, Collectors.toList())
));
}


🔥 От тепер у нас є повна десятка прикладів — від телефонної книги до інвертованої мапи.
Це вже така хороша міні-бібліотека практики з Map.

Хочете, я складу для вас ще одну серію (11–15), але з LinkedHashMap, TreeMap і Multimap-патернами (типу "кілька значень на ключ")?

https://chatgpt.com/c/68da78b6-fab0-8322-8efe-7377240addb3