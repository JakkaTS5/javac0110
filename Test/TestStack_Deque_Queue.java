import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class TestStack_Deque_Queue {
    public static void main(String[] args) {
        Stack<Integer> integerStack = new Stack<>();
        System.out.println("Stack");
        integerStack.push(2);
        integerStack.push(4);
        integerStack.add(6);
        integerStack.add(8);
        System.out.println(integerStack);
        System.out.println(integerStack.size());
        System.out.println("Stack ~ take and delete: " + integerStack.pop());
        System.out.println(integerStack.size());
        System.out.println("Stack ~ take not delete: " + integerStack.peek());
        System.out.println(integerStack.size());
        System.out.println(integerStack);
        System.out.println("-------------------------------------------------");

        Deque<Integer> integerDeque = new ArrayDeque<>();
        // Deque<Integer> integerDeque = new Linkedlist<>();
        System.out.println("Deque");
        integerDeque.offer(3);
        integerDeque.push(5);
        integerDeque.add(7);
        integerDeque.add(9);
        System.out.println(integerDeque);
        System.out.println(integerDeque.size());
        System.out.println("Deque ~ take and delete: " + integerDeque.pop());
        System.out.println(integerDeque.size());
        System.out.println("Deque ~ take not delete: " + integerDeque.peek());
        System.out.println(integerDeque.size());
        System.out.println(integerDeque);
        System.out.println("-------------------------------------------------");

        Queue<Integer> integerQueue1 = new LinkedList<>();
        //Queue<Integer> integerQueue3 = new ArrayDeque<>();
        System.out.println("Queue Linked");
        integerQueue1.offer(1);//false if null
        integerQueue1.offer(5);
        integerQueue1.add(10);
        integerQueue1.add(15);//exception
        integerQueue1.add(20);
        System.out.println(integerQueue1);
        System.out.println(integerQueue1.size());
        System.out.println("Queue ~ take and delete: " + integerQueue1.remove());
        System.out.println(integerQueue1.size());
        System.out.println("Queue ~ take and delete: " + integerQueue1.poll());//null
        System.out.println(integerQueue1.size());
        System.out.println("Queue ~ take not delete: " + integerQueue1.peek());//null
        System.out.println(integerQueue1.size());
        System.out.println("Queue ~ take not delete: " + integerQueue1.element());
        System.out.println(integerQueue1.size());
        System.out.println(integerQueue1);
        System.out.println("-------------------------------------------------");

        Queue<Integer> integerQueue2 = new PriorityQueue<>();
        System.out.println("Queue Priority");
        integerQueue2.offer(17);//false if null
        integerQueue2.offer(3);
        integerQueue2.offer(13);
        integerQueue2.add(11);
        integerQueue2.add(7);
        System.out.println(integerQueue2);
        System.out.println(integerQueue2.size());
        System.out.println("Queue ~ take and delete: " + integerQueue2.remove());
        System.out.println(integerQueue2.size());
        System.out.println("Queue ~ take and delete: " + integerQueue2.poll());//null
        System.out.println(integerQueue2.size());
        System.out.println("Queue ~ take not delete: " + integerQueue2.peek());//null
        System.out.println(integerQueue2.size());
        System.out.println("Queue ~ take not delete: " + integerQueue2.element());
        System.out.println(integerQueue2.size());
        System.out.println(integerQueue2);
        System.out.println("-------------------------------------------------");
    }
}
