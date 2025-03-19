package regex.task18;

public class CardDesriptor {
    public String getCardType(String cardNumber) {

        cardNumber = cardNumber.replaceAll("\\s", "");



        if (cardNumber.matches("^[4][0-9]{15}$")) {return "Visa";}
        if (cardNumber.matches("^5[1-5]\\d{14}$")) {return "MasterCard";}
        if (cardNumber.matches("^(34|37)[0-9]{13}$")) {return "American Express";}
        if (cardNumber.matches("^(6011)[0-9]{12}$")) {return "Discover";}
return "UNKNOWN";
    }

    public static void main(String[] args) {
        CardDesriptor cardDesriptor = new CardDesriptor();


        System.out.println(cardDesriptor.getCardType("4111111111111111"));
        System.out.println(cardDesriptor.getCardType("5500000000000004"));
        System.out.println(cardDesriptor.getCardType("340000000000009"));
        System.out.println(cardDesriptor.getCardType("6011000000000004"));
        System.out.println(cardDesriptor.getCardType("1234567890123456"));
        System.out.println(cardDesriptor.getCardType("411111111111111"));
        System.out.println(cardDesriptor.getCardType("123"));
        System.out.println(cardDesriptor.getCardType("123"));
    }
}
