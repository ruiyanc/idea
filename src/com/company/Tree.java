package com.company;

public class Tree {
    public TreeNode root;
    //插入
    public void insert(long value) {
        TreeNode newNode = new TreeNode(value);
        TreeNode current = root;
        //引用父节点
        TreeNode parent;
        if (root == null) {
            root = newNode;
            return;
        } else {
            while (true) {
                //父节点指向当前节点
                parent = current;
                //如果当前指向节点数据比插入的大，则向左走
                if (current.item > value) {
                    current = current.leftChild;
                    if (current == null) {
                        parent.leftChild = newNode;
                        return;
                    }
                } else {
                    current = current.rightChild;
                    if (current == null) {
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }

    //查找节点
    public TreeNode find(long value) {
        //从根节点开始
        TreeNode current = root;
        //循环，只要查找值不等于当前节点的数据
        while (current.item != value) {
            //进行比较，比较查找值和当前节点的大小
            if (current.item > value) {
                current = current.leftChild;
            } else {
                current = current.rightChild;
            }
            //如果查找不到
            if (current == null) {
                return null;
            }
        }
        return current;
    }

    //删除节点
    public boolean delete(long value) {
        TreeNode current = root;
//        引用当前节点的父节点
        TreeNode parent = root;
        //是否为左节点
        boolean isLeftChild = true;

        while (current.item != value) {
            parent = current;
            //进行比较，比较查找值和当前节点的大小
            if (current.item > value) {
                current = current.leftChild;
                isLeftChild = true;
            } else {
                current = current.rightChild;
                isLeftChild = false;
            }
            //如果查找不到
            if (current == null) {
                return false;
            }
        }
        //删除叶子节点
        if (current.rightChild == null && current.leftChild == null) {
            if (current == root) {
                root = null;
            }else if (isLeftChild) {
                parent.leftChild = null;
            } else {
                parent.rightChild = null;
            }
            //删除的节点只有一个子节点
        }else if (current.rightChild == null) {
            if (current == root) {
                root = current.leftChild;
            }else if (isLeftChild) {
                    parent.leftChild = current.leftChild;
                } else {
                    parent.rightChild = current.leftChild;
                }
        } else if (current.leftChild == null) {
            if (current == root) {
                root = current.rightChild;
            }else if (isLeftChild) {
                parent.leftChild = current.rightChild;
            }else{
                parent.rightChild = current.rightChild;
            }
        }else{
            //删除的节点有两个节点
            TreeNode successor = getSuccessor(current);
            if (current == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.leftChild = successor;
            }else {
                parent.rightChild = successor;
            }
            successor.leftChild = current.leftChild;
        }
        return true;
    }

    public TreeNode getSuccessor(TreeNode delNode) {
        //中序后继节点
        TreeNode successor = delNode;
        TreeNode successorParent = delNode;
        TreeNode current = delNode.rightChild;

        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.leftChild;
        }
        if (successor != delNode.rightChild) {
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = delNode.rightChild;
        }
        return successor;
    }
    /**
     * 前序遍历
     */
    public void frontOrder(TreeNode localNode) {
        if (localNode != null) {
            //访问根节点
            System.out.println(localNode.item);
            //前序遍历左子树
            frontOrder(localNode.leftChild);
            //前序遍历右子树
            frontOrder(localNode.rightChild);
        }
    }

    /**
     * 中序遍历
     */
    public void inOrder(TreeNode localNode) {
        if (localNode != null) {
            inOrder(localNode.leftChild);
            System.out.println(localNode.item);
            inOrder(localNode.rightChild);
        }
    }

    /**
     * 后序遍历
     */
    public void afterOrder(TreeNode localNode) {
        if (localNode != null) {
            afterOrder(localNode.leftChild);
            afterOrder(localNode.rightChild);
            System.out.println(localNode.item);
        }
    }

    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insert(10);
        tree.insert(20);
        tree.insert(15);
        tree.insert(25);
        tree.insert(55);
        tree.insert(18);
        tree.insert(5);

//        System.out.println(tree.root.item);
//        System.out.println(tree.root.rightChild.item);
//        System.out.println(tree.root.rightChild.leftChild.item);
//        System.out.println(tree.find(3));
//        tree.frontOrder(tree.root);
        tree.delete(20);
        tree.inOrder(tree.root);
    }
}

class TreeNode{
    public long item;
    public TreeNode leftChild;
    public TreeNode rightChild;

    public TreeNode(long item) {
        this.item = item;
    }
}
