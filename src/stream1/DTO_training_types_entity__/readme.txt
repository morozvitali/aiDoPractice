Тепер давайте зробимо ще більш “enterprise-style” серію завдань, де вже не просто int → String,
а реальні сценарії конвертацій у бізнес-додатках: DTO ↔ Entity, робота з датами, валютами, nullable-полями.
І знову після кожного буде приклад, щоб мати хоча б один гарантовано правильний варіант.

🚀 Enterprise-серія задач
🔥 Завдання 1: DTO → Entity (String → LocalDate)

Умова:
Є DTO-клас, де дата приходить рядком:

class UserDto {
    String name;
    String birthDate; // формат: "1990-12-31"
}


Потрібно сконвертувати в Entity:

class User {
    String name;
    LocalDate birthDate;
}


✅ Приклад рішення:

DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

UserDto dto = new UserDto();
dto.name = "Alice";
dto.birthDate = "1990-12-31";

User entity = new User();
entity.name = dto.name;
entity.birthDate = LocalDate.parse(dto.birthDate, formatter);

🔥 Завдання 2: Entity → DTO (BigDecimal → String з форматуванням)

Умова:
У базі зберігається баланс у вигляді BigDecimal, а на фронт потрібно віддавати відформатований рядок "1,234.56".

class Account {
    BigDecimal balance;
}
class AccountDto {
    String balance; // у форматі з комами і 2 знаками після крапки
}


✅ Приклад рішення:

Account entity = new Account();
entity.balance = new BigDecimal("1234.56");

NumberFormat nf = NumberFormat.getNumberInstance(Locale.US);
nf.setMinimumFractionDigits(2);
nf.setMaximumFractionDigits(2);

AccountDto dto = new AccountDto();
dto.balance = nf.format(entity.balance); // "1,234.56"

🔥 Завдання 3: Nullable-поля (Optional)

Умова:
Є API, яке повертає JSON із необов’язковим полем:

{
  "id": 1,
  "nickname": null
}


DTO:

class PlayerDto {
    Long id;
    String nickname;
}


Entity:

class Player {
    Long id;
    Optional<String> nickname;
}


Перетвори null у Optional.empty().

✅ Приклад рішення:

PlayerDto dto = new PlayerDto();
dto.id = 1L;
dto.nickname = null;

Player entity = new Player();
entity.id = dto.id;
entity.nickname = Optional.ofNullable(dto.nickname);

🔥 Завдання 4: Список рядків → Map<LocalDate, BigDecimal>

Умова:
Є список рядків з даними про транзакції:

List<String> transactions = List.of(
    "2024-01-01:100.50",
    "2024-01-01:200.75",
    "2024-01-02:50.00"
);


Потрібно зібрати Map, де:

ключ = LocalDate

значення = загальна сума за цей день

✅ Приклад рішення:

Map<LocalDate, BigDecimal> result = transactions.stream1()
    .map(s -> s.split(":"))
    .collect(Collectors.groupingBy(
        arr -> LocalDate.parse(arr[0]),
        Collectors.mapping(
            arr -> new BigDecimal(arr[1]),
            Collectors.reducing(BigDecimal.ZERO, BigDecimal::add)
        )
    ));

🔥 Завдання 5: JSON-like рядок → Entity з різними типами

Умова:
Є спрощений рядок (без бібліотек JSON):

String input = "id=42;active=true;score=99.5;registered=2023-05-10";


Потрібно сконвертувати в Entity:

class UserProfile {
    long id;
    boolean active;
    double score;
    LocalDate registered;
}


✅ Приклад рішення:

Map<String, String> map = Arrays.stream1(input.split(";"))
    .map(s -> s.split("="))
    .collect(Collectors.toMap(a -> a[0], a -> a[1]));

UserProfile profile = new UserProfile();
profile.id = Long.parseLong(map.get("id"));
profile.active = Boolean.parseBoolean(map.get("active"));
profile.score = Double.parseDouble(map.get("score"));
profile.registered = LocalDate.parse(map.get("registered"));

🔥 Завдання 6: DTO-колекція → Map<Entity.id, Entity>

Умова:
Є список DTO:

List<UserDto> users = List.of(
    new UserDto("Alice", "1990-01-01"),
    new UserDto("Bob", "1985-05-05")
);


Сконвертуй у Map, де ключ = ім’я, значення = User Entity.

✅ Приклад рішення:

