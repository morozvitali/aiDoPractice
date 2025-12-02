🔥 10 простих, реальних кейсів рефлексії в Java
1. Отримання назв полів для логування / дебагу

Теорія: рефлексія дозволяє отримати список полів класу та їх значення під час виконання.
Завдання: Напиши метод printFields(Object o), який виводить усі поля та їх поточні значення.

### ✅ Вивести назви полів та значення
public static void printFields(Object o) throws Exception {
Class<?> cls = o.getClass();
for (var field : cls.getDeclaredFields()) {
field.setAccessible(true);
System.out.println(field.getName() + " = " + field.get(o));
}
}


### 2. Автоматичне створення екземпляра класу

Теорія: через Class.newInstance() або getDeclaredConstructor().newInstance() можна створювати об’єкти без явного new.
Завдання: Написати фабрику Object create(String className).

✅ Створення об’єкта за назвою класу
public static Object create(String className) throws Exception {
Class<?> cls = Class.forName(className);
return cls.getDeclaredConstructor().newInstance();
}

3. Виклик приватного методу

Теорія: можна отримати навіть private-метод через getDeclaredMethod(...) і зробити setAccessible(true).
Завдання: Викликай приватний метод secret() у класі User.

✅ Виклик приватного методу
public static void callSecret(Object o) throws Exception {
var method = o.getClass().getDeclaredMethod("secret");
method.setAccessible(true);
method.invoke(o);
}

4. Читання приватного поля (навіть без геттера)

Теорія: доступ до полів усіх модифікаторів через setAccessible(true).
Завдання: Отримай значення приватного поля password у класі Account.

✅ Отримання приватного поля
public static Object readPrivate(Object o, String fieldName) throws Exception {
var field = o.getClass().getDeclaredField(fieldName);
field.setAccessible(true);
return field.get(o);
}


5. Валідація полів через анотації

Теорія: рефлексія читає анотації на класах/полях і дозволяє будувати свої маленькі Валідатори.
Завдання: Створи анотацію @NotEmpty і валідатор, що перевіряє поля з нею.

✅ Проста валідація через анотації
Анотація:
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface NotEmpty {}

Валідатор:
public static void validate(Object o) throws Exception {
for (var field : o.getClass().getDeclaredFields()) {
if (field.isAnnotationPresent(NotEmpty.class)) {
field.setAccessible(true);
Object value = field.get(o);
if (value == null || value.toString().isEmpty()) {
throw new RuntimeException("Field " + field.getName() + " is empty!");
}
}
}
}


6. Автоматичне мапування JSON → об’єкт

Теорія: Jackson / Gson під капотом використовують рефлексію, щоб створювати об’єкти та заповнювати поля.
Завдання: Спробуй написати міні-метод fill(Object o, Map<String,Object> values).

✅ Заповнення полів з Map
public static void fill(Object o, Map<String, Object> values) throws Exception {
Class<?> cls = o.getClass();
for (var entry : values.entrySet()) {
try {
var field = cls.getDeclaredField(entry.getKey());
field.setAccessible(true);
field.set(o, entry.getValue());
} catch (NoSuchFieldException ignored) {}
}
}

7. Сканування методів класу (наприклад, для тестового фреймворку)

Теорія: можна знайти всі методи з певною анотацією (як @Test в JUnit).
Завдання: Напиши код, що викликає всі методи з анотацією @RunMe.


✅ Виклик усіх методів з анотацією @RunMe
Анотація:
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface RunMe {}

Виконавець:
public static void runTests(Object o) throws Exception {
for (var method : o.getClass().getDeclaredMethods()) {
if (method.isAnnotationPresent(RunMe.class)) {
method.setAccessible(true);
method.invoke(o);
}
}
}

### 8. Завантаження класів за ім’ям (плагін-система)

Теорія: ClassLoader + reflection дозволяють підключати модулі під час роботи програми.
Завдання: Створи інтерфейс Plugin і завантаж клас за ім’ям "my.plugins.PrintPlugin".

