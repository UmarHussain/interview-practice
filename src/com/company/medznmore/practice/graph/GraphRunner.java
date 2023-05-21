package com.company.medznmore.practice.graph;

public class GraphRunner {
  public static void main(String[] args) {
    // create a graph
    Graph graph = new Graph();

    // add some nodes and edges
    graph.addNodeAndEdge("A", "B");
    graph.addNodeAndEdge("A", "C");
    graph.addNodeAndEdge("A", "D");
    graph.addNodeAndEdge("A", "E");
    graph.addNodeAndEdge("A", "F");
    graph.addNodeAndEdge("B", "C");
    graph.addNodeAndEdge("B", "D");
    graph.addNodeAndEdge("B", "E");
    graph.addNodeAndEdge("B", "F");
    graph.addNodeAndEdge("C", "D");
    graph.addNodeAndEdge("C", "E");

    graph.breadthForSearch(graph.getNodes().get("D"));
    // print the graph
//    for (GraphNode node : graph.getNodes().values()) {
//      System.out.println(node);
//    }

    // perform DFS from any node with maxLevel 2
    System.out.print("DFS: ");
    graph.dfs(graph.getNodes().get("A"), 2);
    System.out.println();

    // perform BFS from any node with maxLevel 2
    System.out.print("BFS: ");
    graph.bfs(graph.getNodes().get("A"), 2);
    System.out.println();


  }
}
