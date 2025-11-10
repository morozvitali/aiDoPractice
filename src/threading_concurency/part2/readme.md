Переходимо до Частини 2 — Locks & Atomics (завдання 6–10)
Тут ти побачиш, як замки (Locks) і атомарні змінні (Atomics) 
дозволяють робити те саме, що synchronized, але гнучкіше, 
точніше й без блокування всієї секції коду.

# ⚙️ Частина 2 — Locks & Atomics (Завдання 6–10)

# ✅ Завдання 6 — Використання ReentrantLock
# 📋 Умова: обмежи доступ до спільної змінної через ReentrantLock.

import java.util.concurrent.locks.ReentrantLock;

public class LockDemo {
static int counter = 0;
static ReentrantLock lock = new ReentrantLock();

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
        t1.start(); t2.start();
        t1.join(); t2.join();

        System.out.println("Counter = " + counter);
    }
}


📤 Результат:

Counter = 2000


🧠 ReentrantLock працює як synchronized, але дозволяє вручну контролювати, коли і як саме знімається блокування.
Перевага — можна використати tryLock() чи lockInterruptibly().

✅ Завдання 7 — Використання tryLock() (безпечна спроба)

📋 Умова: не чекай, якщо lock зайнятий.

import java.util.concurrent.locks.ReentrantLock;

public class TryLockDemo {
static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        Runnable task = () -> {
            if (lock.tryLock()) {
                try {
                    System.out.println(Thread.currentThread().getName() + " got the lock");
                } finally {
                    lock.unlock();
                }
            } else {
                System.out.println(Thread.currentThread().getName() + " skipped (lock busy)");
            }
        };

        new Thread(task, "T1").start();
        new Thread(task, "T2").start();
    }
}


📤 Вивід:

T1 got the lock
T2 skipped (lock busy)


🧠 tryLock() — не блокує потік, якщо замок зайнятий.
Корисно для швидких задач, щоб не чекати даремно.

✅ Завдання 8 — Використання AtomicInteger

📋 Умова: обійди synchronized, зроби підрахунок потокобезпечно.

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicDemo {
static AtomicInteger counter = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                counter.incrementAndGet();
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        t1.start(); t2.start();
        t1.join(); t2.join();

        System.out.println("Counter = " + counter.get());
    }
}


📤 Результат:

Counter = 2000


# 🧠 AtomicInteger — це лічильник, який гарантує атомарність операцій (++, get(), set(), compareAndSet()).
Використовує CPU-level атомарні інструкції без блокувань.

✅ Завдання 9 — Порівняння synchronized vs AtomicInteger

📋 Умова: заміряй час виконання двох варіантів.

import java.util.concurrent.atomic.AtomicInteger;

public class CompareDemo {
static int syncCounter = 0;
static AtomicInteger atomicCounter = new AtomicInteger(0);

    public static synchronized void incSync() { syncCounter++; }

    public static void main(String[] args) throws InterruptedException {
        long start, end;

        Runnable syncTask = () -> { for (int i = 0; i < 1_000_000; i++) incSync(); };
        Runnable atomicTask = () -> { for (int i = 0; i < 1_000_000; i++) atomicCounter.incrementAndGet(); };

        Thread t1 = new Thread(syncTask);
        Thread t2 = new Thread(syncTask);
        start = System.currentTimeMillis();
        t1.start(); t2.start(); t1.join(); t2.join();
        end = System.currentTimeMillis();
        System.out.println("synchronized: " + (end - start) + " ms");

        t1 = new Thread(atomicTask);
        t2 = new Thread(atomicTask);
        start = System.currentTimeMillis();
        t1.start(); t2.start(); t1.join(); t2.join();
        end = System.currentTimeMillis();
        System.out.println("AtomicInteger: " + (end - start) + " ms");
    }
}


📤 Вивід (приклад):

synchronized: 42 ms  
AtomicInteger: 9 ms


🧠 AtomicInteger набагато швидший, бо не створює контекстного блокування між потоками.

✅ Завдання 10 — Deadlock (взаємне блокування)

📋 Умова: два потоки чекають один одного — класичний deadlock.

import java.util.concurrent.locks.ReentrantLock;

public class DeadlockDemo {
static ReentrantLock lockA = new ReentrantLock();
static ReentrantLock lockB = new ReentrantLock();

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            lockA.lock();
            System.out.println("T1 locked A");
            try { Thread.sleep(100); } catch (InterruptedException ignored) {}
            lockB.lock();
            System.out.println("T1 locked B");
        });

        Thread t2 = new Thread(() -> {
            lockB.lock();
            System.out.println("T2 locked B");
            try { Thread.sleep(100); } catch (InterruptedException ignored) {}
            lockA.lock();
            System.out.println("T2 locked A");
        });

        t1.start();
        t2.start();
    }
}


📤 Вивід:

T1 locked A  
T2 locked B  
(і зависає назавжди)


🧠 Deadlock — ситуація, коли потоки назавжди чекають один одного.
Це найнебезпечніша помилка в багатопоточності.

💡 Рішення: завжди брати замки в однаковому порядку (A потім B, або навпаки).

🧩 Підсумок частини 2
Концепція	Ключовий клас/метод	Пояснення
ReentrantLock	lock(), unlock()	Альтернатива synchronized
tryLock()	не блокує	Якщо зайнято — просто пропускає
AtomicInteger	incrementAndGet()	Потокобезпечний без блокування
Deadlock	два потоки чекають	Завжди беріть замки в одному порядку
Продуктивність	Atomic > synchronized	Бо немає kernel-level блокування

🧠 Після цієї частини ти вже маєш контроль над потоками “як диспетчер”:
можеш керувати блокуваннями, уникати deadlock і оптимізувати швидкість.