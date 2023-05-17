package com.company.medznmore;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

interface Cache<K,V> {

    boolean set(K key, V value);

    Optional<V> get(K key);

    int size();

    boolean isEmpty();

    void clear();
}

public class LRUCache<K, V> implements Cache<K, V> {

    private final int capacity;
    private final Map<K, Node<K, V>> map;
    private final DoublyLinkedList<K, V> list;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.list = new DoublyLinkedList<>();
    }

    @Override
    public boolean set(K key, V value) {
        if (map.containsKey(key)) {
            // cache hit, update the value and move the node to the head of the list
            Node<K, V> node = map.get(key);
            node.value = value;
            list.moveToHead(node);
            return true;
        } else {
            // cache miss, create a new node and add it to the head of the list
            Node<K, V> node = new Node<>(key, value);
            map.put(key, node);
            list.addToHead(node);
            if (map.size() > capacity) {
                // cache is full, remove the least recently used node from the tail of the list
                Node<K, V> tail = list.removeTail();
                map.remove(tail.key);
            }
            return false;
        }
    }

    @Override
    public Optional<V> get(K key) {
        if (map.containsKey(key)) {
            // cache hit, return the value and move the node to the head of the list
            Node<K, V> node = map.get(key);
            list.moveToHead(node);
            return Optional.of(node.value);
        } else {
            // cache miss, return empty
            return Optional.empty();
        }
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public void clear() {
        map.clear();
        list.clear();
    }

    // helper class for storing key-value pairs in a doubly linked list node
    private static class Node<K, V> {
        K key;
        V value;
        Node<K, V> prev;
        Node<K, V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    // helper class for managing a doubly linked list of nodes
    private static class DoublyLinkedList<K, V> {
        private Node<K, V> head;
        private Node<K, V> tail;

        public DoublyLinkedList() {
            head = new Node<>(null, null); // dummy head node
            tail = new Node<>(null, null); // dummy tail node
            head.next = tail;
            tail.prev = head;
        }

        public void addToHead(Node<K, V> node) {
            // insert the node after the dummy head node
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
        }

        public void moveToHead(Node<K, V> node) {
            // remove the node from its current position and add it to the head of the list
            removeNode(node);
            addToHead(node);
        }

        public Node<K, V> removeTail() {
            // remove the node before the dummy tail node and return it
            if (isEmpty()) {
                return null;
            }
            Node<K, V> node = tail.prev;
            removeNode(node);
            return node;
        }

        public void removeNode(Node<K, V> node) {
            // unlink the node from its previous and next nodes
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        public boolean isEmpty() {
            // check if there is any real node between the dummy head and tail nodes
            return head.next == tail;
        }

        public void clear() {
            // reset the list to empty state
            head.next = tail;
            tail.prev = head;
        }
    }
}

