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


}
