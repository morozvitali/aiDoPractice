package stream.task0_stringbuilder_20;

import java.util.stream.IntStream;

public class Main1 {
    public void practice1() {
        StringBuilder sb = new StringBuilder("Hello");
        sb.append(" World");
        System.out.println(sb);
    }

    public void practice2() {
        StringBuilder sb = new StringBuilder("JAVA");
        sb.insert(2, " cool ");
        System.out.println(sb);
    }

    public void practice3() {
        StringBuilder sb = new StringBuilder("abcdef");
        sb.delete(2, 5);
        System.out.println(sb);
    }

    public void practice4() {
        StringBuilder sb = new StringBuilder("level");
        sb.reverse();
        System.out.println(sb);
    }

    public void practice5() {
        StringBuilder sb = new StringBuilder("orange");
        sb.replace(2, 5, "X");
        System.out.println(sb);
    }

    public void practice6() {
        StringBuilder sb = new StringBuilder(123).append("4").append("5").append("6");
        System.out.println(sb);
    }

    public void practice7() {
        StringBuilder sb = new StringBuilder("sunshine");
        sb.insert(3, "___");
        System.out.println(sb);
    }

    public void practice8() {
        StringBuilder sb = new StringBuilder("ABCDEFG");
        IntStream.iterate(1, i -> i + 2).mapToObj(a -> sb.deleteCharAt(a)).limit(sb.length());
    }

    public String practice9(String s) {
        return new StringBuilder(s).toString();
    }

    public void practice10() {
        StringBuilder sb = new StringBuilder("abracadabra");

        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == 'a') {
                sb.setCharAt(i, '*');
            }
        }
        System.out.println(sb);
    }

    public void practice11() {
        StringBuilder sb = new StringBuilder("hello_world");
        int index = sb.indexOf("_");
        sb.deleteCharAt(index);
        sb.insert(index, " ");
        sb.append("!!!");
    }

    public void practice12() {
        StringBuilder sb = new StringBuilder("abcdefg");
        String partReverse = new StringBuilder(sb.substring(2, 6)).reverse().toString();
        sb.replace(2, 6, partReverse);
        System.out.println(sb);
    }

    public void practice13() {
        StringBuilder sb = new StringBuilder("Tel: 123-456-789");
        for (int i = 0; i < sb.length(); i++) {
            if(Character.isDigit(sb.charAt(i))) {
                sb.setCharAt(i, '#');
            }
        }
        System.out.println(sb);
    }

    public void practice14 () {
        StringBuilder sb = new StringBuilder("Java is cool");
        String firstWord = sb.substring(0,4);
        sb.delete(0,5);
        sb.append(firstWord);
        System.out.println(sb);
    }

    public void practice15 () {
        StringBuilder sb = new StringBuilder("apple\nbanana\ncherry");
        int counter = 1;
        sb.insert(0, counter++ + ". ");

        for (int i = 0; i<sb.length(); i++) {
            if (sb.charAt(i) == '\n') {
                sb.insert(i + 1, counter++ + ". ");
            }
        }

    }

    public void practice16 () {
        StringBuilder sb = new StringBuilder("Winter");
        sb.insert(sb.length(), "cold");
        int start = sb.indexOf("cold");
        sb.replace(start, start + 4, "warm");
        sb.insert(0, "Hot ");
        System.out.println(sb);
    }

    public void practice17 () {
        String[] colors = {"red", "green", "blue"};
        StringBuilder sb = new StringBuilder();

        for (int i =0; i<colors.length; i++) {
            sb.append(colors[i]);
            if (i < colors.length -1) {
                sb.append("-");
            }
        }
    }
}