✅ Завантаження класу-плагіну за ім’ям
public static void loadPlugin(String className) throws Exception {
Class<?> cls = Class.forName(className);
Object plugin = cls.getDeclaredConstructor().newInstance();
cls.getMethod("execute").invoke(plugin);
}

### 9. Перевірка типів у runtime

Теорія: через Class-API можна перевірити, чи об’єкт реалізує певний інтерфейс.
Завдання: Метод boolean supports(Object o, String interfaceName).

✅ Перевірити, чи реалізує об’єкт певний інтерфейс
        public static boolean supports(Object o, String iface) throws Exception {
        Class<?> cls = o.getClass();
            Class<?> target = Class.forName(iface);
            for (var i : cls.getInterfaces()) {
                if (i.equals(target)) return true;
            }
            return false;
        }

### 10. Створення універсального toString()

Теорія: рефлексія дозволяє згенерувати toString навіть без Lombok.
Завдання: Напиши String autoToString(Object o) — проходиш по полям і формуєш рядок.

✅ Автоматичний toString() через reflection
public static String autoToString(Object o) throws Exception {
StringBuilder sb = new StringBuilder(o.getClass().getSimpleName() + "{");
for (var field : o.getClass().getDeclaredFields()) {
field.setAccessible(true);
sb.append(field.getName())
.append("=")
.append(field.get(o))
.append(", ");
}
if (sb.length() > 2)
sb.setLength(sb.length() - 2);
sb.append("}");
return sb.toString();
}

------------------------------------------------------

🔥 1. Виведення полів і значень
Умова:

Є клас:

class Person {
private String name = "Bob";
private int age = 25;
}


Створи метод debug(Object o), який виведе:
name = Bob
age = 25

Підказка

Використай getDeclaredFields() та setAccessible(true).

Рішення
public static void debug(Object o) throws Exception {
for (var field : o.getClass().getDeclaredFields()) {
field.setAccessible(true);
System.out.println(field.getName() + " = " + field.get(o));
}
}

🔥 2. Створення об’єкта за назвою класу
Умова:

Створи метод:
Object create(String className)
який повертає об’єкт класу за його повним ім’ям.

Підказка

Class.forName(...)

Рішення
public static Object create(String className) throws Exception {
return Class.forName(className).getDeclaredConstructor().newInstance();
}

🔥 3. Виклик приватного методу
Умова:

Є:

class User {
private void hello() {
System.out.println("Hi!");
}
}


Виклич метод hello().

Підказка

Знайди метод через getDeclaredMethod.

Рішення
public static void callHello(Object o) throws Exception {
var m = o.getClass().getDeclaredMethod("hello");
m.setAccessible(true);
m.invoke(o);
}

🔥 4. Читання приватного поля
Умова:

Є:

class Account {
private String token = "XYZ123";
}


Отримай значення token.

Підказка

getDeclaredField

Рішення
public static Object read(Object o, String name) throws Exception {
var f = o.getClass().getDeclaredField(name);
f.setAccessible(true);
return f.get(o);
}

🔥 5. Валідація @NotEmpty
Умова:

Є клас:

class Product {
@NotEmpty
private String title;
}


Створи метод, що кидає помилку, якщо поле пусте або null.

Підказка

Перевірка: value == null || value.toString().isEmpty().

Рішення
public static void validate(Object o) throws Exception {
for (var f : o.getClass().getDeclaredFields()) {
if (f.isAnnotationPresent(NotEmpty.class)) {
f.setAccessible(true);
Object val = f.get(o);
if (val == null || val.toString().isEmpty()) {
throw new RuntimeException("Invalid: " + f.getName());
}
}
}
}

🔥 6. Заповнення об’єкта полями з Map
Умова:

Заповнити:

class Car {
private String brand;
private int year;
}


Даними з Map.of("brand","BMW","year",2020).

Підказка

Перебери ключі map → шукай поле → став значення.

