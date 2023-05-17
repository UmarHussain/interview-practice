package com.company.medznmore.graph.practice;

import java.util.ArrayList;

class Node {
  String name; // the name of the person
  ArrayList<Node> friends; // the list of friends

  // constructor
  public Node(String name) {
    this.name = name;
    this.friends = new ArrayList<>();
  }

  // add a friend to the list
  public void addFriend(Node friend) {
    this.friends.add(friend);
  }

  // override the toString method
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(name + " --- ");
    for (Node friend : friends) {
      sb.append(friend.name + " ");
    }
    return sb.toString();
  }
}

