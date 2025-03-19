package regex.task15;

public class Main {

    public String [] splitWords (String text) {
        return text.split("[\\W]+");
//        splitWords("Hello, world! How are you?")
// 🔥 ["Hello", "world", "How", "are", "you"]
    }

    public static void main(String[] args) {
        Main m = new Main();
        String str = "Hello, world! How are you?";

        for (String word : m.splitWords(str)) {
            System.out.println(word);
        }
    }
}
