import java.io.PrintWriter;
import java.util.Random;

public class test {
    public static void main(String[] args)  {
        try {
            PrintWriter writer = new PrintWriter("H:\\Java\\Java2nd\\Java0110\\Lesson11Thread\\Lesson11_1\\output.txt");
            Random random = new Random();
            int n = random.nextInt(10,101);
            writer.write("So ngau nhien n la:"+n+"\n");
            writer.flush();
            for (int i = 0; i <500; i++) {
                int m = random.nextInt(1,501);
                writer.write("So ngau nhien tiep theo la: "+m);
                writer.flush();
                writer.close();
            }

        }catch (Exception exception){
            System.out.println(exception);
        }
    }
}
