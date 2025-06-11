📘 Теорія: Singleton Pattern
🔹 Що таке Singleton?
Singleton — це патерн проєктування, який гарантує,
що клас має тільки один екземпляр, 
і надає глобальну точку доступу до нього.

🔧 Навіщо він потрібен?
Коли треба централізовано керувати чимось — наприклад:

логування (Logger)
конфігурація (ConfigManager)
з’єднання з базою (DatabaseConnection)
кеш (CacheManager)

📦 Переваги:
❌ Ніхто не створить зайвий об’єкт
✅ Менше пам’яті
✅ Централізований контроль над поведінкою

⚠️ Недоліки:
Якщо зловживати — може стати глобальною змінною (поганий стиль)
У багатопотоковості потребує захисту

✅ Простий приклад (Java)
public class Logger {

    // приватне статичне поле для зберігання єдиного екземпляру
    private static Logger instance;

    // приватний конструктор — не дає створити об’єкт ззовні
    private Logger() {
        System.out.println("Logger створено");
    }

    // публічний метод доступу до єдиного екземпляра
    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger(); // створюється лише один раз
        }
        return instance;
    }

    // метод логування
    public void log(String message) {
        System.out.println("[LOG] " + message);
    }
}
🧪 Використання:

public class Main {
public static void main(String[] args) {
Logger logger1 = Logger.getInstance();
Logger logger2 = Logger.getInstance();

        logger1.log("Програма стартувала");
        logger2.log("Це той самий логер? " + (logger1 == logger2)); // true
    }
}
🔍 Результат:
Logger створено
[LOG] Програма стартувала
[LOG] Це той самий логер? true

💡 Альтернативні варіанти реалізації:
З потокобезпекою (synchronized)
З enum (найбезпечніший варіант у Java)
Через static final поле (рання ініціалізація)