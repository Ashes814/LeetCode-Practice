package com.tree_.deom;

import java.util.Scanner;

/**
 * @author 欧欧
 * @version 1.0
 */
public class BiTree {
    public static void main(String[] args) {

    }

}


class Node {
    String data;
    Node left;
    Node right;

    Node(String data) {
        this.data = data;
        left = null;
        right = null;

    }
}


class BifurTree {
    Node root;


    public BifurTree() {
        root = null;
    }

    public void insert(String data) {
        root = insert(root, data);
    }

    public Node insert(Node node, String data) {
        if (node == null) {
            return new Node(data);
        } else {
            if (node.right == null) {
                node.right = insert(node.right, data);
            } else {
                node.left = insert(node.left, data);
            }
        }
        return node;
    }
}
