package regex.task1;

public class Regex5 {
    public static boolean hasDigit(String str) {
        return str.matches(".*[\\d].*");
    }

    public static void main(String[] args) {
        System.out.println(hasDigit("hello123"));
        System.out.println(hasDigit("world"));
        System.out.println(hasDigit("abc5xyz"));
        System.out.println(hasDigit("hello123"));
        System.out.println(hasDigit("!@#$%^"));
    }
}
