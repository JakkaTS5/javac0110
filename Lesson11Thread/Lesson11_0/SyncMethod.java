public class SyncMethod implements Runnable  {
    private String name;
    public SyncMethod(String name){
        this.name = name;
    }

    @Override
    public synchronized void run() {
        for (int i = 0; i <= 5; i++) {
            System.out.println(i + " this is thread " + this.name);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