Рішення
public static void fill(Object o, Map<String,Object> map) throws Exception {
for (var e : map.entrySet()) {
try {
var f = o.getClass().getDeclaredField(e.getKey());
f.setAccessible(true);
f.set(o, e.getValue());
} catch (NoSuchFieldException ignore) {}
}
}

🔥 7. Виклик методів з @RunMe
Умова:

Є клас:

class Tester {
@RunMe void a() { System.out.println("A"); }
@RunMe void b() { System.out.println("B"); }
void c() {}
}


Виклич тільки ті, що мають @RunMe.

Підказка

Метод має анотацію → method.invoke.

Рішення
public static void runAll(Object o) throws Exception {
for (var m : o.getClass().getDeclaredMethods()) {
if (m.isAnnotationPresent(RunMe.class)) {
m.setAccessible(true);
m.invoke(o);
}
}
}

🔥 8. Завантаження плагіну
Умова:

Є клас з методом execute()
(ім’я класу дається як String).

Створи метод, який його викличе.

Підказка

Class.forName → newInstance → getMethod("execute").invoke

Рішення
public static void loadAndRun(String className) throws Exception {
Class<?> cls = Class.forName(className);
Object obj = cls.getDeclaredConstructor().newInstance();
cls.getMethod("execute").invoke(obj);
}

🔥 9. Перевірити інтерфейс
Умова:

Є об’єкт і назва інтерфейсу:
"java.util.List"

Напиши метод, який поверне true/false.

Підказка

Перебери getInterfaces().

Рішення
public static boolean supports(Object o, String iface) throws Exception {
Class<?> target = Class.forName(iface);
for (var i : o.getClass().getInterfaces()) {
if (i.equals(target)) return true;
}
return false;
}

🔥 10. Автоматичний toString()
Умова:

Згенеруй toString для класу:

class Point {
private int x = 5;
private int y = 7;
}


Результат:
Point{x=5, y=7}

Підказка

StringBuilder + назва класу + поля.

Рішення
public static String autoToString(Object o) throws Exception {
StringBuilder sb = new StringBuilder(o.getClass().getSimpleName() + "{");
for (var f : o.getClass().getDeclaredFields()) {
f.setAccessible(true);
sb.append(f.getName()).append("=").append(f.get(o)).append(", ");
}
sb.setLength(sb.length() - 2);
sb.append("}");
return sb.toString();
}



------------------------------------------------------------

🔥 1. Reflection-Mapper: копіювання однакових полів між двома об’єктами
Умова:

Створи метод:

copy(Object source, Object target)


який копіює значення полів з source → target, якщо назви й типи збігаються.

Підказка

Використай два набори полів, зістав їх за ім’ям.

Рішення
public static void copy(Object src, Object trg) throws Exception {
var srcFields = src.getClass().getDeclaredFields();
var trgCls = trg.getClass();

    for (var f : srcFields) {
        try {
            var targetField = trgCls.getDeclaredField(f.getName());
            if (targetField.getType().equals(f.getType())) {
                f.setAccessible(true);
                targetField.setAccessible(true);
                targetField.set(trg, f.get(src));
            }
        } catch (NoSuchFieldException ignore) {}
    }
}

🔥 2. Автоматичний DTO Builder
Умова:

Є Entity:

class User {
private String name;
private int age;
}


Є DTO:

class UserDto {
private String name;
}


Створи метод:
<T> T toDto(Object entity, Class<T> dtoClass)
який заповнює DTO тільки полями, які існують в DTO.

Підказка

Перебираєш поля DTO → шукаєш поле в entity → копіюєш.

Рішення
public static <T> T toDto(Object entity, Class<T> dtoCls) throws Exception {
T dto = dtoCls.getDeclaredConstructor().newInstance();

    for (var dtoField : dtoCls.getDeclaredFields()) {
        try {
            var entField = entity.getClass().getDeclaredField(dtoField.getName());
            entField.setAccessible(true);
            dtoField.setAccessible(true);
            dtoField.set(dto, entField.get(entity));
        } catch (NoSuchFieldException ignore) {}
    }
    return dto;
}

