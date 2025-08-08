task0_add_intstream_range_and_intstream_iterator_as_part


something new (Stream.concat())
Stream.concat(one.stream(), two.stream()).collect(Collectors.toSet());


transform Map to LinkedHashMap -->
LinkedHashMap::new












Рівень 1 (легкий):
Фільтрація, базове групування (groupingBy), підрахунок (counting)
Прості трансформації (map, flatMap)
Пошук мін/макс, перетворення регістру рядків
Рівень 2 (середній):
Використання колекторів summingInt, averagingInt, summarizingInt
Робота з partitioningBy
Робота з optional, orElse, orElseGet, ifPresent
Сортування в стрімах, складні фільтри, комбінування колекторів (collectingAndThen)

Рівень 3 (просунутий):
Кастомні колектори
Паралельні стріми (parallelStream)
Потік даних із багаторівневою агрегацією (nested groupingBy)
Ефективна робота з Optional у складних потоках
Використання peek, limit, skip, distinct у нестандартних випадках
Якщо хочете, я можу підготувати добірку задач по кожному рівню із розв’язками та підказками.