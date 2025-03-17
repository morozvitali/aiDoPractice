package regex.task11;

public class OnlyLettersAndSpaces {

    public static boolean isOnlyLettersAndSpaces(String str) {


        return str.matches("[a-zA-Z^\\S]+");
    }
}
