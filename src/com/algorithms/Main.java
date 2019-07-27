package com.algorithms;

import java.util.*;
import java.util.Stack;

public class Main {
    // Iterable是接口，Iterator是迭代器类，
    // 所有collection子类都会实现Iterable接口来实现foreach功能
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.addFirst(5);
        linkedList.addFirst(10);
        linkedList.addFirst(1);
        for (Integer s:linkedList) {
            System.out.println(s);
        }
        Scanner scanner = new Scanner(System.in);

        Stack<String> stack = new Stack<>();
        Stack<Double> values = new Stack<>();
        while (scanner != null) {
            String s = scanner.next();
            if (s.equals("("));
            else if (s.equals("+")) {
                stack.push(s);
            } else if (s.equals("-")) {
                stack.push(s);
            } else if (s.equals("*")) {
                stack.push(s);
            } else if (s.equals("/")) {
                stack.push(s);
            } else if (s.equals(")")) {
                String op = stack.pop();
                double v = values.pop();
                if (op.equals("+")) v = values.pop() + v;
                else if (op.equals("-")) {
                    v = values.pop() - v;
                } else if (op.equals("*")) {
                    v = values.pop() * v;
                } else if (op.equals("/")) {
                    v = values.pop() / v;
                }
                values.push(v);
            } else {
                values.push(Double.parseDouble(s));
            }
        }
        System.out.println(values.pop());

    }
}
