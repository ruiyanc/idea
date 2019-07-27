package com.algorithms;

public class FirstLastLink_List {
    private Node first;
    private Node last;
    public FirstLastLink_List() {
        first = null;
        last = null;
    }

    //插入结点，在头结点后插入
    public void insertFirst(long value) {
        Node node = new Node(value);
        node.next = first;
        first = node;
    }

    //删除结点，在头结点后进行删除
    public Node deleteFirst() {
        Node tmp = first;
        first = tmp.next;
        return tmp;
    }

    //显示
    public void display() {
        Node current = first;
        while (current != null) {
            current.display();
            current = current.next;
        }
    }


    //查找
    public Node find(long value) {
        Node current = first;
        while (current.item != value) {
            if (current.next == null) {
                return null;
            }
            current = current.next;
        }
        return current;
    }
}



