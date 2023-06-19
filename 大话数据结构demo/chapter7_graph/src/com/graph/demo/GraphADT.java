package com.graph.demo;

import java.util.HashSet;

/**
 * @author 欧欧
 * @version 1.0
 */
public class GraphADT<E> {
    public E data;


    // 按照顶点集V和边弧集Vr的定义，构造图G
    public Graph CreateGraph(HashSet<E> V, HashSet<E> Vr) {

    };

    // 图G存在则销毁
    public void Destr0yGraph(Graph G) {

    };

    // 若图G中存在定点u， 则返回图中的位置
    public int LocateVex(Graph G, Vertex u) {};

    // 返回图中顶点V的值
    public E GetVex(Graph G, Vertex v) {};

    // 将图G中顶点v赋值value
    public void PutVex(Graph G, Vertex u, int value) {};

    // 返回顶点v的第一个邻接顶点，若顶点在G中无邻接顶点则返回空
    public Vertex FirstAdjVex(Graph G, Vertex v) {};

    // 返回顶点v相对于顶点w的下一个邻接顶点，若w是v的最后一个领接顶点则返回空
    public Vertex nextAdjVex(Graph G, Vertex u, Vertex w) {};

    // 在图G中新增顶点v
    public void insertVex(Graph G, Vertex v) {};

    // 删除图G中顶点v及其相关弧
    public void deleteVex(Graph G, Vertex v) {};

    // 在图G中新增弧<v, w>, 若G是无向图，还需新增对称弧<w, v>
    public void insertArc(Graph G, Vertex v, Vertex w) {};

    // 在图G中删除弧<v, w>, 若G是无向图，还需删除对称弧<w, v>
    public void deleteArc(Graph G, Vertex v, Vertex w) {};

    // 深度优先遍历图
    public void DFSTraverse(Graph G) {};

    // 广度优先遍历图
    public void HFSTraverse(Graph G) {};

}


class Graph{

}

class Vertex {

}