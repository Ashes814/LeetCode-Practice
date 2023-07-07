package com.graph.demo;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author 欧欧
 * @version 1.0
 */
public class AOVSort {
    public static void main(String[] args) {
        GraphAdjList graphAdjList = new GraphAdjList(14);

        graphAdjList.adjList[0] = new VertexNode(0, "V0", new EdgeNode(11, new EdgeNode(5, new EdgeNode(4, null))));
        graphAdjList.adjList[1] = new VertexNode(0, "V1", new EdgeNode(8, new EdgeNode(4, new EdgeNode(2, null))));
        graphAdjList.adjList[2] = new VertexNode(2, "V2", new EdgeNode(9, new EdgeNode(6, new EdgeNode(5, null))));
        graphAdjList.adjList[3] = new VertexNode(0, "V3", new EdgeNode(13, new EdgeNode(2,null)));
        graphAdjList.adjList[4] = new VertexNode(2, "V4", new EdgeNode(7, null));
        graphAdjList.adjList[5] = new VertexNode(3, "V5", new EdgeNode(12, new EdgeNode(8, null)));
        graphAdjList.adjList[6] = new VertexNode(1, "V6", new EdgeNode(5, null));
        graphAdjList.adjList[7] = new VertexNode(2, "V7", null);
        graphAdjList.adjList[8] = new VertexNode(2, "V8", new EdgeNode(7, null));
        graphAdjList.adjList[9] = new VertexNode(1, "V9", new EdgeNode(11, new EdgeNode(10, null)));
        graphAdjList.adjList[10] = new VertexNode(1, "V10", new EdgeNode(13, null));
        graphAdjList.adjList[11] = new VertexNode(2, "V11",null);
        graphAdjList.adjList[12] = new VertexNode(1, "V12", new EdgeNode(9, null));
        graphAdjList.adjList[13] = new VertexNode(2, "V13", null);

        TopologicalSort ts = new TopologicalSort(graphAdjList);
        System.out.println(ts.startSort());
    }
}

class EdgeNode {
    int adjvex;
    int weight;

    EdgeNode next;

    public EdgeNode(int adjvex, EdgeNode next) {
        this.adjvex = adjvex;
        this.next = next;
    }
}

class VertexNode {
    int in;
    String data;
    EdgeNode firstEdge;

    public VertexNode(int in, String data, EdgeNode firstEdge) {
        this.in = in;
        this.data = data;
        this.firstEdge = firstEdge;
    }
}

class GraphAdjList {
    int numVertexes;
    VertexNode[] adjList;

    public GraphAdjList(int numVertexes) {
        this.numVertexes = numVertexes;
        adjList = new VertexNode[numVertexes];
    }
}

class TopologicalSort {
    EdgeNode e;
    int i, k, gettop;
    int top = 0;
    int count = 0;
    Stack<Integer> stack = new Stack<>();
    GraphAdjList GL;

    public TopologicalSort(GraphAdjList GL) {
        this.GL = GL;

    }

    public String startSort() {
        for (i = 0; i < GL.numVertexes; i++) {
            if (GL.adjList[i].in == 0) {
                stack.push(i);
            }
        }

        while (!stack.empty()) {
            gettop = stack.pop();
            System.out.println(GL.adjList[gettop].data);
            count++;
            EdgeNode e = GL.adjList[gettop].firstEdge;
            while (e != null) {
                k = e.adjvex;
//                System.out.println(k);
                if((--GL.adjList[k].in) == 0) {
                    stack.push(k);
                }
                e = e.next;
            }

        }

        if (count < GL.numVertexes) {
            return "Error";
        } else {
            return "OK";
        }
    }

}
