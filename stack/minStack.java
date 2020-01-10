package stack;

import javafx.util.Pair;

import java.util.Stack;

public class minStack {
    private Stack<Pair<Integer, Integer>> stack;

    public minStack() {
        stack = new Stack<>();
    }

    public int pop() {
        return stack.pop().getKey();
    }

    public void push(int val) {
        stack.push(new Pair<>(val, stack.isEmpty() ? val : val < stack.peek().getValue() ? val : stack.peek().getValue()));
    }

    public int peek() {
        return stack.peek().getKey();
    }

    public int peekMin() {
        return stack.peek().getValue();
    }

    public static void main(String[] args) {
        minStack minStack = new minStack();
        minStack.push(10);
        minStack.push(2);
        minStack.push(5);
        minStack.push(1);
        minStack.push(3);
        minStack.push(4);
        System.out.println(minStack.pop());
        System.out.println(minStack.pop());
        System.out.println(minStack.pop());
        System.out.println(minStack.pop());
        System.out.println(minStack.pop());
        System.out.println(minStack.peekMin());
    }
}
