package stream.plans.vtb;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;


/*
Практическое задание
1 Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся). Найти и
вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
Посчитать, сколько раз встречается каждое слово.
2 Написать простой класс Телефонный Справочник, который хранит в себе список фамилий и
телефонных номеров. В этот телефонный справочник с помощью метода add() можно
добавлять записи, а с помощью метода get() искать номер телефона по фамилии. Следует
учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
тогда при запросе такой фамилии должны выводиться все телефоны. Желательно не добавлять
лишний функционал (дополнительные поля (имя, отчество, адрес), взаимодействие с пользователем
через консоль и т.д). Консоль использовать только для вывода результатов проверки телефонного
справочника.
 */
public class Main1 {
    public static void main(String[] args) {
        String line = "У цьому відео я розповідаю 7 технік переконливого спілкування які допоможуть вам " +
                "отримувати бажане у роботі стосунках та щоденному житті Це прості " +
                "правила які можна застосовувати вже сьогодні без маніпуляцій і складних схем";
        String[] arr = line.split(" ");
        Map<String, Long> map = Arrays.stream(arr).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Set<String> set = Arrays.stream(arr).collect(Collectors.toSet());
    }
}

class PhoneBook {

    Map <String, List <String>> phoneBook = new HashMap<>();

    public void add (String name, String phone) {
        phoneBook.computeIfAbsent(name, k -> new ArrayList<>()).add(phone);
    }

    public List <String> get (String name) {
        return phoneBook.getOrDefault(name, Collections.emptyList());
    }
}

