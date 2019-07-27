package com.algorithms;

public class HanoiTower {
    public static void main(String[] args) {
        doTower(15, 'A', 'B', 'C');
    }

    public static void doTower(int topN, char from, char inter, char to) {
        if (topN == 1) {
            System.out.println("盘子1，从" + from + "塔座到" + to + "塔座");
        } else {
            doTower(topN - 1, from, to, inter);
            System.out.println("盘子" + topN + "，从" + from + "塔座到" + to + "塔座");
            doTower(topN - 1, inter, from, to);
        }
    }
}
