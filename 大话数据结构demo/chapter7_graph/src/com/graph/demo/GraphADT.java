package com.graph.demo;

import java.util.HashSet;

/**
 * @author 欧欧
 * @version 1.0
 */
public class GraphADT<E> {
//    public E data;
//
//
//    // 按照顶点集V和边弧集Vr的定义，构造图G
//    public Graph CreateGraph(HashSet<E> V, HashSet<E> Vr) {
//
//    };
//
//    // 图G存在则销毁
//    public void Destr0yGraph(Graph G) {
//
//    };
//
//    // 若图G中存在定点u， 则返回图中的位置
//    public int LocateVex(Graph G, Vertex u) {};
//
//    // 返回图中顶点V的值
//    public E GetVex(Graph G, Vertex v) {};
//
//    // 将图G中顶点v赋值value
//    public void PutVex(Graph G, Vertex u, int value) {};
//
//    // 返回顶点v的第一个邻接顶点，若顶点在G中无邻接顶点则返回空
//    public Vertex FirstAdjVex(Graph G, Vertex v) {};
//
//    // 返回顶点v相对于顶点w的下一个邻接顶点，若w是v的最后一个领接顶点则返回空
//    public Vertex nextAdjVex(Graph G, Vertex u, Vertex w) {};
//
//    // 在图G中新增顶点v
//    public void insertVex(Graph G, Vertex v) {};
//
//    // 删除图G中顶点v及其相关弧
//    public void deleteVex(Graph G, Vertex v) {};
//
//    // 在图G中新增弧<v, w>, 若G是无向图，还需新增对称弧<w, v>
//    public void insertArc(Graph G, Vertex v, Vertex w) {};
//
//    // 在图G中删除弧<v, w>, 若G是无向图，还需删除对称弧<w, v>
//    public void deleteArc(Graph G, Vertex v, Vertex w) {};
//
//    // 深度优先遍历图
//    public void DFSTraverse(Graph G) {};
//
//    // 广度优先遍历图
//    public void HFSTraverse(Graph G) {};
public static void main(String[] args) {
    Vertex v0 = new Vertex("A");
    Vertex v1 = new Vertex("B");
    Vertex v2 = new Vertex("C");
    Vertex v3 = new Vertex("D");
    Vertex v4 = new Vertex("E");
    Vertex[] vexs = {v0, v1, v2, v3, v4};
    int[][] arcs = {{0, -9999, -9999, -9999, 6},
                    {9, 0, 3, -9999, -9999},
                    {2, -9999, 0, 5, -9999},
                    {-9999, -9999, -9999, 0, 1},
                    {-9999, -9999, -9999, -9999, 0}};

    Graph g1 = new Graph(vexs, arcs);
    System.out.println(g1.maxNode);
    System.out.println(g1.numVertexes);
    System.out.println(g1.numEdges);
}

}


class Graph{
    int maxNode = 100;
    int nullValue = -9999;
    int numVertexes;
    int numEdges;

    Vertex[] vexsTable;
    int[][] arcTable;

    public Graph(Vertex[] vexsTable, int[][] arcTable) {
        this.vexsTable = vexsTable;
        this.arcTable = arcTable;
        this.numVertexes = vexsTable.length;
        for (int i = 0; i < this.numVertexes;i++) {
            for (int j = 0; j < this.numVertexes;j++) {
                if (this.arcTable[i][j] != nullValue) {
                    this.numEdges++;
                }

            }
        }
    }

}

class Vertex {
   String data;
   public Vertex(String data) {
       this.data = data;
   }

}

class VertexLinked {}

class GraphLinked {

}