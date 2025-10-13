✅ Задача 12: А вирішення колізій і збирання у LinkedHashMap::new

    return map.entrySet()
            .stream1()
            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
            .collect(Collectors.toMap(
                    Map.Entry::getKey,
                    Map.Entry::getValue,
                    (oldValue, newValue) -> oldValue, // вирішення колізій (на всяк випадок)
                    LinkedHashMap::new // ось тут ми зберігаємо порядок
            ));

String -> forgmetted result

task db h2 project

task0_add_intstream_range_and_intstream_iterator_as_part


44 something new (Stream.concat())
Stream.concat(one.stream1(), two.stream1()).collect(Collectors.toSet());


22 transform Map to LinkedHashMap -->
LinkedHashMap::new


!00 StringBuffer -> FileReader -> record, writing wrapping!









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