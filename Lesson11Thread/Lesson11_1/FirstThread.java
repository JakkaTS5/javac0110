import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Random;

public class FirstThread extends Thread {
    public FirstThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        Random random = new Random();
        int count = 0;
        try {
            Writer output = new FileWriter("H:\\Java\\JavaC0110\\Lesson11Thread\\Lesson11_1\\output.txt");
            BufferedWriter br = new BufferedWriter(output);

            while (count <= 10) {
                int oNumRan = random.nextInt(10, 501);
                if (oNumRan % 2 != 0) {
                    count++;
                    System.out.println(oNumRan + " " + this.getName());
                    br.write(oNumRan);
                    br.newLine();
                }
                Thread.sleep(600);
            }br.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
}
