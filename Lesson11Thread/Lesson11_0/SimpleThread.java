public class SimpleThread extends Thread {
    public SimpleThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i <= 30; i++) {
            System.out.println(i + " this is thread " + this.getName());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
