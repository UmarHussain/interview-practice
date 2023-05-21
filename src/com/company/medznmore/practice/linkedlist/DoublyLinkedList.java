package com.company.medznmore.practice.linkedlist;

class Node<T>{
  private T data;
  private Node<T> next;
  private Node<T> previous;

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }

  public Node<T> getNext() {
    return next;
  }

  public void setNext(Node<T> next) {
    this.next = next;
  }

  public Node<T> getPrevious() {
    return previous;
  }

  public void setPrevious(Node<T> previous) {
    this.previous = previous;
  }

  public Node(T data) {
    this.data = data;
    next = null;
    previous = null;
  }
}

public class DoublyLinkedList<T> {
    private Node<T> tail;
    private Node<T> head;

  public int getSize() {
    return size;
  }

  private int size;
  public DoublyLinkedList() {
    tail = null;
    head = null;
    size = 0;
  }

  // Method to add a node at the end of the list
  public void append(T data){
    // Create a new node with the given data
    Node<T> newNode = new Node<>(data);
    // If the list is empty, make the new node as the head and tail
    if(head == null){
      tail = newNode;
      head = newNode;
    } else {
      // Otherwise, link the new node with the tail and make it the new tail
      newNode.setPrevious(tail);
      newNode.setNext(null);
      tail.setNext(newNode);
      tail = newNode;
    }
    size++;
  }

  public void insertAfter(Node<T> node,T data) {

    if(node == null){
      System.err.println("previous node cannot be null");
      return;
    }

    // if the node is tail simply append the new node
    if(node.getNext() == null && node.getPrevious() != null) {
      append(data);
      return;
    }
    // creating new node
    Node<T> newNode = new Node<>(data);
    newNode.setPrevious(node);
    newNode.setNext(node.getNext());
    node.getNext().setPrevious(newNode);
    node.setNext(newNode);
    size++;


  }
}
