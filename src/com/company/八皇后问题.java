package com.company;

public class 八皇后问题 {
    /** 8*8棋盘，以及map存方案结果数量*/
    public static int[][] arr = new int[8][8];
    public static int map = 0;

    public static void main(String[] args) {
        System.out.println("八皇后问题");
        findQueen(0);
        System.out.println("八皇后问题共有：" + map + "种可能");
    }

    public static void findQueen(int i) {
        if (i > 7) {
            map++;
            print();
            return;
        }
        for (int m = 0; m < 8; m++) {
            if (check(i, m)) {
                arr[i][m] = 1;
                findQueen(i + 1);
                arr[i][m] = 0;
            }
        }
    }

    public static boolean check(int k, int j) {
        for (int i = 0; i < 8; i++) {
            if (arr[i][j] == 1)
                return false;
        }
        //检查左对角线
        for (int i = k - 1, m = j - 1; i >= 0 && m >= 0; i--, m--) {
            if (arr[i][m] == 1)
                return false;
        }
        //检查右对角线
        for (int i = k - 1, m = j + 1; i >= 0 && m <= 7; i--, m++) {
            if (arr[i][m]==1)
                return false;
        }
        return true;
    }

    public static void print() {
        System.out.println("方案" + map + ":" + "\n");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (arr[i][j] == 1) {
//                    System.out.print("皇后"+(i+1)+"在第"+i+"行，第"+j+"列\t");
                    System.out.print("o ");
                } else {
                    System.out.print("+ ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
