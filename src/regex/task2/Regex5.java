package regex.task2;

public class Regex5 {
    public boolean isValidPhoneNumber(String phone) {
        return phone.matches("\\+380\\d{2}\\d{7}$");
    }


    public static void main(String[] args) {
        Regex5 is = new Regex5();
        System.out.println(is.isValidPhoneNumber("+380501234567"));
        System.out.println(is.isValidPhoneNumber("380501234567"));
        System.out.println(is.isValidPhoneNumber("+380991234"));
        System.out.println(is.isValidPhoneNumber("+380AA1234567"));
        System.out.println(is.isValidPhoneNumber("+380501234567"));
    }
}
