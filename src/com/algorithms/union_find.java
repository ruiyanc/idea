package com.algorithms;

public class union_find {
    /*
     * 并查集算法，解决动态连通性
     */
    private int[] id;
    private int count;

    public union_find(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    public int count() {
        return count;
    }

    /**
     *quick-find算法，find（）= O（1）
     *每一对输入union（）都遍历一次数组O（n^2）
     */
   /* public int find(int p) {
        return id[p];
    }
    public void union(int p, int q) {
        int pID = find(p);
        int qID = find(q);
        if (pID == qID) return;
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pID) id[i] = qID;
        }
        count--;
    }
    */
    /**
     * quick-union算法，运用树的结构，检查是否位于一个根节点
     * find(n)=id[id[id[n]]]
     */

    private int find(int p) {
        while (p != id[p]) {
            p = id[p];
        }
        return p;
    }

    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) {
            return;
        }
        id[pRoot] = qRoot;
        count--;
    }
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }
}

