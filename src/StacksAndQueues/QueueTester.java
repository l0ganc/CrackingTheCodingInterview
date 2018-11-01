package StacksAndQueues;

import CtCILibrary.AssortedMethods;

public class QueueTester {

    public static void main(String[] args) {
        int[] array = AssortedMethods.randomArray(100, -100, 100);
        MyQueue<Integer> queue1 = new MyQueue<>();
        queue1.add(2);
        queue1.add(4);
        queue1.add(5);
        System.out.println(queue1.peek());
        System.out.println(queue1.remove());
        System.out.println(queue1.peek());
    }
}
