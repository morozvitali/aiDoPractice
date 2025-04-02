package regex.task19;

public class Regex2 {
    public boolean isValidePassword (String sentence) {
        return sentence
                .matches("" +
                        "(?=.*[a-z])" +
                        "(?=.*[A-Z])" +
                        "(?=.*[0-9])" +
                        "(?=.*[!@#$%^&*()-+=])" +
                        "(?!.*(.)\\1{2})" +
                        "\\S{10,20}$");
    }

    public static void main(String[] args) {
        Regex2 regex2 = new Regex2();
        System.out.println(regex2.isValidePassword("Aa1@StrongPass"));
        System.out.println(regex2.isValidePassword("weakpass123!"));
        System.out.println(regex2.isValidePassword("SHORT1!"));
        System.out.println(regex2.isValidePassword("verylongpassword123456!"));
        System.out.println(regex2.isValidePassword("NoSpecialChar1"));
        System.out.println(regex2.isValidePassword("White space 1!"));
        System.out.println(regex2.isValidePassword("AAA111@@@123"));
    }
}
