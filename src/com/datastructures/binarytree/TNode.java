package com.datastructures.binarytree;

public class TNode {
	private int key;
	private TNode leftChild;
	private TNode rightChild;

	public TNode(int key) {
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

	public TNode getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(TNode leftChild) {
		this.leftChild = leftChild;
	}

	public TNode getRightChild() {
		return rightChild;
	}

	public void setRightChild(TNode rightChild) {
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
		TNode node = (TNode) obj;

		if (this.key == node.getKey())
			return true;
		else
			return false;
	}
	
}
