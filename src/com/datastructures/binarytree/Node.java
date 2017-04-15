package com.datastructures.binarytree;

public class Node {
	private int key;
	private Node leftChild;
	private Node rightChild;

	public Node(int key) {
		super();
		this.key = key;
		this.leftChild = null;
		this.rightChild = null;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public Node getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(Node leftChild) {
		this.leftChild = leftChild;
	}

	public Node getRightChild() {
		return rightChild;
	}

	public void setRightChild(Node rightChild) {
		this.rightChild = rightChild;
	}
	
	//Check if the node has any children
	public boolean hasChildren(){
		if(this.leftChild == null && this.rightChild == null){
			return false;
		}
		return true;
	}

	// Compare two Nodes by their keys
	@Override
	public boolean equals(Object obj) {
		Node node = (Node) obj;

		if (this.key == node.getKey())
			return true;
		else
			return false;
	}
	
	public void traverseInorderFromNode(Node n){
		while(n != null){
			traverseInorderFromNode(n.getLeftChild());
			System.out.println(n.getKey());
			traverseInorderFromNode(n.getRightChild());
		}
	}

}
