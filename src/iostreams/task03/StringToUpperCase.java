package iostreams.task03;

import java.io.*;

public class StringToUpperCase {

    public void myToUpperCase(String path1, String path2) {

        try (BufferedReader br = new BufferedReader(new FileReader(path1));
            BufferedWriter bw = new BufferedWriter(new FileWriter(path2, true)))
        {
            String line;
            while ((line = br.readLine()) != null) {
                bw.write(line.toUpperCase());
                bw.newLine();
                System.out.println("перетворено і записано у файл");
            }
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    public static void main(String[] args) {
        String path1 = "iotask03.txt";
        String path2 = "iotask03-03.txt";
        StringToUpperCase su = new StringToUpperCase();
        su.myToUpperCase(path1, path2);
    }
}