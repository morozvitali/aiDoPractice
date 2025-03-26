package regex.task21;

import java.util.Arrays;

public class Main {

    public String shortify(String input) {
        String[] words = input.split(" ");

        return Arrays.stream(words)
                .reduce(words[0], (
                        shortest,
                        current) -> current.length() <= shortest.length() ? current : shortest);
    }

    public static void main(String[] args) {
        Main m = new Main();
        System.out.println(m.shortify("home is where 1 the heart is"));
    }
}
