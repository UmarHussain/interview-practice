package com.company.medznmore.practice;

import java.util.ArrayList;

public class GraphNode {
  private String name; // the name of the person
  private ArrayList<GraphNode> friends; // the list of friends

  // constructor
  public GraphNode(String name) {
    this.name = name;
    this.friends = new ArrayList<>();
  }

  // add a friend to the list
  public void addFriend(GraphNode friend) {
    this.friends.add(friend);
  }

  // override the toString method
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(name + " --- ");
    for (GraphNode friend : friends) {
      sb.append(friend.name + " ");
    }
    return sb.toString();
  }

  public String getName() {
    return name;
  }

  public ArrayList<GraphNode> getFriends() {
    return friends;
  }
}

