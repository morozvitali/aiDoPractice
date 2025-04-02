package regex.task18;

public class Regex2 {

    public boolean isDescripted (String sentence) {
        return sentence.matches("^41[\\d]{14}|55[\\d]{14}|34[\\d]{13}|6[\\d]{15}$");
    }

    public static void main(String[] args) {
        Regex2 regex2 = new Regex2();
        System.out.println(regex2.isDescripted("4111111111111111"));
        System.out.println(regex2.isDescripted("5500000000000004"));
        System.out.println(regex2.isDescripted("340000000000009"));
        System.out.println(regex2.isDescripted("6011000000000004"));
        System.out.println(regex2.isDescripted("1234567890123456"));
        System.out.println(regex2.isDescripted("411111111111111"));
    }
}
