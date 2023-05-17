package com.company.medznmore.practice.graph;

import com.company.medznmore.practice.Node;

import java.util.HashMap;

class Graph {
  HashMap<String, Node> nodes; // the map of nodes

  // constructor
  public Graph() {
    this.nodes = new HashMap<>();
  }

  // add a node and an edge to the graph
  public void addNodeAndEdge(String name1, String name2) {
    // check if the nodes already exist in the graph
    Node node1 = nodes.get(name1);
    Node node2 = nodes.get(name2);

    // if not, create new nodes and add them to the map
    if (node1 == null) {
      node1 = new Node(name1);
      nodes.put(name1, node1);
    }
    if (node2 == null) {
      node2 = new Node(name2);
      nodes.put(name2, node2);
    }

    // add each other as friends
    node1.addFriend(node2);
    node2.addFriend(node1);
  }

  public void bfs(Node startNode){}
}

