import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Lesson10_1_FileInputF {
    public static void main(String[] args) {
        FileInputStream fileIn = null;
        // Properties properties = new Properties();
        try {
            fileIn = new FileInputStream("H:\\Java\\JavaKhoa01-10\\Lesson10\\input.txt");
            // properties.load(fileIn);
            int i = 0;
            while ((i = fileIn.read()) >=0)  {
//                System.out.print((char) i);
            }
            System.out.println(i);
//            System.out.print((char) i);
            fileIn.close();
        } catch (FileNotFoundException ex) {

        } catch (IOException ex) {

        } finally {
            try {
                fileIn.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // String url = properties.getProperty("url");
    }
}
