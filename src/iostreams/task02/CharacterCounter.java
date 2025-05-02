package iostreams.task02;

import java.io.*;

public class CharacterCounter {

    public void longLine() {
        String filePath = "iotask02.txt";
        String longestLine = "";
        int maxLenght = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.length() > maxLenght) {
                    maxLenght = line.length();
                    longestLine = line;
                }
            }
            System.out.println("longest line in file " + filePath + " is: " + longestLine);
            System.out.println("max lenght in this line is " + maxLenght);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println("start main function ***");
        CharacterCounter cc = new CharacterCounter();
        cc.longLine();
    }
}
