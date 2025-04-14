package regex.task16;

public class Regex4 {

    public String isValidPassword(String password) {

        if (!password.matches("[\\S]{8,20}")) {return "Shrt or loooong or space";}
        if (!password.matches(".*[A-Z].*")) {return "no Big";}
        if (!password.matches(".*[a-z].*")) {return "no small";}
        if (!password.matches(".*[0-9].*")) {return "no d1g1t";}
        if (!password.matches(".*[!@#$%^&*()-+=].*")) {return "no$imbol";}

return "strong password";
    }

    public static void main(String[] args) {
        Regex4 r = new Regex4();
        System.out.println(r.isValidPassword("StrongP@ss1"));
        System.out.println(r.isValidPassword("weakpass"));
        System.out.println(r.isValidPassword("SHORT1!"));
        System.out.println(r.isValidPassword("longpassword123456789!"));
        System.out.println(r.isValidPassword("NoSpecialChar1"));
        System.out.println(r.isValidPassword("White space 1!"));
        System.out.println(r.isValidPassword("Valid123!"));
    }


}
