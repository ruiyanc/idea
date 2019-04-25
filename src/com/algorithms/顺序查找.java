package com.company;

public class 顺序查找 {
    public static void main(String[] args) {

    }
    public class SequentialSearchST<Key, Value> {
        private Node first;
        private class Node {
            Key key;
            Value value;
            Node next;

            public Node(Key key, Value value, Node next) {
                this.key = key;
                this.value = value;
                this.next = next;
            }
        }

        public Value get(Key key) {
            for (Node x = first; x != null; x = x.next) {
                if (key.equals(x.key)) {
                    return x.value;
                }
            }
            return null;
        }

        public void put(Key key, Value value) {
            for (Node x = first; x != null; x = x.next) {
                if (key.equals(x.key)) {
                    x.value = value;
                    return;
                }
                first = new Node(key, value, first);
            }
        }

        public int size(Key key, Value value) {
            int len = 0;
            for (Node x = first; x != null; x = x.next) {
                len++;
            }
            return len;
        }
    }
}