🔥 3. Проста реалізація @Autowired
Умова:

Зроби свою версію DI:

class ServiceA { }

class ServiceB {
@Inject
private ServiceA a;
}


Метод inject(Object o) повинен знайти усі поля з @Inject і створити для них об’єкти.

Підказка

Тут ти робиш "міні-Spring".

Рішення
public static void inject(Object o) throws Exception {
for (var f : o.getClass().getDeclaredFields()) {
if (f.isAnnotationPresent(Inject.class)) {
f.setAccessible(true);
var instance = f.getType().getDeclaredConstructor().newInstance();
f.set(o, instance);
}
}
}

🔥 4. Анотація @MinLength(n) — валідація рядків
Умова:

Створи анотацію:

@MinLength(5)
private String username;


Перевіряй, що username не коротший за 5.

Підказка

Отримай параметр анотації: f.getAnnotation(MinLength.class).value().

Рішення
public static void validate(Object o) throws Exception {
for (var f : o.getClass().getDeclaredFields()) {
if (f.isAnnotationPresent(MinLength.class)) {
f.setAccessible(true);
String val = (String) f.get(o);
int min = f.getAnnotation(MinLength.class).value();
if (val == null || val.length() < min)
throw new RuntimeException(f.getName() + " too short");
}
}
}

🔥 5. Проста ORM-логіка: відобразити поля в SQL INSERT
Умова:

Є:

class Product {
private String title;
private int price;
}


Створи метод:

String toInsertSql(Object o)


Результат:

INSERT INTO Product(title,price) VALUES('Book', 100)

Підказка

Назва таблиці = назва класу.

Рішення
public static String toInsertSql(Object o) throws Exception {
StringBuilder names = new StringBuilder();
StringBuilder vals = new StringBuilder();

    for (var f : o.getClass().getDeclaredFields()) {
        f.setAccessible(true);
        names.append(f.getName()).append(",");
        Object v = f.get(o);
        vals.append(v instanceof String ? "'" + v + "'" : v).append(",");
    }
    names.setLength(names.length() - 1);
    vals.setLength(vals.length() - 1);

    return "INSERT INTO " + o.getClass().getSimpleName() +
           "(" + names + ") VALUES(" + vals + ")";
}

🔥 6. Логування змін полів (oldValue → newValue)
Умова:

Метод logChanges(before, after) повинен вивести тільки ті поля, які змінилися.

Підказка

Порівнюй значення по кожному полю через reflection.

Рішення
public static void logChanges(Object oldObj, Object newObj) throws Exception {
for (var f : oldObj.getClass().getDeclaredFields()) {
f.setAccessible(true);
Object oldV = f.get(oldObj);
Object newV = f.get(newObj);
if ((oldV == null && newV != null) ||
(oldV != null && !oldV.equals(newV))) {
System.out.println(f.getName() + ": " + oldV + " → " + newV);
}
}
}

🔥 7. Метод, що викликає всі публічні методи без параметрів
Умова:

Написати метод:

runNoArgs(Object o)


який викликає всі public-методи з 0 параметрами.

Підказка

Перевір методом getParameterCount().

Рішення
public static void runNoArgs(Object o) throws Exception {
for (var m : o.getClass().getMethods()) {
if (m.getParameterCount() == 0) {
m.invoke(o);
}
}
}

🔥 8. Перевірка, чи клас має конструктор певного типу
Умова:

Створи метод:

boolean hasConstructor(Class<?> cls, Class<?>... params)


який повертає true, якщо такий конструктор існує.

Підказка

cls.getDeclaredConstructor(parameters).

Рішення
public static boolean hasConstructor(Class<?> cls, Class<?>... params) {
try {
cls.getDeclaredConstructor(params);
return true;
} catch (NoSuchMethodException e) {
return false;
}
}

🔥 9. Створення JSON без бібліотек
Умова:

Створи метод:

String toJson(Object o)


