package com.company;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class Test {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new ArrayDeque<>();
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8};
        for (int i = 0; i < a.length; i++) {
            stack.push(a[i]);
            queue.add(i);
        }
        System.out.println(stack.search(3));
//        while (stack.size() != 2) {
//            stack.pop();
//        }
//        for (Integer i:stack) {
//            System.out.println(i);
//        }
        for (Integer i:queue) {
            System.out.println(i);
        }
    }

}
