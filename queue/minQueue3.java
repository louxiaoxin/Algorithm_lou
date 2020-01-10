package queue;

import javafx.util.Pair;

import java.util.Stack;

public class minQueue3 {
    Stack<Pair<Integer,Integer>> s1, s2;

    public minQueue3() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void add(int val) {
        int min = s1.isEmpty() ? val : Math.min(val, s1.peek().getValue());
        s1.push(new Pair<>(val, min));
    }

    public int min() {
        int min;
        if (s1.isEmpty() || s2.isEmpty()) {
            min = s1.isEmpty() ? s2.peek().getValue() : s1.peek().getValue();
        }else{
            min = Math.min(s1.peek().getValue(), s2.peek().getValue());
        }
        return min;
    }
}
