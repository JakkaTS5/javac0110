
import java.io.*;

public class Lesson10_2F {
    public static void main(String[] args) {
        Reader reader = null;
        Writer writer = null;
        String line = "";
        try {
            reader = new FileReader("H:\\Java\\JavaKhoa01-10\\Lesson10\\input.txt");
            BufferedReader bre = new BufferedReader(reader, 100);
            writer = new FileWriter("H:\\Java\\JavaKhoa01-10\\Lesson10\\output.txt");

            while ((line = bre.readLine()) != null) {
                System.out.println(line);
//                line = line.replaceAll("\\s\\s+", " ").trim();
//                writer.write(line);
            }
            System.out.println(line);
            reader.close();
            writer.flush();
        } catch (FileNotFoundException e) {
        } catch (IOException e) {

        } finally {
            try {
                reader.close();
            } catch (IOException e) {
            }
        }
    }
}
