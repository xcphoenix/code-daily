package top.xcphoenix.algorithm.datastruct.queue_stack;

import java.util.*;
import java.util.stream.StreamSupport;

/**
 * @author      xuanc
 * @date        2020/4/4 下午6:17
 * @version     1.0
 */ 
public class QueueByStack<E> extends AbstractQueue<E> {

    private int size = 0;
    private Stack<E> left = new Stack<>();
    private Stack<E> right = new Stack<>();

    @Override
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean offer(E o) {
        left.push(o);
        size++;
        return false;
    }

    @Override
    public E poll() {
        dealPoll();
        size--;
        return right.pop();
    }

    @Override
    public E peek() {
        dealPoll();
        return right.peek();
    }

    private void dealPoll() {
        if (right.empty()) {
            while (!left.empty()) {
                right.push(left.pop());
            }
        }
    }

    public static void main(String[] args) {
        QueueByStack<String> queueByStack = new QueueByStack<>();
        Queue<String> queue = new LinkedList<>();

        for (int i = 0; i < 1000; i++) {
            int num = new Random().nextInt(3);
            switch (num) {
                case 0: {
                    System.out.println("OP >> push");
                    String string = new String(UUID.randomUUID().toString());
                    queue.offer(string);
                    queueByStack.offer(string);
                    break;
                }
                case 1: {
                    System.out.println("OP >> peek");
                    if (queue.isEmpty()) {
                        if (!queueByStack.isEmpty()) {
                            throw new RuntimeException("ERROR");
                        }
                        System.out.println("\tqueue is empty");
                        continue;
                    }
                    String str = queue.peek();
                    String str2 = queueByStack.peek();
                    if (!str.equals(str2)) {
                        System.out.println("\t" + str + ", " + str2);
                        throw new RuntimeException();
                    }
                    break;
                }
                case 2: {
                    System.out.println("OP >> poll");
                    if (queue.isEmpty()) {
                        if (!queueByStack.isEmpty()) {
                            throw new RuntimeException("ERROR");
                        }
                        System.out.println("\tqueue is empty");
                        continue;
                    }
                    String str = queue.poll();
                    String str2 = queueByStack.poll();
                    if (!str.equals(str2)) {
                        System.out.println("\t" + str + ", " + str2);
                        throw new RuntimeException();
                    }
                    break;
                }
                default:
                    throw new RuntimeException();
            }
        }

    }


}
