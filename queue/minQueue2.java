package Algorithm_lou.queue;

import javafx.util.Pair;

import java.util.ArrayDeque;
import java.util.Deque;

public class minQueue2 {
    Deque<Pair<Integer, Integer>> deque;
    int cnt_added;
    int cnt_removed;

    public minQueue2() {
        deque = new ArrayDeque<>();
        cnt_added = 0;
        cnt_removed = 0;
    }

    public int min() {
        return deque.peek().getKey();
    }

    public boolean isEmpty() {
        return deque.isEmpty();
    }

    public void add(int val) {
        while (!deque.isEmpty() && deque.peek().getKey() > val) {
            deque.pop();
        }
        deque.push(new Pair<>(val, cnt_added));
        cnt_added++;
    }

    public boolean remove(int val) {
        if (!deque.isEmpty() && deque.peek().getKey() == val) {
            deque.pop();
            cnt_removed++;
            return true;
        }
        return false;
    }
}
