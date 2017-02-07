package com.datastructures.implementation;

import com.datastructures.binarytree.BinaryTree;

class BinaryTreeImp{
	public static void main(String[] args) {
		BinaryTree bst = new BinaryTree();
		
		bst.addChild(15);
		bst.addChild(10);
		bst.addChild(5);
		bst.addChild(20);
		bst.addChild(25);
		bst.printTree();
		System.out.println("Max Height: "+bst.getMaxHeight());
		System.out.println("Iterative Max Height: "+bst.getIterativeMaxHeight());
		System.out.println("Diameter: "+bst.getDiameter());
	}
}