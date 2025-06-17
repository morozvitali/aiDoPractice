package common.logers.loger3;

import common.logers.loger2.MyLogger2_2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public enum MyLogger3_1 {
    INSTANCE; //singleton

    private static final String FILE_NAME = "log3_1.txt";
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public void log (String message, String level) {
        String timeStamp = LocalDateTime.now().format(FORMATTER);
        String logLine = String.format("[%s] [%s] [%s]", timeStamp, level.toUpperCase(), message);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(logLine);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error file recording process");
        }
    }

        public static void main(String[] args) {
            MyLogger3_1 logger3_1 = MyLogger3_1.INSTANCE;
            logger3_1.log("message 11", "System Halt");


}
}
