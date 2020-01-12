package Algorithm_lou.queue;

//数组实现循环队列，为了判断队列是否为空，可以通过预留1个空位的方法实现
public class CircularQueue {
    int[] queue;
    int front;
    int rear;
    int n;

    public CircularQueue(int n) {
        this.n = n + 1;
        queue = new int[n + 1];
        front = 0;
        rear = 0;
    }

    public boolean enQueue(int val) {
        if(isFull()){
            return false;
        }
        queue[rear]=val;
        rear = (rear + 1) % n;
        return true;
    }

    public boolean deQueue(){
        if (isEmpty()) {
            return false;
        }
        queue[front] = 0;
        front = (front + 1) % n;
        return true;
    }

    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return queue[front];
    }

    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        return queue[(rear - 1 + n) % n];
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public boolean isFull() {
        return (rear + 1) % n == front;
    }

    public static void main(String[] args) {
        CircularQueue q = new CircularQueue(3);
        System.out.println(q.isEmpty());
        q.enQueue(1);
        System.out.println(q.isFull());
        q.enQueue(2);
        System.out.println(q.isFull());
        q.enQueue(3);
        System.out.println(q.isFull());
        System.out.println(q.getFront());
        System.out.println(q.getRear());
        q.deQueue();
        System.out.println(q.getRear());
        System.out.println(q.getFront());
        q.deQueue();
        q.deQueue();
        System.out.println(q.isEmpty());
        System.out.println(q.isFull());
    }
}
