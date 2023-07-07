package com.search;

/**
 * @author 欧欧
 * @version 1.0
 */
public class BinarySearchTree {
    public static com.search.AVL.BiTNode p_ = new com.search.AVL.BiTNode(0, null, null);

    public static boolean searchBST(com.search.AVL.BiTNode T, int key, com.search.AVL.BiTNode f, com.search.AVL.BiTNode p) {
        if (T == null) {
            p_ = f;
            return false;
        } else if (key == T.data) {
            p_ = T;
            return true;
        } else if (key < T.data) {
            return searchBST(T.lchild, key, T, p_);
        } else {
            return searchBST(T.rchild, key, T, p_);
        }

    }

    public static boolean insertBST(com.search.AVL.BiTNode T, int key) {
        if (!searchBST(T, key, null, p_)) {
            com.search.AVL.BiTNode s = new com.search.AVL.BiTNode(key, null, null);
            if (p_ == null) {
                p_ = s;
            } else if (key < p_.data) {
                p_.lchild = s;
            } else {
                p_.rchild = s;
            }
            return true;

        } else {
            System.out.println("key found");
            return false;
        }
    }

    public static boolean Delete(com.search.AVL.BiTNode p) {
        com.search.AVL.BiTNode q, s;
        if (p.rchild == null) {
            q = p;
            p = p.lchild;

        } else if (p.lchild == null) {
            q = p;
            p = p.rchild;
        } else {
            q = p;
            s = p.lchild;
            while (s.rchild != null) {
                q = s;
                s = s.rchild;
            }
            p.data = s.data;
            if (q != p) {
                q.rchild = s.lchild;
            } else {
                q.lchild = s.lchild;
            }
        }
        return true;
    }

    public static boolean deleteBST(com.search.AVL.BiTNode T, int key) {
        if (!searchBST(T, key, null, null)) {
            return false;
        } else {
            if (key == T.data) {
                return Delete(T);
            } else if (key < T.data) {
                return  deleteBST(T.lchild, key);
            } else {
                return deleteBST(T.rchild, key);
            }
        }
    }
    public static void main(String[] args) {
        com.search.AVL.BiTNode tree =                               new com.search.AVL.BiTNode(62,
                                 new com.search.AVL.BiTNode(58,
                        new com.search.AVL.BiTNode(47, new com.search.AVL.BiTNode(35, null, new com.search.AVL.BiTNode(37, null, null)),
                        new com.search.AVL.BiTNode(51, null, null)), null),
                new com.search.AVL.BiTNode(88, new com.search.AVL.BiTNode(73, null, null),
                        new com.search.AVL.BiTNode(99, new com.search.AVL.BiTNode(93, null, null), null)));

        boolean res = searchBST(tree, 93, null, p_);
        System.out.println(res);
        System.out.println(p_.data);
        System.out.println(insertBST(tree, 93));
        System.out.println(insertBST(tree, 100));
        System.out.println(p_.data);
        System.out.println(p_.rchild.data);
    }
}

class BiTNode {
    int data;
    com.search.AVL.BiTNode lchild, rchild;

    public BiTNode(int data, com.search.AVL.BiTNode lchild, com.search.AVL.BiTNode rchild) {
        this.data = data;
        this.lchild = lchild;
        this.rchild = rchild;
    }
}