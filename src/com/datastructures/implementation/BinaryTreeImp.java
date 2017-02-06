package com.datastructures.implementation;

import com.datastructures.binarytree.BinaryTree;

class BinaryTreeImp{
	public static void main(String[] args) {
		BinaryTree bst = new BinaryTree();
		
		bst.addChild(15);
		bst.addChild(10);
		bst.addChild(5);
		bst.addChild(25);
		bst.remove(25);
		bst.printTree();
		
	}
}