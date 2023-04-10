import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;

class PrintFactorsTask implements Runnable {
    private BlockingQueue<Integer> queue;
    private FileWriter writer;

    public PrintFactorsTask(BlockingQueue<Integer> queue, FileWriter writer) {
        this.queue = queue;
        this.writer = writer;
    }

    @Override
    public void run() {
        try {
            while (true) {
                int number = queue.take();
                List<Integer> factors = getFactors(number);
                String output = String.format("Thread -2 %d = %s", number, factors.toString());
                writer.write(output + "\n");
                writer.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private List<Integer> getFactors(int number) {
        List<Integer> factors = new ArrayList<>();
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                factors.add(i);
            }
        }
        return factors;
    }
}