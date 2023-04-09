
public class Main {
    public static void main(String[] args) {
        FirstThread th1 = new FirstThread("TheOdd");
        SecondThread th2 = new SecondThread("TenToHundred");
        th1.start();
        th2.start();
        }
    }
