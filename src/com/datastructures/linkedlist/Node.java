package com.datastructures.linkedlist;

public class Node {
	private int key;
	private Node next;

	
	public Node() {
		super();
	}

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

	public boolean hasNext() {
		if (this.next != null) {
			return true;
		}
		return false;
	}

}
