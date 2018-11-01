package StacksAndQueues;

import CtCILibrary.AssortedMethods;

import java.util.Stack;

public class SortStack_3_5 {

    public static void sort(Stack<Integer> s) {
        Stack<Integer> r = new Stack<>();
        while (!s.isEmpty()) {
            // insert each element in s in sorted order into r
            int temp = s.pop();
            while (!r.isEmpty() && r.peek() > temp) {
                s.push(r.pop());
            }
            r.push(temp);
        }

        // copy the elements bach
        while (!r.isEmpty()) {
            s.push(r.pop());
        }
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < 10; i++) {
            int r = AssortedMethods.randomIntInRange(0, 1000);
            s.push(r);
        }

        sort(s);

        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }
}
