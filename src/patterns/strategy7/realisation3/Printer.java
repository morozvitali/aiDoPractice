package patterns.strategy7.realisation3;

import java.util.function.Function;

public class Printer {
    private Function<String, String> strategy;
    public void setStrategy(Function<String, String> strategy) {
     this.strategy = strategy;
    }

    public void print(String text) {
        System.out.println(strategy.apply(text));
    }

    public static void main(String[] args) {
        Printer printer = new Printer();

        printer.setStrategy(s->s.toUpperCase());
        printer.print("hello");

        printer.setStrategy(s->s.toLowerCase());
        printer.print("HELLO");

        printer.setStrategy(s->new StringBuilder(s).reverse().toString());
        printer.print("hello");

        printer.setStrategy(s->String.join(" ", s.split("")));
        printer.print("hello");


    }




}
