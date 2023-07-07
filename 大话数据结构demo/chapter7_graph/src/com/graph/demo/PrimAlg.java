package com.graph.demo;

import java.util.ArrayList;

/**
 * @author 欧欧
 * @version 1.0
 */
public class PrimAlg {
    public int[][] neighborMartrix = {{0, 10, 9999, 9999, 9999, 11, 9999, 9999, 9999},
            {10, 0, 18, 9999, 9999, 9999, 16, 9999, 12},
            {9999, 9999, 0, 22, 9999, 9999, 9999, 9999, 8},
            {9999, 9999, 22, 0, 20, 9999, 9999, 16, 21},
            {9999, 9999, 9999, 20, 0, 26, 9999, 7, 9999},
            {11, 9999, 9999, 9999, 26, 0, 17, 9999, 9999},
            {9999, 16, 9999, 9999, 9999, 17, 0, 19, 9999},
            {9999, 9999, 9999, 16, 7, 9999, 19, 0, 9999},
            {9999, 12, 8, 21, 9999, 9999, 9999, 9999, 0}};



}

class MGraph {
    int numVertexes;
    int[][] arc;

    MGraph(int numVertexes, int[][] arc) {
        this.numVertexes = numVertexes;
        this.arc = arc;

    }


}

class MainSpanTreePrim {
    public MGraph G;
    public int min;
    public int i;
    public int j;
    public int k;
    public int MAXVEX;
    public int[] adjvex;
    public int[] lowcost;
    public int INFINITY = 9999;
    MainSpanTreePrim(MGraph G, int MAXVEX) {
        // initialization
        this.MAXVEX = MAXVEX;
        this.G = G;
        this.adjvex = new int[MAXVEX];
        this.lowcost = new int[MAXVEX];
        adjvex[0] = 0;
        lowcost[0] = 0;
        for (int i = 1; i < G.numVertexes; i++) {
            lowcost[i] = G.arc[0][i];
            adjvex[i] = 0;
        }
        // constructor minimum generator tree
        for (int i = 1; i < G.numVertexes; i++) {
            min = INFINITY;
            j = 1;
            k = 0;
            while (j < G.numVertexes) {
                if(lowcost[j] != 0 && lowcost[j] < INFINITY){
                    min = lowcost[j];
                    k = j;
                }
                j++;
            }
            System.out.println(k);
            System.out.println(adjvex[k]);
            lowcost[k] = 0;
            for (int j = 0; j < G.numVertexes; j++) {
                if(lowcost[j] != 0 && G.arc[k][j] < lowcost[j]) {
                    lowcost[j] = G.arc[k][j];
                    adjvex[j] = k;
                }
            }
        }

    }
}