import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QueueJava {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        // liên kết và sử dụng node
        Queue<String> queue = new LinkedList<>();
        // là 1 mảng
//        Queue<String> queue1 = new ArrayList<Object>();
        queue.add("string1");
        queue.add("string2");
        queue.add("string3");
        queue.add("string4");
        System.out.println("Show Queue "+ queue);
        queue.remove();
        System.out.println("Show Queue after remove"+ queue);
        System.out.println("lay ra " + queue.peek());
        System.out.println("lay ra va remove "+ queue.poll());
        System.out.println("Show Queue after remove"+ queue);
        System.out.println(queue.poll());
    }
}
