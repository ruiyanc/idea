package com.commpay;

import java.io.*;
import java.util.Random;

public class Worn implements Serializable{
    private static Random r = new Random(47);
    private Data[] data = {
            new Data(r.nextInt(10)),
            new Data(r.nextInt(10)),
            new Data(r.nextInt(10))
    };
    private Worn next;
    private char c;
    public Worn(int i, char x) {
        System.out.println("Worm constructor:" + i);
        c = x;
        if (--i > 0) {
            next = new Worn(i, (char) (x + 1));
        }
    }

    public Worn() {
        System.out.println("default constructor");
    }

    @Override
    public String toString() {
        StringBuffer result = new StringBuffer();
        result.append(c);
        result.append("(");
        for (Data datum : data) {
            result.append(datum);
        }
        result.append(")");
        if (next != null) {
            result.append(next);
        }
        return result.toString();
    }

    public static void main(String[] args) throws Exception{
        Worn w = new Worn(6, 'a');
        System.out.println("w = " + w);
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("worm.out"));
        out.writeObject("Worm storage");
        out.writeObject(w);
        out.close();
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("worm.out"));
        String s = (String) in.readObject();
        Worn w2 = (Worn) in.readObject();
        System.out.println(s + "w2 = " + w2);
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        ObjectOutputStream out2 = new ObjectOutputStream(bout);
        out2.writeObject("Worm storage\n");
        out2.writeObject(w);
        out2.flush();
        ObjectInputStream in2 = new ObjectInputStream(new ByteArrayInputStream(bout.toByteArray()));
        s = (String) in2.readObject();
        Worn w3 = (Worn) in2.readObject();
        System.out.println(s + "w3 = " + w3);
    }
}

class Data implements Serializable {
    private int n;

    public Data(int n) {
        this.n = n;
    }

    @Override
    public String toString() {
        return Integer.toString(n);
    }
}
