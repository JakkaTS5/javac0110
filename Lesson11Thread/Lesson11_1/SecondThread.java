import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Random;

public class SecondThread extends Thread {
    public SecondThread(String name) {
        super.setName(name);
    }

    @Override
    public void run() {
        Random random = new Random();
        int min = 10;
        int max = 100;
        try {

            for (int i = 0; i < 20; i++) {
                int ranNums = random.nextInt(max - min + 1) + min;
                System.out.println(ranNums + " " + this.getName());
                Thread.sleep(1000);
            }

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
}