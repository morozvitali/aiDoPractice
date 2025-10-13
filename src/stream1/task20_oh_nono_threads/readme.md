🔧 Пропоную вам серію навчальних завдань «Основи потоків у Java»

Я розділив їх логічно, щоб кожне додавало щось нове:
(після кожного — приклад і пояснення, як воно працює)

🧩 Завдання 1. “Привіт із потоку”

Мета: навчитися створювати і запускати простий потік.

Умова:
Створіть метод startThreads(), який створює два потоки:

перший виводить 5 разів "Hello from Thread A"

другий — "Hello from Thread B"

Використайте клас Thread і метод start().

public class ThreadPractice1 {
public static void startThreads() {
Thread t1 = new Thread(() -> {
for (int i = 0; i < 5; i++) {
System.out.println("Hello from Thread A");
try { Thread.sleep(300); } catch (InterruptedException e) {}
}
});

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Hello from Thread B");
                try { Thread.sleep(300); } catch (InterruptedException e) {}
            }
        });

        t1.start();
        t2.start();
    }

    public static void main(String[] args) {
        startThreads();
    }
}


🧠 Що нового дізнаєтесь:

різниця між .start() і .run()

потоки виконуються одночасно, тому вивід буде перемішаний

Thread.sleep() — затримка в потоці

🧩 Завдання 2. “Обчислення у фоновому потоці”

Мета: створити потік, який обчислює суму чисел у масиві, поки головний потік виконує інше завдання.

Умова:
Є масив чисел. Порахуйте їхню суму у потоці SumThread, а у головному потоці виводьте крапки (.), поки обчислення не закінчиться.

public class ThreadPractice2 {
public static void calculateSum() {
int[] numbers = {1, 2, 3, 4, 5};
Thread sumThread = new Thread(() -> {
int sum = 0;
for (int n : numbers) {
sum += n;
try { Thread.sleep(200); } catch (InterruptedException e) {}
}
System.out.println("\nSum = " + sum);
});

        sumThread.start();

        while (sumThread.isAlive()) {
            System.out.print(".");
            try { Thread.sleep(150); } catch (InterruptedException e) {}
        }
    }

    public static void main(String[] args) {
        calculateSum();
    }
}


🧠 Що нового:

метод .isAlive() — перевіряє, чи ще триває потік

фонове виконання

як одночасно виконуються різні завдання

🧩 Завдання 3. “Іменовані потоки”

Мета: призначити імена потокам і подивитись, як вони з’являються у логах.

Умова:
Створіть три потоки з різними іменами (Worker-1, Worker-2, Worker-3)
і нехай кожен виводить "Працює: <ім’я потоку>" кілька разів.

public class ThreadPractice3 {
public static void startNamedThreads() {
for (int i = 1; i <= 3; i++) {
Thread t = new Thread(() -> {
for (int j = 0; j < 3; j++) {
System.out.println("Працює: " + Thread.currentThread().getName());
try { Thread.sleep(300); } catch (InterruptedException e) {}
}
}, "Worker-" + i);
t.start();
}
}

    public static void main(String[] args) {
        startNamedThreads();
    }
}


🧠 Що нового:

як дати потоку ім’я (Thread(String name) або setName())

Thread.currentThread().getName() — дізнатися, хто зараз виконує код

🧩 Завдання 4. “Очікування завершення потоку”

Мета: навчитися використовувати .join(), щоб дочекатися завершення потоку.

Умова:
Створіть потік, який виводить "Loading..." кілька секунд.
Головний потік повинен чекати, доки цей потік завершиться, і лише потім вивести "Done!".

public class ThreadPractice4 {
public static void waitForThread() throws InterruptedException {
Thread loader = new Thread(() -> {
for (int i = 0; i < 5; i++) {
System.out.println("Loading...");
try { Thread.sleep(500); } catch (InterruptedException e) {}
}
});

        loader.start();
        loader.join(); // головний потік чекає завершення

        System.out.println("Done!");
    }

    public static void main(String[] args) throws InterruptedException {
        waitForThread();
    }
}


🧠 Що нового:

.join() зупиняє потік, доки інший не завершиться

гарна практика при завантаженнях або попередніх обчисленнях

🧩 Завдання 5. “Паралельна обробка рядків”

Мета: обробити колекцію у кількох потоках.

Умова:
Є список імен. Розбийте його на частини та обробіть у двох потоках (кожен потік виводить імена зі своєї частини).

import java.util.*;

public class ThreadPractice5 {
public static void parallelNames() {
List<String> names = List.of("Anna", "Bohdan", "Vitalii", "Maria", "Oleh", "Sofiia");

        List<String> part1 = names.subList(0, names.size() / 2);
        List<String> part2 = names.subList(names.size() / 2, names.size());

        Thread t1 = new Thread(() -> part1.forEach(n -> {
            System.out.println(Thread.currentThread().getName() + ": " + n);
            try { Thread.sleep(300); } catch (InterruptedException e) {}
        }), "Processor-1");

        Thread t2 = new Thread(() -> part2.forEach(n -> {
            System.out.println(Thread.currentThread().getName() + ": " + n);
            try { Thread.sleep(300); } catch (InterruptedException e) {}
        }), "Processor-2");

        t1.start();
        t2.start();
    }

    public static void main(String[] args) {
        parallelNames();
    }
}


🧠 Що нового:

паралельна робота з колекціями

практичне застосування потоків у «роботі з даними»

🧭 Подальші кроки

Якщо ці 5 завдань пройдете — можна переходити до наступного блоку:

🔐 Locks, synchronized, Atomic змінні, ExecutorService.

Хочете, щоб я створив наступну серію з Locks і synchronized після того, як ви розберете ці 5?
(я зроблю в тому ж стилі — крок за кроком, від простого до складнішого).

