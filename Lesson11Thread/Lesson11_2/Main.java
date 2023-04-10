import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {
    public static void main(String[] args) {
        BlockingQueue<Integer> evenQueue = new LinkedBlockingQueue<>();
        BlockingQueue<Integer> oddQueue = new LinkedBlockingQueue<>();
        new Thread(new ReadNumberTask(evenQueue, oddQueue)).start();
        new Thread(new PrintFactorsTask(evenQueue)).start();
        new Thread(new PrintSquareTask(oddQueue)).start();
    }
}