package com.commpay;

import java.io.Serializable;

public class 对象序列化 {
}

class Data implements Serializable {
    private int n;

    public Data(int n) {
        this.n = n;
    }

    @Override
    public String toString() {
        return "Data{" +
                "n=" + n +
                '}';
    }
}
