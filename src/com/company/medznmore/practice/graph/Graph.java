package com.company.medznmore.practice.graph;

import com.company.medznmore.practice.GraphNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Graph {
  private HashMap<String, GraphNode> nodes; // the map of nodes

  // constructor
  public Graph() {
    this.nodes = new HashMap<>();
  }

  public HashMap<String, GraphNode> getNodes() {
    return nodes;
  }

  // add a node and an edge to the graph
  public void addNodeAndEdge(String name1, String name2) {
    // check if the nodes already exist in the graph
    GraphNode node1 = nodes.get(name1);
    GraphNode node2 = nodes.get(name2);

    // if not, create new nodes and add them to the map
    if (node1 == null) {
      node1 = new GraphNode(name1);
      nodes.put(name1, node1);
    }
    if (node2 == null) {
      node2 = new GraphNode(name2);
      nodes.put(name2, node2);
    }

    // add each other as friends
    node1.addFriend(node2);
    node2.addFriend(node1);
  }

  public void breadthForSearch(GraphNode startNode) {
    // create a queue and a hashset
    LinkedList<GraphNode> queue = new LinkedList<>();
    Set<GraphNode> visited= new HashSet<>();

    System.out.println("start node :"+startNode.getName());

    queue.add(startNode);
    visited.add(startNode);
    while (!queue.isEmpty()){

      GraphNode currentGraphNode = queue.remove();
      System.out.print("-->" + currentGraphNode.getName());
      for(GraphNode node: currentGraphNode.getFriends()){
        if(!visited.contains(node)){
          queue.add(node);
          visited.add(node);
        }
      }

    }
  }

  // To iterate friends of friends using DFS and BFS, we can modify our methods to keep track of the
  // level or distance of each node from the starting node. We can use a HashMap to store the level
  // of each node, where the key is the node and the value is the level. We can also use a variable
  // to store the maximum level we want to iterate, which is 2 for friends of friends. Here are the
  // modified methods:
  //


  // For DFS, we can use a recursive approach to iterate the nodes in depth-first order. We will
  // need a set to store the nodes that have been visited, a HashMap to store the level of each
  // node, and a starting node and a maximum level as input parameters. The method will print the
  // names of the nodes that are within the maximum level.

  public void dfs(GraphNode start, int maxLevel) {
    // create a set and a map
    HashSet<GraphNode> visited = new HashSet<>();
    HashMap<GraphNode, Integer> level = new HashMap<>();

    // call the recursive helper method with the starting node and level 0
    dfsHelper(start, 0, maxLevel, visited, level);
  }

  // the recursive helper method
  public void dfsHelper(GraphNode current, int currentLevel, int maxLevel, HashSet<GraphNode> visited, HashMap<GraphNode, Integer> level) {
    // if the current node has not been visited
    if (!visited.contains(current)) {
      // mark it as visited and store its level
      visited.add(current);
      level.put(current, currentLevel);

      // if its level is within the maximum level
      if (currentLevel <= maxLevel) {
        // print its name
        System.out.print(current.getName() + " ");
      }

      // for each of its friends
      for (GraphNode friend : current.getFriends()) {
        // call the recursive helper method with the friend and the next level
        dfsHelper(friend, currentLevel + 1, maxLevel, visited, level);
      }
    }
  }

  // For BFS, we can use an iterative approach to iterate the nodes in breadth-first order.
  // We will need a queue to store the nodes that are waiting to be visited,
  // a set to store the nodes that have been visited,
  // a HashMap to store the level of each node, and a starting node and a maximum level as input parameters.
  // The method will print the names of the nodes that are within the maximum level.

  public void bfs(GraphNode start, int maxLevel) {
    // create a queue, a set and a map
    LinkedList<GraphNode> queue = new LinkedList<>();
    HashSet<GraphNode> visited = new HashSet<>();
    HashMap<GraphNode, Integer> level = new HashMap<>();

    // enqueue the starting node and mark it as visited
    queue.add(start);
    visited.add(start);

    // while the queue is not empty
    while (!queue.isEmpty()) {
      // dequeue a node from the queue
      GraphNode current = queue.remove();

      // get its level
      int currentLevel = level.getOrDefault(current, 0);

      // if its level is within the maximum level
      if (currentLevel <= maxLevel) {
        // print its name
        System.out.print(current.getName() + " ");
      }

      // for each of its friends
      for (GraphNode friend : current.getFriends()) {
        // if it has not been visited
        if (!visited.contains(friend)) {
          // enqueue it and mark it as visited
          queue.add(friend);
          visited.add(friend);

          // store its level as one more than the current level
          level.put(friend, currentLevel + 1);
        }
      }
    }
  }

}

