package quickrealisation.solid.realisation;

import quickrealisation.solid.realisation.interfaces.*;
import quickrealisation.solid.realisation.model.*;

public class Main {
    public static void main(String[] args) {
        Printable printer = new ReportPrinter();
        Sendable sender = new ReportSender();
        Savable saver = new ReportSaver();
    }
}