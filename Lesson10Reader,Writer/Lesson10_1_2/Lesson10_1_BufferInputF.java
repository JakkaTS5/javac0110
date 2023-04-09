import java.io.*;

public class Lesson10_1_BufferInputF {
    public static void main(String[] args) {
        FileInputStream fileIn = null;
        try {
             fileIn = new FileInputStream("H:\\Java\\JavaKhoa01-10\\Lesson10\\input.txt");
            //tạo ra bộ đệm buffer + kích thước
            BufferedInputStream bin = new BufferedInputStream(fileIn, 100);
            int i = 0;
            byte[] b = new byte[20];
            while((i = bin.read(b)) != -1) {
                System.out.println(new String(b));
            }

            fileIn.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException ex) {

        }finally {
            try {
                fileIn.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
