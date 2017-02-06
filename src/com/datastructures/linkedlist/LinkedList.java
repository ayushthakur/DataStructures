package com.datastructures.linkedlist;

public class LinkedList {
	Node root = null;

	public void addNode(int key) {
		if (isEmpty()) {
			root = new Node(key);
		} else {
			Node newNode = new Node(key);
			newNode.next = root;
			root = newNode;
		}
	}

	public void showList() {
		Node tempNode = root;
		while (tempNode != null) {
			System.out.println(tempNode.getKey());
			System.out.println();
			tempNode = tempNode.next;
		}
	}

	public void deleteNode(int key) {
		if (!isEmpty()) {
			if (root.getKey() == key) {
				root = root.next;
			} else {
				Node previousNode = null;
				Node currNode = root;
				while (currNode != null) {
					if (currNode.getKey() == key) {
						previousNode.next = currNode.next;
						currNode.next = null;
					}
					previousNode = currNode;
					currNode = currNode.next;
				}
			}
		}
	}

	private boolean isEmpty() {
		if (root.next == null) {
			return true;
		}
		return false;
	}
}
