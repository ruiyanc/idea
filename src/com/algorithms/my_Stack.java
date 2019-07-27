package com.algorithms;

public class my_Stack{
    private long[] arr;
    private int top;
    //默认的构造方法
    public my_Stack(){
        arr = new long[10];
        top = -1;
    }
    //带参数的，参数为数组初始化大小
    public my_Stack(int maxsize) {
        arr = new long[maxsize];
        top = -1;
    }
    //添加
    public void push(int value) {
        arr[++top] = value;
    }

    //删除
    public long pop() {
        return arr[top--];
    }

    //查看
    public long peek() {
        return arr[top];
    }

    //查看是否为空
    public boolean isEmpty() {
        return top==-1;
    }

    //是否栈满
    public boolean isFull() {
        return top == arr.length - 1;
    }
}