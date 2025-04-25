package quickrealisation.solid.realisation.model;

import quickrealisation.solid.realisation.interfaces.Sendable;

public class ReportSender implements Sendable {
    @Override
    public void send(String text) {
        System.out.println("Sending: " + text);
    }
}