package com.algorithms;

public class my_Queue {
    private long[] arr;
    private int elements;
    private int front;
    private int end;
    //默认构造方法
    public my_Queue() {
        arr = new long[10];
        elements = 0;
        front = 0;
        end = -1;
    }

    //参数为数组大小的构造方法
    public my_Queue(int maxsize) {
        arr = new long[maxsize];
        elements = 0;
        front = 0;
        end = -1;
    }

    //添加，队尾插入
    public void insert(long value) {
        if (end == arr.length - 1) {
            end = -1;
        }
        arr[++end] = value;
        elements++;
    }


    //删，从队头删x
    public long remove() {
        long value = arr[front++];
        if (front == arr.length) {
            front = 0;
        }
        elements--;
        return value;
    }

    //查，查看队头
    public long peek() {
        return arr[front];
    }

    //是否为空
    public boolean isEmpty() {
        return elements==0;
    }

    //是否满了
    public boolean isFull() {
        return elements == arr.length;
    }
}
