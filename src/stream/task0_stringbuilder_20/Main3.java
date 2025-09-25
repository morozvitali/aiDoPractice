package stream.task0_stringbuilder_20;

import java.util.stream.Stream;

public class Main3 {
    public void practice1() {
        StringBuilder sb = new StringBuilder("Hello").append(" world");
        System.out.println(sb);
    }

    public void practice2() {
        StringBuilder sb = new StringBuilder("Java").insert(2, " cool ");
        System.out.println(sb);
    }

    public void practice3() {
        StringBuilder sb = new StringBuilder("abcdef").delete(2, 5);
        System.out.println(sb);
    }

    public void practice4() {
        StringBuilder sb = new StringBuilder("level").reverse();
        System.out.println(sb);
    }

    public void practice5() {
        StringBuilder sb = new StringBuilder("orange").replace(2, 5, "X");
        System.out.println(sb);
    }

    public void practice6() {
        StringBuilder sb = new StringBuilder("123").append(4).append(5).append(6);
        System.out.println(sb);
    }

    public void practice7() {
        StringBuilder sb = new StringBuilder("sunshine").insert(3, "___");
        System.out.println(sb);
    }

    public void practice8() {
        StringBuilder sb = new StringBuilder("ABCDEFG");
        for (int i = sb.length() - 1; i >= 0; i = i - 2) {
            if (i % 2 == 0) {
                sb.deleteCharAt(i);
            }
        }
    }

    public String practice9 (String s) {
        return new StringBuilder(s).reverse().toString();
    }

    public void practice10 () {
        StringBuilder sb = new StringBuilder("abracadabra");
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == 'a') {
                sb.setCharAt(i, '*');
            }
            System.out.println(sb);
        }
    }

    public void practice11 () {
        StringBuilder sb = new StringBuilder("hello world");
        int underscoreindex = sb.indexOf("_");
        sb.deleteCharAt(underscoreindex);
        sb.insert(underscoreindex, "_");
        sb.append("!!!");
    }

    public void practice12 () {
        StringBuilder sb = new StringBuilder("abcdefg");
        String part = sb.substring(2,6);
        String reversed = new StringBuilder(part).reverse().toString();
        sb.replace(2, 6, reversed);
        System.out.println(sb);
    }

    public String practice13 (String s) {
        StringBuilder sb = new StringBuilder("Tel: 123-456-789");
        for (int i=0; i<sb.length(); i++) {
            if (Character.isDigit(sb.charAt(i))) {
                sb.setCharAt(i, '#');
            }
            System.out.println(sb);
        }

        return
    }
}
