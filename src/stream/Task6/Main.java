package stream.Task6;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.myCollection());
    }

    public String myCollection () {

        return Arrays.stream(new int[]{10, 20, 30})
                .mapToObj(String::valueOf)
                .reduce((a,b)-> a+ "|" + b)
                .orElse("");
    }

    public static String inToString (int i) {
        return String.valueOf(i);
    }


}
