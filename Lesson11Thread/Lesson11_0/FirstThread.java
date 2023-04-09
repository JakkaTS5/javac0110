public class FirstThread implements Runnable {
    private String name;
    private int count = 0;

    public FirstThread(String name) {
        this.name = name;
    }

    @Override
    public synchronized void run() {
        for (int i = 0; i <= 5; i++) {
            System.out.println(i + " this is thread " + this.name +" "+ (count++));
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
