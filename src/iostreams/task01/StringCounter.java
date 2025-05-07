package iostreams.task01;

import java.io.*;

public class StringCounter {

    public int StringCounter() {
        int lineCount = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader("iotask01.txt")))
        {
        while (reader.readLine() != null) {
            lineCount++;
        }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return lineCount;
    }

    public static void main(String[] args) {
        StringCounter sc = new StringCounter();
        System.out.println(sc.StringCounter());
    }
}


