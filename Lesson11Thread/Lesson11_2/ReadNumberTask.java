import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;

class ReadNumberTask implements Runnable {
    private BlockingQueue<Integer> evenQueue;
    private BlockingQueue<Integer> oddQueue;

    public ReadNumberTask(BlockingQueue<Integer> evenQueue, BlockingQueue<Integer> oddQueue) {
        this.evenQueue = evenQueue;
        this.oddQueue = oddQueue;
    }

    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("number.txt"));
            String line = reader.readLine();
            int n = Integer.parseInt(line);
            while ((line = reader.readLine()) != null) {
                int number = Integer.parseInt(line);
                if (number % 2 == 0) {
                    evenQueue.put(number);
                } else {
                    oddQueue.put(number);
                }
            }
            reader.close();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}