який повертає JSON зі значень полів.

Підказка

Подібно до toString, але формат JSON.

Рішення
public static String toJson(Object o) throws Exception {
StringBuilder sb = new StringBuilder("{");
for (var f : o.getClass().getDeclaredFields()) {
f.setAccessible(true);
sb.append("\"")
.append(f.getName())
.append("\":");

        Object v = f.get(o);
        if (v instanceof String)
            sb.append("\"").append(v).append("\"");
        else
            sb.append(v);

        sb.append(",");
    }
    sb.setLength(sb.length() - 1);
    sb.append("}");
    return sb.toString();
}

🔥 10. Простий метод Benchmark через анотацію @MeasureTime
Умова:

Метод:

@MeasureTime
void work() { ... }


має автоматично друкувати час виконання.

Підказка

Заміряй час перед invoke й після.

Рішення
public static void runWithTime(Object o) throws Exception {
for (var m : o.getClass().getDeclaredMethods()) {
if (m.isAnnotationPresent(MeasureTime.class)) {
long start = System.nanoTime();
m.setAccessible(true);
m.invoke(o);
long end = System.nanoTime();
System.out.println(m.getName() + " took " + (end - start) + " ns");
}
}
}


### ---------------------------PRO SPRING----------------------------------

🧩 1. Імітація роботи Spring: пошук усіх класів з @Component
Умова:

Створи метод:

List<Class<?>> scanComponents(String packageName)


який знаходить усі класи в пакеті з анотацією @Component.

Пояснення

Spring робить це, коли запускає ComponentScan.

Рішення (спрощене)
public static List<Class<?>> scanComponents(String pkg) throws Exception {
    List<Class<?>> result = new ArrayList<>();

    var loader = Thread.currentThread().getContextClassLoader();
    var path = pkg.replace('.', '/');
    var resources = loader.getResources(path);

    while (resources.hasMoreElements()) {
        var url = resources.nextElement();
        var dir = new File(url.toURI());

        for (var file : dir.listFiles(f -> f.getName().endsWith(".class"))) {
            String className = pkg + "." + file.getName().replace(".class", "");
            Class<?> cls = Class.forName(className);

            if (cls.isAnnotationPresent(Component.class))
                result.add(cls);
        }
    }
    return result;
}

🧩 2. Створення IoC-контейнера: інстанси для @Component класів
Умова:

Скани компоненти → створи об’єкти → поклади в Map.

Map<Class<?>, Object> context = new HashMap<>();

Пояснення

Це модель Spring ApplicationContext.

Рішення
public static Map<Class<?>, Object> createContext(List<Class<?>> components) throws Exception {
Map<Class<?>, Object> context = new HashMap<>();

    for (var cls : components) {
        context.put(cls, cls.getDeclaredConstructor().newInstance());
    }
    return context;
}

🧩 3. Імітація @Autowired: ін’ єкція залежностей
Умова:

Поле з:

@Autowired
private ServiceA a;


має отримати об’єкт із контексту.

Пояснення

Spring шукає по типу.

Рішення
public static void autowire(Object bean, Map<Class<?>, Object> ctx) throws Exception {
for (var f : bean.getClass().getDeclaredFields()) {
if (f.isAnnotationPresentAutowired)) {
f.setAccessible(true);
Object dep = ctx.get(f.getType());
f.set(bean, dep);
}
}
}

🧩 4. @PostConstruct: виклик ініціалізаційних методів
Умова:

Після створення бінів викликати всі методи з @PostConstruct.

Рішення
public static void callPostConstruct(Object bean) throws Exception {
for (var m : bean.getClass().getDeclaredMethods()) {
if (m.isAnnotationPresent(PostConstruct.class)) {
m.setAccessible(true);
m.invoke(bean);
}
}
}

🧩 5. AOP-перехоплення методів через Proxy (як @Transactional)
Умова:

Створи динамічний proxy, що логуватиме виклик методів.

Пояснення

Spring AOP працює на Dynamic Proxy або CGLIB.

