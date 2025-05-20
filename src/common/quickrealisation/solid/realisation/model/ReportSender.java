package common.quickrealisation.solid.realisation.model;

import common.quickrealisation.solid.realisation.interfaces.Sendable;

public class ReportSender implements Sendable {
    @Override
    public void send(String text) {
        System.out.println("Sending: " + text);
    }
}