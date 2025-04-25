package quickrealisation.solid.realisation.model;

import quickrealisation.solid.realisation.interfaces.Printable;

public class ReportPrinter implements Printable {
    @Override
    public void print(String text) {
        System.out.println("Printing: " + text);
    }
}