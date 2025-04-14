package regex.task18;

public class Regex4 {

    public String isCardName(String str) {

        if (str.matches("^4[0-9]{15}$")) {
            return "VISA";
        }

        if (str.matches("^5[1-5][0-9]{14}$")) {
            return "MASTERCARD";
        }

        if (str.matches("^(34|37)[0-9]{13}$")) {
            return "American Express";
        }

        if (str.matches("6011[0-9]{12}$")) {
            return "Discover";
        }
        return "UNKNOWN";
    }
}
