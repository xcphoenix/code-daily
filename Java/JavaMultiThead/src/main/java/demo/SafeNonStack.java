package demo;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author      xuanc
 * @date        2020/3/8 下午5:13
 * @version     1.0
 */ 
public class SafeNonStack<E> {

    private AtomicReference<Node<E>> head = new AtomicReference<>();
    private AtomicInteger size = new AtomicInteger(0);

    public void push(E e) {
        if (e == null) {
            throw new IllegalArgumentException();
        }
        Node<E> oldHead;
        Node<E> newHead;
        do {
            // 如果循环多次，说明节点被更新，重新获取，并尝试 CAS
            oldHead = head.get();
            newHead = new Node<>(e, oldHead);
        } while (!head.compareAndSet(oldHead, newHead));
        sizeIncrement();
    }

    public E pop() {
        if (head.get() == null) {
            return null;
        }
        E item;
        Node<E> newHead;
        Node<E> oldHead;
        do {
            oldHead = head.get();
            newHead = oldHead.getNext();
            item = oldHead.getItem();
        } while (!head.compareAndSet(oldHead, newHead));
        sizeDecrement();
        return item;
    }

    private void sizeIncrement() {
        size.incrementAndGet();
    }

    private void sizeDecrement() {
        size.decrementAndGet();
    }

    public static void main(String[] args) {
        SafeNonStack<String> stack = new SafeNonStack<>();
        stack.push("Hello");
        stack.push("dream");
        System.out.println(stack.pop());
        stack.push("test");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        stack.push("last");
    }

    private static class Node<E> {
        private final E item;
        private volatile Node<E> next;

        public Node(E item, Node<E> next) {
            this.item = item;
            this.next = next;
        }

        public E getItem() {
            return item;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }

}
