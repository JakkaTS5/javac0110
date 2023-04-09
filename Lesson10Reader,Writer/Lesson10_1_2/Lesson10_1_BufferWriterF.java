import java.io.*;

public class Lesson10_1_BufferWriterF {
    public static void main(String[] args) throws IOException {
        Writer writer = new FileWriter("H:\\Java\\JavaKhoa01-10\\Lesson10\\output.txt");
        BufferedWriter bw = new BufferedWriter(writer);

        bw.write("ghi du lieu trong day");
        bw.newLine(); //plus dong moi
        bw.close();
    }
}
