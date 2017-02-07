package com.datastructures.linkedlist;

public class LinkedList {
	Node root = null;

	public void addNode(int key) {
		if (isEmpty()) {
			root = new Node(key);
		} else {
			Node newNode = new Node(key);
			newNode.setNext(root);
			root = newNode;
		}
	}

	public void showList() {
		Node tempNode = root;
		while (tempNode != null) {
			System.out.println(tempNode.getKey());
			System.out.println();
			tempNode = tempNode.getNext();
		}
	}

	public void deleteNode(int key) {
		if (!isEmpty()) {
			if (root.getKey() == key) {
				root = root.getNext();
			} else {
				Node previousNode = null;
				Node currNode = root;
				while (currNode != null) {
					if (currNode.getKey() == key) {
						previousNode.setNext(currNode.getNext());
						currNode.setNext(null);;
					}
					previousNode = currNode;
					currNode = currNode.getNext();
				}
			}
		}
	}

	//Find the nth node form the last
	public int nFromLast(int n){
		Node head = root;
		Node skipNode = root;
		//If last Node is considered then count=1 else count = 0
		int count = 1;
		while(count != n){
			skipNode = skipNode.getNext();
			count++;
		}
		while(skipNode.getNext() != null){
			head = head.getNext();
			skipNode = skipNode.getNext();
		}
		
		return head.getKey();
	}
	

	
	private boolean isEmpty() {
		if (root == null) {
			return true;
		}
		return false;
	}
	
}
