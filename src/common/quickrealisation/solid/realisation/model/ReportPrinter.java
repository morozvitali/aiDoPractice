package common.quickrealisation.solid.realisation.model;

import common.quickrealisation.solid.realisation.interfaces.Printable;

public class ReportPrinter implements Printable {
    @Override
    public void print(String text) {
        System.out.println("Printing: " + text);
    }
}