Рішення
public static <T> T createLoggingProxy(T target) {
return (T) Proxy.newProxyInstance(
target.getClass().getClassLoader(),
target.getClass().getInterfaces(),
(proxy, method, args) -> {
System.out.println("Calling: " + method.getName());
return method.invoke(target, args);
}
);
}

🧩 6. Імітація Hibernate: читання @Column → створення SQL
Умова:

Клас:

class User {
@Column(name="user_name")
private String name;
}


Згенерувати:

INSERT INTO User (user_name) VALUES ('Bob')

Рішення
public static String buildInsert(Object o) throws Exception {
StringBuilder cols = new StringBuilder();
StringBuilder vals = new StringBuilder();

    for (var f : o.getClass().getDeclaredFields()) {
        f.setAccessible(true);

        String col = f.isAnnotationPresent(Column.class)
                ? f.getAnnotation(Column.class).name()
                : f.getName();

        cols.append(col).append(",");
        Object v = f.get(o);
        vals.append("'").append(v).append("'").append(",");
    }
    cols.setLength(cols.length() - 1);
    vals.setLength(vals.length() - 1);

    return "INSERT INTO " + o.getClass().getSimpleName() +
           " (" + cols + ") VALUES (" + vals + ")";
}

🧩 7. Анотація @Transactional — логіка навколо методу
Умова:

Метод з @Transactional має бути обгорнений у:

begin();
method.invoke();
commit();

Рішення
public static Object invokeTransactional(Object bean, String methodName) throws Exception {
var m = bean.getClass().getMethod(methodName);

    if (m.isAnnotationPresent(Transactional.class)) {
        System.out.println("Begin transaction");
        Object result = m.invoke(bean);
        System.out.println("Commit");
        return result;
    }

    return m.invoke(bean);
}

🧩 8. Обхід циклічних залежностей (як Spring робить detect)
Умова:

Написати метод:

boolean hasCircularDependency(Class<?> start, Map<Class<?>, List<Class<?>>> deps)


де deps — список залежностей бінів.

Пояснення

Spring кидає BeanCurrentlyInCreationException.

Рішення (DFS)
public static boolean hasCircular(Class<?> start, Map<Class<?>, List<Class<?>>> deps, Set<Class<?>> visited) {
if (!deps.containsKey(start)) return false;

    for (var dep : deps.get(start)) {
        if (visited.contains(dep)) return true;
        visited.add(dep);
        if (hasCircular(dep, deps, visited)) return true;
        visited.remove(dep);
    }
    return false;
}

🧩 9. Читання @Value("${...}") і заміна на значення
Умова:

Поле:

@Value("${db.url}")
private String url;


має отримати значення з Map:

config.get("db.url")

Рішення
public static void injectValues(Object bean, Map<String,String> config) throws Exception {
for (var f : bean.getClass().getDeclaredFields()) {
if (f.isAnnotationPresent(Value.class)) {
String key = f.getAnnotation(Value.class).value();
key = key.substring(2, key.length() - 1); // "db.url"
f.setAccessible(true);
f.set(bean, config.get(key));
}
}
}

🧩 10. Bootstrapping REST-контролера: побудувати мапу endpoint → метод
Умова:

Є:

@RestController
class UserController {
@Get("/users")
public List<User> findAll() { ... }
}


Створи Map:

"/users" → метод findAll()

Рішення
public static Map<String, Method> buildRoutes(Object controller) {
Map<String, Method> routes = new HashMap<>();

    for (var m : controller.getClass().getDeclaredMethods()) {
        if (m.isAnnotationPresent(Get.class)) {
            String path = m.getAnnotation(Get.class).value();
            routes.put(path, m);
        }
    }
    return routes;
}

### --------------------------ДАЛІ БІЛЬШЕ!----------------------------------
https://chatgpt.com/g/g-p-68e8fbae40bc819189c46e34e72bb031-java-mentor/c/6929826d-996c-8333-92e1-68ceb95044c2