package regex.task15;

public class Regex4 {
    public String[] splitWords(String text) {


        String[] array = text.split(" ");

        for (int i=0; i<array.length; i++) {
            array[i] = array[i].replaceAll("[\\W]+", "");
        }

        return array;
    }

    public static void main(String[] args) {
        Regex4 r = new Regex4();
        String[] array = r.splitWords("Hello, world! How are you?");

        for (String s : array) {
            System.out.println(s);
        }

    }
}
