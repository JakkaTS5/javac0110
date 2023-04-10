import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

class PrintSquareTask implements Runnable {
    private final int number;
    private final String outputFileName;

    public PrintSquareTask(int number, String outputFileName) {
        this.number = number;
        this.outputFileName = outputFileName;
    }

    @Override
    public void run() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(outputFileName, true))) {
            writer.println("Thread -3: " + number + " = " + (number * number));
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}