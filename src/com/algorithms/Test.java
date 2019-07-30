package com.algorithms;

public class Test {

    public static void main(String[] args) {
        Link_List link_list = new Link_List();
        link_list.insertFirst(5);
        link_list.insertFirst(4);
        link_list.insertFirst(3);
        link_list.find(5);
        link_list.display();
/*
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
*/
    }

}
