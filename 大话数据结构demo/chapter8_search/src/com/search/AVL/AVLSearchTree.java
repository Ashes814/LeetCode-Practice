package com.search.AVL;

import com.search.AVL.BiTNode;

/**
 * @author 欧欧
 * @version 1.0
 */
public class AVLSearchTree {
    public static BiTNode p_ = new BiTNode(0, null, null);

    public static boolean searchBST(BiTNode T, int key, BiTNode f, BiTNode p) {
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

    public static boolean insertBST(BiTNode T, int key) {
        if (!searchBST(T, key, null, p_)) {
            BiTNode s = new BiTNode(key, null, null);
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

    public static boolean Delete(BiTNode p) {
        BiTNode q, s;
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

    public static boolean deleteBST(BiTNode T, int key) {
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

    public void rRotate(BiTNode p) {
        BiTNode L;
        L = p.lchild;
        p.lchild = L.rchild;
        L.rchild = p;
        p = L;
    }

    public void lRotate(BiTNode p) {
        BiTNode R;
        R = p.rchild;
        p.rchild = R.lchild;
        R.lchild = p;
        p = R;
    }

    public void leftBalance(BiTNode T) {
        /**
         * 传入一个需要调整平衡性的子树T
         * 此时确认当前子树不平衡，左子树高度大于右子树，因此T.bf > 1
         */
        BiTNode L,Lr;
        // 将T的左孩子赋值给L
        L = T.lchild;
        switch (L.bf) {
            case 1:
                // 当L的bf为1时，表明L与根节点符号相同
                // 将L与T的bf改成0
                T.bf = L.bf = 0;
                // 右旋
                rRotate(T);
                break;
            case -1:
                // 当L的bf为1时，表明L与根节点符号相反
                // 做双旋处理
                Lr = L.rchild;
                switch (Lr.bf) {
                    // 判断Lr的平衡因子bf，调整T与L的bf
                    case 1:
                        T.bf = -1;
                        L.bf = 0;
                        break;
                    case 0:
                        T.bf = L.bf = 0;
                        break;
                    case -1:
                        T.bf = 0;
                        L.bf = 1;
                        break;
                }
                Lr.bf = 0;
                //T的左子树左旋
                lRotate(T.lchild);
                //T右旋
                rRotate(T);
        }
    }
    public void rightBalance(BiTNode T) {

        BiTNode R,Rl;

        R = T.rchild;
        switch (R.bf) {
            case 1:

                T.bf = R.bf = 0;
                // 右旋
                lRotate(T);
                break;
            case -1:

                Rl = R.rchild;
                switch (Rl.bf) {

                    case 1:
                        T.bf = -1;
                        R.bf = 0;
                        break;
                    case 0:
                        T.bf = R.bf = 0;
                        break;
                    case -1:
                        T.bf = 0;
                        R.bf = 1;
                        break;
                }
                Rl.bf = 0;

                rRotate(T.lchild);

                lRotate(T);
        }
    }

    public boolean insertAVL(BiTNode T, int e, boolean taller) {

        // T为空时，新增一个节点
        if (T == null) {
            T = new BiTNode(e, null, null);
            T.bf = 0;
            taller = true;
        } else {

            //存在相同结的，则不插入
            if (e == T.data) {
                taller = false;
                return false;
            }

            // 左子树查找
            if (e < T.data) {
                // 递归调用，找到则返回false否则插入成功
                if (!insertAVL(T.lchild, e, taller)) {
                    return false;
                }

                if (taller) {
                    // taller为ture说明插入成功，判断平衡因子，0， -1说明仍然平衡，否则调用左平衡
                    switch (T.bf) {
                        case 1:
                            leftBalance(T);
                            taller = false;
                            break;
                        case 0:
                            T.bf = 1;
                            taller = true;
                            break;
                        case -1:
                            T.bf = 0;
                            taller = false;
                            break;
                    }
                }
            } else {
                if (!insertAVL(T.rchild, e, taller)) {
                    return false;
                }
                // taller为ture说明插入成功，判断平衡因子，0， 1说明仍然平衡，否则调用右平衡
                if (taller) {
                    switch (T.bf) {
                        case 1:
                            T.bf = 0;
                            taller = false;
                            break;

                        case 0:
                            T.bf = -1;
                            taller = true;
                            break;
                        case -1:
                            rightBalance(T);
                            taller = false;
                            break;
                    }
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        BiTNode tree =                               new BiTNode(62,
                                 new BiTNode(58,
                        new BiTNode(47, new BiTNode(35, null, new BiTNode(37, null, null)),
                        new BiTNode(51, null, null)), null),
                new BiTNode(88, new BiTNode(73, null, null),
                        new BiTNode(99, new BiTNode(93, null, null), null)));

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
    int bf;
    BiTNode lchild, rchild;

    public BiTNode(int data, BiTNode lchild, BiTNode rchild) {
        this.data = data;
        this.lchild = lchild;
        this.rchild = rchild;
    }
}