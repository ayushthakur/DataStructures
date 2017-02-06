package com.datastructures.linkedlist;

public class Node {
	private int key;
	Node next;
	
	
	public Node(int key) {
		super();
		this.key = key;
		next = null;
	}
	
	public int getKey() {
		return key;
	}
	public void setKey(int key) {
		this.key = key;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	
	
}