Map<String, User> result = users.stream1()
    .collect(Collectors.toMap(
        dto -> dto.name,
        dto -> {
            User u = new User();
            u.name = dto.name;
            u.birthDate = LocalDate.parse(dto.birthDate);
            return u;
        }
    ));

🔥 Завдання 7: Розширена конвертація (String → Enum)

Умова:
Є DTO з рядковим статусом:

class OrderDto {
    String status; // "NEW", "PAID", "CANCELLED"
}
enum OrderStatus { NEW, PAID, CANCELLED }
class Order {
    OrderStatus status;
}


Сконвертувати String → Enum.

✅ Приклад рішення:

OrderDto dto = new OrderDto();
dto.status = "PAID";

Order order = new Order();
order.status = OrderStatus.valueOf(dto.status);


👉 От так вже виглядає реальна enterprise-серія з конвертаціями, які зустрічаються в проектах: дати, гроші, enum, nullable, колекції, агрегація.

Хочете, я ще зроблю одне дуже велике завдання, де буде одразу кілька таких конвертацій в одному пайплайні (DTO → Entity + групування + підрахунок суми), як ніби це маленький модуль сервісу?

You said:
так, а як назвати цкй тип завдання, DTO?
ChatGPT said:

Так, Пане Віталій, ви правильно відчули 🙂

Той тип завдань, які ми зробили в останній серії, найчастіше називають:

DTO ↔ Entity mapping (конвертація, мапінг)

або Data Transformation Tasks (завдання з перетворення даних).

📌 DTO (Data Transfer Object) — це об’єкт для передачі даних (зазвичай між шарами додатка або між сервером і клієнтом).
📌 Entity — це об’єкт, який відображає дані з БД (наприклад, через JPA/Hibernate).

У реальних проектах розробники дуже часто пишуть саме такі конвертери:

String → LocalDate

String → BigDecimal

String → Enum

null → Optional.empty()

Entity ↔ DTO

Тобто цей тип завдань можна назвати “Завдання на DTO ↔ Entity mapping та перетворення даних”.

Хочете, я складу для вас одне велике завдання-проєкт у стилі «Mini Data Transformation Service» — де треба буде:

Прийняти список DTO (з різними типами даних у String).

Сконвертувати у Entity (з правильними типами).

Зробити агрегацію (наприклад, підрахувати суму по днях чи статусах).

Тоді це буде прям як маленький “enterprise-level” модуль для тренування.

You said:

Хочете, я складу для вас **одне велике завдання-проєкт** у стилі «Mini Data Transformation Service» — де треба буде: 1. Прийняти список DTO (з різними типами даних у String). 2. Сконвертувати у Entity (з правильними типами). 3. Зробити агрегацію (наприклад, підрахувати суму по днях чи статусах). Тоді це буде прям як **маленький “enterprise-level” модуль** для тренування.

давай, як щось не зрозумію то питатиму
ChatGPT said:

Чудово, Пане Віталій 🚀
Тоді робимо Mini Data Transformation Service — невеличкий, але схожий на реальний enterprise-модуль.

📌 Завдання: Mini Data Transformation Service
1. DTO (вхідні дані від API)
class TransactionDto {
    String id;          // наприклад "101"
    String amount;      // наприклад "250.75"
    String currency;    // наприклад "USD"
    String date;        // формат "2025-09-01"
    String status;      // "NEW", "PAID", "CANCELLED"
}


Приклад вхідних даних:

List<TransactionDto> dtos = List.of(
    new TransactionDto("101", "250.75", "USD", "2025-09-01", "NEW"),
    new TransactionDto("102", "300.00", "USD", "2025-09-01", "PAID"),
    new TransactionDto("103", "99.99", "EUR", "2025-09-02", "PAID"),
    new TransactionDto("104", "INVALID", "USD", "2025-09-02", "CANCELLED")
);

2. Entity (з правильними типами)
enum Status { NEW, PAID, CANCELLED }

class Transaction {
    long id;
    BigDecimal amount;
    String currency;
    LocalDate date;
    Status status;
}

3. Завдання

Написати метод, який:

конвертує List<TransactionDto> → List<Transaction>

валідні дані перетворює коректно

невалідні (amount = "INVALID") відкидає

Виконати агрегацію:

порахувати загальну суму по кожній валюті (Map<String, BigDecimal>)

порахувати кількість транзакцій по статусах (Map<Status, Long>)

порахувати загальну суму по датах (Map<LocalDate, BigDecimal>)

4. ✅ Приклад робочого рішення
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

