package regex.task19;


public class Regex4 {

    public boolean isValidPassword (String str) {
        if (!str.matches(".*[\\S]{8,20}.*")) {
            System.out.println(1);return false;}

        if (!str.matches(".*[A-Z].*")) {
            System.out.println(2);return false;}

        if (!str.matches(".*[a-z].*")) {
            System.out.println(3);return false;}

        if (!str.matches(".*[0-9].*")) {
            System.out.println(4);return false;}

        if (!str.matches(".*[!@#$%^&*()\\-\\+=].*")) {
            System.out.println(5);return false;}

        if (!str.matches(".*(?!.*(.)\\1{2}).*")) {
            System.out.println(6);return false;}



        return true;
    }

    public static void main(String[] args) {
        Regex4 regex2 = new Regex4();

        System.out.println(regex2.isValidPassword("StrongP@ss1"));
        System.out.println(regex2.isValidPassword("weakpass"));
        System.out.println(regex2.isValidPassword("SHORT1!"));
        System.out.println(regex2.isValidPassword("longpassword123456789!"));
        System.out.println(regex2.isValidPassword("NoSpecialChar1"));
        System.out.println(regex2.isValidPassword("White space 1!"));
        System.out.println(regex2.isValidPassword("Valid123!"));
    }
}
