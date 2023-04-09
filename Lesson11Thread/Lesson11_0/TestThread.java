public class TestThread {
    public static void main(String[] args) {
        FirstThread t1 = new FirstThread("Luong1");
        FirstThread t2 = new FirstThread("Luong2");
        Thread Thread1 = new Thread(t1);
        Thread Thread2 = new Thread(t2);
        Thread1.start();
        Thread2.start();

//        SimpleThread st1 = new SimpleThread("sp1");
//        SimpleThread st2 = new SimpleThread("sp2");
//        st1.start();
//        st2.start();
    }
}
