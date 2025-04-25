package quickrealisation.solid.realisation.model;

import quickrealisation.solid.realisation.interfaces.Savable;

public class ReportSaver implements Savable {
    @Override
    public void save(String text) {
        System.out.println("Saving: " + text);
    }
}