You said:
так, давай, створи наступну серію з Locks і synchronized. Хоча я переживаю що ми можемо щось упустити
ChatGPT said:

Чудово, Пане Віталію 💪
І дуже правильна думка — якщо не будувати фундамент крок за кроком, потім почнуться “дивні” речі в багатопоточності (випадкові баги, race condition, непередбачуваний порядок виконання).
Тому зараз я зроблю наступний логічний блок — “Потоки з Locks і synchronized”, але перед цим коротко перевіримо, чи ви точно нічого не упускаєте.

🧩 Перевірка готовності перед переходом

Ви повністю готові до Locks і synchronized, якщо можете відповісти "так" на більшість із цих пунктів:

1️⃣ Розумієте різницю між .start() і .run()
2️⃣ Знаєте, що .join() змушує головний потік чекати
3️⃣ Можете створити кілька потоків, які виконують різні завдання одночасно
4️⃣ Знаєте, що вивід з кількох потоків може бути перемішаним
5️⃣ Розумієте, що потоки працюють незалежно, якщо не використовується синхронізація

Якщо все це ✔️ — можна сміливо рухатись до координації потоків.

🚦 Блок 2. “Синхронізація потоків і Locks”

Мета:
побачити, чому небезпечно писати в спільні дані без синхронізації,
і навчитися керувати цим без хаосу.

🧩 Завдання 1. “Race Condition — хто швидше?”

Мета: побачити проблему без синхронізації.

Умова:
Два потоки збільшують спільний лічильник по 1000 разів.
Очікуємо 2000, але результат — непередбачуваний.

public class SyncPractice1 {
private static int counter = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(SyncPractice1::increment);
        Thread t2 = new Thread(SyncPractice1::increment);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final counter = " + counter);
    }

    private static void increment() {
        for (int i = 0; i < 1000; i++) {
            counter++; // ❗ не синхронізовано
        }
    }
}


🧠 Що нового:

побачите, що результат не завжди 2000

це і є race condition — коли два потоки змінюють спільну змінну одночасно

🧩 Завдання 2. “Виправлення через synchronized метод”

Мета: захистити спільний ресурс від одночасного доступу.

public class SyncPractice2 {
private static int counter = 0;

    public static synchronized void increment() {
        counter++;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(SyncPractice2::doWork);
        Thread t2 = new Thread(SyncPractice2::doWork);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final counter = " + counter);
    }

    private static void doWork() {
        for (int i = 0; i < 1000; i++) {
            increment(); // тепер синхронізовано
        }
    }
}


🧠 Що нового:

synchronized — гарантує, що лише один потік одночасно виконує метод

тепер результат завжди 2000

🧩 Завдання 3. “Synchronized блок — часткова синхронізація”

Мета: навчитися синхронізувати не весь метод, а лише критичну ділянку.

public class SyncPractice3 {
private static int counter = 0;
private static final Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        Runnable r = () -> {
            for (int i = 0; i < 1000; i++) {
                synchronized (lock) {
                    counter++;
                }
            }
        };

        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final counter = " + counter);
    }
}


🧠 Що нового:

можна створювати власний lock-об’єкт

синхронізація не обов’язково охоплює весь метод

важливо синхронізувати однаковим об’єктом

🧩 Завдання 4. “ReentrantLock — ручне блокування”

Мета: познайомитися з класом ReentrantLock і його методами lock() / unlock().

import java.util.concurrent.locks.ReentrantLock;

public class SyncPractice4 {
private static int counter = 0;
private static final ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                lock.lock();
                try {
                    counter++;
                } finally {
                    lock.unlock();
                }
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("Final counter = " + counter);
    }
}


🧠 Що нового:

ReentrantLock — більш гнучка альтернатива synchronized

треба завжди розблоковувати у finally

дозволяє гнучкі сценарії (спроби з timeout, перевірки чи lock доступний)

🧩 Завдання 5. “Lock з tryLock()”

Мета: навчитись перевіряти, чи доступний замок, не блокуючись.

import java.util.concurrent.locks.ReentrantLock;

public class SyncPractice5 {
private static final ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        Thread t1 = new Thread(SyncPractice5::tryWork, "Worker-1");
        Thread t2 = new Thread(SyncPractice5::tryWork, "Worker-2");

        t1.start();
        t2.start();
    }

    private static void tryWork() {
        if (lock.tryLock()) {
            try {
                System.out.println(Thread.currentThread().getName() + " отримав замок і працює...");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                lock.unlock();
                System.out.println(Thread.currentThread().getName() + " звільнив замок.");
            }
        } else {
            System.out.println(Thread.currentThread().getName() + " не зміг отримати замок і пішов відпочивати.");
        }
    }
}


🧠 Що нового:

tryLock() не блокує потік, якщо замок зайнятий

зручно для некритичних або спробних завдань

🧩 Бонус. “Порівняння synchronized і Lock”
Критерій	synchronized	ReentrantLock
Автоматичне звільнення	✅ після виходу з блоку	❌ треба викликати unlock() вручну
Спроба без очікування	❌	✅ tryLock()
Можливість перевірки стану	❌	✅
Простота коду	✅	⚠️ трохи складніше
Рекомендація	Для простих випадків	Для розширених сценаріїв

💬 Наступний блок після цього я пропоную зробити:

🧵 “Взаємодія потоків”
тобто wait(), notify(), notifyAll(), і потім перейти до ExecutorService (бо там все стане простіше після розуміння синхронізації).

Хочете, щоб я підготував цей наступний блок ("Взаємодія потоків") у тому ж форматі — покроково з поясненнями й кодом?

https://chatgpt.com/c/68e64412-23e4-8325-8a60-98fb09ee80d8  