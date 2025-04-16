package lambda.Task1;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

public class SupplierExampler2 {

            /*
        аналог Stream.generate(() -> (int)(Math.random() * 100)).limit(5).forEach(System.out::println);
        🔧 Якщо хочеш трохи прокачати:
            2 зроби Supplier<String> який генерує псевдо-ID: "ID_ + random number`
            3 Supplier<LocalDateTime> для часових міток
            4 Supplier<User> який створює нових користувачів з випадковими іменами
            5 Зроби Supplier, який генерує паролі з 6 символів, використовуючи випадкові літери (a–z, A–Z, 0–9).
         */

    public static void main(String[] args) {
        Supplier <Integer> s1 = () -> (int) (Math.random()*100);
        SupplierExampler2 supplierExampler2 = new SupplierExampler2();
        System.out.println(supplierExampler2.mySupplier(11, s1));
        System.out.println(supplierExampler2.mySupplier2());
        System.out.println(supplierExampler2.mySupplier3());
        System.out.println(supplierExampler2.mySupplier4());
        System.out.println(supplierExampler2.mySupplier5());
    }

    public List <Integer> mySupplier (int count, Supplier <Integer> supplier) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            list.add(supplier.get());
        }
        return list;
    }

    public String mySupplier2 () {
        Supplier <String> sup = () -> "ID_" + (int) (Math.random()*100000);
        return sup.get();
    }

    public String mySupplier3 () {
        Supplier <String> sup = () -> "Time " + LocalDateTime.now();
        return sup.get();
    }

    public String mySupplier4 () {
        List <String> list = List.of("Vitalii", "Marichka", "Oksana", "Andrii", "Sofiia", "Bohdan", "Olena", "Dmytro");
        Supplier <String> sup = () -> "New random named user is " + list.get((int)(Math.random()*list.size()));
        return sup.get();
    }

    public String mySupplier5 () {
        Supplier <String> sup = () -> "new password is " + passgenerator((int)Math.random()*10+21);
        return sup.get();
    }

    public String passgenerator (int length) {
        String CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder password = new StringBuilder();
        Random r = new Random();
        for (int i = 0; i<length; i++) {
            password.append(CHARS.charAt(r.nextInt(CHARS.length())));
        }
        return password.toString();
    }
}
