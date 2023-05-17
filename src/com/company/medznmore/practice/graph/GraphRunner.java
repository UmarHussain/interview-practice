package com.company.medznmore.practice.graph;

import com.company.medznmore.practice.Node;

public class GraphRunner {
  public static void main(String[] args) {
    // create a graph
    Graph graph = new Graph();

    // add some nodes and edges
    graph.addNodeAndEdge("A", "B");
    graph.addNodeAndEdge("A", "C");
    graph.addNodeAndEdge("A", "D");
    graph.addNodeAndEdge("B", "C");
    graph.addNodeAndEdge("B", "D");
    graph.addNodeAndEdge("C", "D");
    graph.addNodeAndEdge("C", "E");
    graph.addNodeAndEdge("D", "E");
    graph.addNodeAndEdge("E", "F");

    // print the graph
    for (Node node : graph.nodes.values()) {
      System.out.println(node);
    }
  }
}
