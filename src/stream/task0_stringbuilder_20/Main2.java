package stream.task0_stringbuilder_20;

public class Main2 {
    public void practice1() {
        StringBuilder sb = new StringBuilder("Hello");
        sb.append(" World");
        System.out.println(sb);
    }

    public void practice2() {
        StringBuilder sb = new StringBuilder("Java");
        sb.insert(2, "cool");
        System.out.println(sb);
    }

    public void practice3() {
        StringBuilder sb = new StringBuilder("abcdef");
        sb.delete(2, 5);
    }

    public void practice4() {
        StringBuilder sb = new StringBuilder("level");
        System.out.println(sb.reverse());
    }

    public void practice5() {
        StringBuilder sb = new StringBuilder("orange");
        sb.replace(2, 5, "X");
    }

    public void practice6() {
        StringBuilder sb = new StringBuilder("123");
        System.out.println(sb.append("4").append("5").append("6"));
    }

    public void practice7() {
        StringBuilder sb = new StringBuilder("sunshine");
        sb.insert(3, "___");
        System.out.println(sb);
    }

    public void practice8() {
        StringBuilder sb = new StringBuilder("ABCDEFG");
        for (int i = sb.length(); i >= 0; i = i--) {
            if (i % 2 == 1) {
                sb.deleteCharAt(i);
            }
        }
        System.out.println(sb);
    }

    public String practice9() {
        return new StringBuilder("Java").reverse().toString();
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
        int undercoreIndex = sb.indexOf("_");
        sb.deleteCharAt(undercoreIndex);
        sb.insert(undercoreIndex, " ");
        sb.append("!!!");
        System.out.println(sb);
    }

    public void practice12() {
        StringBuilder sb = new StringBuilder("abcdefg");
        String part = sb.substring(2, 6);
        String reversed = new StringBuilder(part).reverse().toString();
        sb.replace(2, 6, reversed);
        System.out.println(sb);
    }

    public void practice13 () {
        StringBuilder sb = new StringBuilder("Tel: 123-456-789");
        for (int i =0; i<sb.length(); i++) {
            if (Character.isDigit(sb.charAt(i))) {
                sb.setCharAt(i, '#');
            }
        }
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
        System.out.println(sb);
    }
}