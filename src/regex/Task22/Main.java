package regex.Task22;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.isValidUkrPhone("+380501234567"));
        System.out.println(main.isValidUkrPhone("+380501567"));
        System.out.println(main.isValidUkrPhone("+80501234567"));

        System.out.println(main.cleanText(" qwuifkjn  qdf (*&_(*&^ qwef"));
        System.out.println(main.cleanText(" Hi! My name%^ame is JavaDev99"));
        System.out.println(main.cleanText(" Є д1345y7sqkfh*(^%(&$^"));

        System.out.println(main.isValidEmail("qsfadg@gmail.com"));
        System.out.println(main.isValidEmail("qsfadg@@gmail.com"));
        System.out.println(main.isValidEmail("qsfa  dg@gmail.com"));
        System.out.println(main.isValidEmail("qsfadg@gmail.co2345m"));
        System.out.println(main.isValidEmail("qsfadg@gmail.cm"));


        System.out.println(main.countDigits());

    }

    public boolean isValidUkrPhone(String phone) {
        return phone.matches("^\\+380\\d{9}$");
    }

    public String cleanText(String input) {
        return input.replaceAll("[^a-zA-Z09 ]","");
    }

    public boolean isValidEmail(String email) {
        return email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}");

    }
    public int countDigits() {

        String str = "Java123 is cool45";
        return str.replaceAll("[^\\d]", "").length();
    }
}
