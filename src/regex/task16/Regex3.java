package regex.task16;

public class Regex3 {
    public String isValidPassword (String sentence) {
        if (!sentence.matches("(.*[a-z].*)")) {return "mo small letters";}
        if (!sentence.matches("(.*[A-Z].*)")) {return "mo big letters";}
        if (!sentence.matches("(.*[0-9].*)")) {return "mo digits";}
        if (!sentence.matches("(.*[!@#%^&].*)")) {return "mo !@#%^&";}
        if (!sentence.matches("[\\S]{8,20}")) {return "too short or long";}




        return "strong password";
    }
    public static void main(String[] args) {
        Regex3 r = new Regex3();
        System.out.println(r.isValidPassword("StrongP@ss1"));
        System.out.println(r.isValidPassword("weakpass"));
        System.out.println(r.isValidPassword("SHORT1!"));
        System.out.println(r.isValidPassword("longpassword123456789!"));
        System.out.println(r.isValidPassword("NoSpecialChar1"));
        System.out.println(r.isValidPassword("White space 1!"));
        System.out.println(r.isValidPassword("Valid123!"));
    }
}
