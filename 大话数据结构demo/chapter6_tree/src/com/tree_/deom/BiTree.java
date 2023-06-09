package com.tree_.deom;

import java.util.Scanner;

/**
 * @author 欧欧
 * @version 1.0
 */
public class BiTree {
    public static void main(String[] args) {
        BifurTree bifurTree = new BifurTree();
        Scanner scanner = new Scanner(System.in);
        String data;
        data = scanner.next();
        createByFor(bifurTree, data);
    }

    public static void createByFor(BifurTree tree, String data) {

        if (data.equals("exit")) {
            return;
        }
        if (data.equals("#")) {
            tree = null;
        } else {
            tree = new BifurTree(data);
            createByFor(tree.left, data);
            createByFor(tree.right, data);

        }


    }

}


class Node {
    String data;
    BifurTree left;
    BifurTree right;

    Node() {
        this.data = null;
    }
    Node(String data) {
        this.data = data;

    }
}


class BifurTree {

    String data;
    BifurTree left;
    BifurTree right;
    public BifurTree() {

    }
    public BifurTree(String data) {
        this.data = data;
        this.left = new BifurTree();
        this.right = new BifurTree();
    }
}