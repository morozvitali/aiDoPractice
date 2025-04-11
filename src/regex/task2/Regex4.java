package regex.task2;

public class Regex4 {



    public boolean isValidPhoneNumber(String phone) {
        return phone.matches("\\+380 \\d{2} \\d{7}$");
    }

    public static void main(String[] args) {
        Regex4 is = new Regex4();
        System.out.println(is.isValidPhoneNumber("+380 50 1234567"));
        System.out.println(is.isValidPhoneNumber("380 50 1234567"));
        System.out.println(is.isValidPhoneNumber("+380 99 1234"));
        System.out.println(is.isValidPhoneNumber("+380 AA 1234567"));
        System.out.println(is.isValidPhoneNumber("+38 05 01234567"));
    }
}
