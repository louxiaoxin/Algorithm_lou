package Algorithm_lou.queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class minQueue1 {
    private Deque<Integer> deque;

    public minQueue1() {
        deque = new ArrayDeque<>();
    }

    public boolean isEmpty() {
        return deque.isEmpty();
    }

    public int min() {
        return deque.peek();
    }

    public int poll() {
        return deque.pop();
    }

    public void add(int x) {
        while (!deque.isEmpty() && deque.peekLast() > x) {
            deque.pop();
        }
        deque.offer(x);
    }

    public boolean remove(int val) {
        if (!deque.isEmpty() && deque.peek() == val) {
            deque.pop();
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        minQueue1 minQueue1 = new minQueue1();
        minQueue1.add(3);
        minQueue1.add(2);
        minQueue1.add(4);
        minQueue1.add(1);
        minQueue1.add(6);
        minQueue1.add(7);
        minQueue1.add(10);
        while (!minQueue1.isEmpty()) {
            System.out.println(minQueue1.poll());
        }
    }
}