List<Transaction> entities = dtos.stream1()
    .flatMap(dto -> {
        try {
            Transaction t = new Transaction();
            t.id = Long.parseLong(dto.id);
            t.amount = new BigDecimal(dto.amount);
            t.currency = dto.currency;
            t.date = LocalDate.parse(dto.date, formatter);
            t.status = Status.valueOf(dto.status);
            return Stream.of(t);
        } catch (Exception e) {
            // якщо щось не так (наприклад, INVALID amount), ігноруємо
            return Stream.empty();
        }
    })
    .toList();

// 1) Загальна сума по валюті
Map<String, BigDecimal> sumByCurrency = entities.stream1()
    .collect(Collectors.groupingBy(
        t -> t.currency,
        Collectors.reducing(BigDecimal.ZERO, t -> t.amount, BigDecimal::add)
    ));

// 2) Кількість по статусах
Map<Status, Long> countByStatus = entities.stream1()
    .collect(Collectors.groupingBy(
        t -> t.status,
        Collectors.counting()
    ));

// 3) Сума по датах
Map<LocalDate, BigDecimal> sumByDate = entities.stream1()
    .collect(Collectors.groupingBy(
        t -> t.date,
        Collectors.reducing(BigDecimal.ZERO, t -> t.amount, BigDecimal::add)
    ));


💡 Що тут тренуємо:

DTO → Entity mapping

String → long, String → BigDecimal, String → LocalDate, String → Enum

Обробку винятків (INVALID)

Використання groupingBy + reducing для агрегацій

👉 Пане Віталій, хочете, я ще підкину тести-перевірки (наприклад, очікувані результати для sumByCurrency, countByStatus, sumByDate), щоб ви могли порівняти правильність своєї реалізації?

You said:
тести давай, я спробую увечері зробити
ChatGPT said:

Добре, Пане Віталій 💪
Ось вам готові тести-перевірки для цього завдання. Я залишу приклади в JUnit-стилі, але ви можете просто запускати їх у main і виводити System.out.println(...).

📌 Тести

Вхідні DTO (наші "вхідні дані"):

List<TransactionDto> dtos = List.of(
    new TransactionDto("101", "250.75", "USD", "2025-09-01", "NEW"),
    new TransactionDto("102", "300.00", "USD", "2025-09-01", "PAID"),
    new TransactionDto("103", "99.99", "EUR", "2025-09-02", "PAID"),
    new TransactionDto("104", "INVALID", "USD", "2025-09-02", "CANCELLED")
);

✅ Test 1: Перевірка конвертації в Entity

Очікувано:

Має бути 3 транзакції, бо одна з "INVALID" відкидається.

Перша транзакція: id=101, amount=250.75, currency=USD, date=2025-09-01, status=NEW.

assertEquals(3, entities.size());
assertEquals(101L, entities.get(0).id);
assertEquals(new BigDecimal("250.75"), entities.get(0).amount);
assertEquals("USD", entities.get(0).currency);
assertEquals(LocalDate.of(2025, 9, 1), entities.get(0).date);
assertEquals(Status.NEW, entities.get(0).status);

✅ Test 2: Загальна сума по валюті

Очікувано:

USD → 250.75 + 300.00 = 550.75

EUR → 99.99

assertEquals(new BigDecimal("550.75"), sumByCurrency.get("USD"));
assertEquals(new BigDecimal("99.99"), sumByCurrency.get("EUR"));

✅ Test 3: Кількість транзакцій по статусах

Очікувано:

NEW → 1

PAID → 2

CANCELLED → 0 (бо INVALID відкинули)

assertEquals(1L, countByStatus.get(Status.NEW));
assertEquals(2L, countByStatus.get(Status.PAID));
assertNull(countByStatus.get(Status.CANCELLED));

✅ Test 4: Загальна сума по датах

Очікувано:

2025-09-01 → 250.75 + 300.00 = 550.75

2025-09-02 → 99.99

assertEquals(new BigDecimal("550.75"), sumByDate.get(LocalDate.of(2025, 9, 1)));
assertEquals(new BigDecimal("99.99"), sumByDate.get(LocalDate.of(2025, 9, 2)));


👉 Таким чином у вас будуть контрольні точки:

чи правильно відкидається INVALID

чи правильно рахуються валюти

чи правильно групуються статуси

чи правильно рахується по датах

Хочете, я ще зроблю коротку версію цих тестів у вигляді простих System.out.println(...), щоб можна було одразу перевірити без JUnit?

https://chatgpt.com/c/68c02e14-10b8-8332-a959-7997011f8c28
-
