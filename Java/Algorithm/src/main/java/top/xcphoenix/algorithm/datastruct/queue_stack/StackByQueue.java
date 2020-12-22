package top.xcphoenix.algorithm.datastruct.queue_stack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author      xuanc
 * @date        2020/4/4 下午6:37
 * @version     1.0
 */ 
public class StackByQueue<E> extends Stack<E> {

    private Queue<E> queue = new LinkedList<>();

    @Override
    public E push(E item) {
        queue.offer(item);
        return item;
    }

    @Override
    public synchronized E pop() {
        int size = queue.size();
        while (--size >= 0) {
            E item = queue.poll();
            queue.offer(item);
        }
        return queue.poll();
    }

    @Override
    public synchronized E peek() {
        int size = queue.size();
        while (--size >= 0) {
            E item = queue.poll();
            queue.offer(item);
        }
        return queue.peek();
    }

    @Override
    public boolean empty() {
        return super.empty();
    }

    public static void main(String[] args) {
        StackByQueue<String> stackByQueue = new StackByQueue<>();
        stackByQueue.push("1");
        stackByQueue.push("2");
        stackByQueue.push("3");
        System.out.println(stackByQueue.pop());
        System.out.println(stackByQueue.pop());
        stackByQueue.push("4");
        System.out.println(stackByQueue.pop());
        System.out.println(stackByQueue.pop());
    }

}
