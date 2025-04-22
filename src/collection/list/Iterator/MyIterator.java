package collection.list.Iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyIterator {

    public static void main(String[] args) {
        List <String> list = new ArrayList<>(List.of("aa", "bb", "cc", "dd", "ee", "ff"));

        list.removeIf(s->s.equals("ff")); // варіант видалення без циклу while

        Iterator <String> iterator = list.iterator();

        //list.removeIf(s->s.equals("ff")); // не можна змінювати код напряму поки є ітератор! Буде помилка

        while (iterator.hasNext()) {
            String str = iterator.next();
            if (str.equals("ee")) {
                iterator.remove();
            }
        }
        System.out.println(list.toString());
    }
}