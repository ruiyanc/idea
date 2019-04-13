package com.company;

import java.util.Stack;

public class Graph{
    //顶点数组
    private Vertex[] vertexList;
    //邻接矩阵
    private int[][] ajdMat;
    private int maxSize = 20;
    //当前顶点
    private int nVertex;
    public my_Stack stack;

    public Graph() {
        vertexList = new Vertex[maxSize];
        ajdMat = new int[maxSize][maxSize];
        for (int i = 0; i < maxSize; i++) {
            for (int j = 0; j < maxSize; j++) {
                ajdMat[i][j] = 0;
            }
        }
        nVertex = 0;
    }

    /**添加顶点*/
    public void addVertex(char label) {
        vertexList[nVertex++] = new Vertex(label);
    }

    /**添加边*/
    public void addEdge(int start, int end) {
        ajdMat[start][end] = 1;
        ajdMat[end][start] = 1;
    }

    public int getadjUnvisitedVertex(int v) {
        for (int i = 0; i < nVertex; i++) {
            if (ajdMat[v][i] == 1 && vertexList[i].wasVisited == false) {
                return i;
            }
        }
        return -1;
    }

    /**深度优先遍历*/
    public void dfs() {
        //首先访问零号顶点
        vertexList[0].wasVisited = true;
        displayVertex(0);
        stack.push(0);
        while (!stack.isEmpty()) {
            //获得一个未访问的邻接点
            int v = getadjUnvisitedVertex((int) stack.peek());
            if (v == -1) {
                stack.pop();
            } else {
                vertexList[v].wasVisited = true;
                displayVertex(v);
                stack.push(v);
            }
        }
        for (int i = 0; i < nVertex; i++) {
            vertexList[i].wasVisited = false;
        }
    }

    public void displayVertex(int v) {
        System.out.println(vertexList[v].label);
    }
}


class Vertex{
    public char label;
    public boolean wasVisited;

    Vertex(char label) {
        this.label = label;
    }
}


