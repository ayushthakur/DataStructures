package com.datastructures.linkedlist;

public class LNode {
	private int key;
	private LNode next;

	
	public LNode() {
		super();
	}

	public LNode(int key) {
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

	public LNode getNext() {
		return next;
	}

	public void setNext(LNode next) {
		this.next = next;
	}

	public boolean hasNext() {
		if (this.next != null) {
			return true;
		}
		return false;
	}
	
	
	@Override
	public String toString() {
		LNode focusNode = this.next;
		String returnString = "";
		while(focusNode != null){
			returnString += this.next.getKey();
			returnString += "\n";
			focusNode = focusNode.getNext();
		}
		return returnString;
	}
	
	

}
