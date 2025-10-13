🧩 Новий модуль — “Concurrency & Parallel Streams”
📘 Мета: навчитися розуміти і контролювати паралельність у Java

🔹 Частина 1: Основи потоків
Створення потоків (Thread, Runnable, lambda)
Використання sleep(), join()
Демонстрація race condition
synchronized — як працює монітор
Object monitor: wait(), notify(), notifyAll()

🔹 Частина 2: Advanced Concurrency
Використання ReentrantLock
AtomicInteger — безпечні лічильники
ExecutorService — пул потоків
Callable + Future
CompletableFuture basics

🔹 Частина 3: Parallel Streams (глибше)
Як ForkJoinPool працює всередині
Обмеження паралельності
Performance тест: stream vs parallelStream vs Executor
Thread safety при collect()
Коли не можна використовувати parallelStream

⚙️ Формат:
Можу зробити окремий великий модуль із 15 завдань (розділений на блоки “Threads”, “Locks”, “Executor”, “ParallelStream”),
де кожне завдання з прикладом, виводом і коротким поясненням, поступово нарощуючи складність.
Наприклад:

Завдання 3: "Два потоки виводять числа одночасно — поясни, чому порядок змішується"
Завдання 8: "Порівняй synchronized vs ReentrantLock"
Завдання 13: "Виконай паралельну обробку списку за допомогою ExecutorService"
Завдання 15: "Поясни, чому parallelStream може бути повільнішим за stream"

🧠 Мета цього модуля:
Не просто “вміти писати потоки”, а розуміти, як і коли вони впливають на:
швидкість,
порядок виконання,
безпечність даних.