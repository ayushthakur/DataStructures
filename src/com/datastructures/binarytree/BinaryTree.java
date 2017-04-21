package com.datastructures.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTree {
	private TNode root = null;

	public BinaryTree(TNode root) {
		super();
		this.root = root;
	}

	public TNode getRoot() {
		return root;
	}

	public void setRoot(TNode root) {
		this.root = root;
	}

	public BinaryTree() {
		super();
	}

	private boolean isEmpty() {
		if (root == null) {
			return true;
		}
		return false;
	}

	// Add a node to a tree
	public void addChild(int key) {
		TNode childNode = new TNode(key);
		TNode parent;

		if (isEmpty()) {
			root = childNode;
		} else {
			TNode focusNode = root;

			while (true) {
				parent = focusNode;
				if (focusNode.getKey() > key) {
					focusNode = focusNode.getLeftChild();
					if (focusNode == null) {
						parent.setLeftChild(childNode);
						return;
					}
				} else {
					focusNode = focusNode.getRightChild();
					if (focusNode == null) {
						parent.setRightChild(childNode);
						return;
					}
				}
			}
		}
	}

	public void printTree() {
		inOrderTraverse(root);
	}

	public void printPreOrder() {
		preOrderTraverse(this.root);
	}

	private void inOrderTraverse(TNode focusNode) {
		if (focusNode != null) {
			inOrderTraverse(focusNode.getLeftChild());
			System.out.println(focusNode.getKey());
			inOrderTraverse(focusNode.getRightChild());
		}
	}

	private void preOrderTraverse(TNode focusNode) {
		if (focusNode == null) {
			return;
		}
		System.out.println(focusNode.getKey());
		preOrderTraverse(focusNode.getLeftChild());
		preOrderTraverse(focusNode.getRightChild());

		// if(focusNode!=null){
		// System.out.println(focusNode.getKey());
		// preOrderTraverse(focusNode.getLeftChild());
		// preOrderTraverse(focusNode.getRightChild());
		// }
	}

	public void remove(int key) {
		TNode parent = root;
		TNode focusNode = root;
		boolean isLeft = false;

		// Find the node to be deleted
		while (focusNode.getKey() != key) {
			parent = focusNode;

			if (focusNode.getKey() <= key) {
				isLeft = true;
				focusNode = focusNode.getLeftChild();
			} else {
				if (focusNode.getKey() > key) {
					isLeft = false;
					focusNode = focusNode.getRightChild();
				}
			}
		}

		// If the node is a leaf node, simply remove it.
		if (focusNode.getLeftChild() == null && focusNode.getRightChild() == null) {
			if (focusNode.equals(root)) {
				root = null;
			} else {
				if (isLeft)
					parent.setLeftChild(null);
				else
					parent.setRightChild(null);
			}
		}
		// If the node has a right subtree, then replace the node with the right
		// child
		else if (focusNode.getLeftChild() == null) {
			if (focusNode.equals(root)) {
				root = focusNode.getRightChild();
			} else {
				if (isLeft)
					parent.setLeftChild(focusNode.getRightChild());
				else
					parent.setRightChild(focusNode.getRightChild());
			}
		}
		// If the node has a left subtree, then replace the node with the left
		// child
		else if (focusNode.getRightChild() == null) {
			if (focusNode.equals(root)) {
				root = focusNode.getLeftChild();
			} else {
				if (isLeft)
					parent.setLeftChild(focusNode.getLeftChild());
				else
					parent.setRightChild(focusNode.getLeftChild());
			}
		}
		// If the node has both the children, then replace the node by its
		// inorder successor
		else {
			TNode successor = getInorderSuccessor(focusNode);
			if (focusNode.equals(root)) {
				root = successor;
			} else if (isLeft) {
				parent.setLeftChild(successor);
			} else {
				parent.setRightChild(successor);
			}
		}
	}

	// Find the inorder successor of the Node
	public TNode getInorderSuccessor(TNode replaceNode) {
		TNode focusNode = replaceNode;

		// If there is a right subtree, then find the smallest element in the
		// right subtree
		if (replaceNode.getRightChild() != null) {
			replaceNode = replaceNode.getRightChild();
			while (focusNode.getLeftChild() != null) {
				focusNode = focusNode.getLeftChild();
			}
			return focusNode;
		}
		// If right subtree is not present, find the next smallest number by
		// traversing the tree
		else {
			focusNode = root;
			while (focusNode.hasChildren()) {
				if (replaceNode.getKey() < focusNode.getKey()) {
					focusNode = focusNode.getLeftChild();
				} else {
					focusNode = focusNode.getRightChild();
				}
			}
			return focusNode;
		}
	}

	public int getMaxHeight() {
		return maxHeight(this.root);
	}

	// Find the height of the left subtree and the height of the right subtree
	// and add them. Add one for root.
	private int maxHeight(TNode aNode) {
		if (aNode == null) {
			return 0;
		}
		int leftHeight = maxHeight(aNode.getLeftChild());
		int rightHeight = maxHeight(aNode.getRightChild());
		if (leftHeight > rightHeight) {
			return leftHeight + 1;
		} else {
			return rightHeight + 1;
		}
	}

	public int getIterativeMaxHeight() {
		return iterativeMaxHeight(root);
	}

	private int iterativeMaxHeight(TNode aNode) {
		int height = 0;
		if (aNode == null) {
			return 0;
		}

		Queue<TNode> levelQueue = new LinkedList<>();
		levelQueue.add(aNode);

		while (true) {
			// Number of Nodes at current level
			int count = levelQueue.size();
			if (count == 0) {
				return height;
			}
			height++;

			while (count > 0) {
				TNode headNode = levelQueue.peek();
				// Remove nodes from current level and nodes from the next level
				levelQueue.remove();

				if (headNode.getLeftChild() != null)
					levelQueue.add(headNode.getLeftChild());
				else if (headNode.getRightChild() != null)
					levelQueue.add(headNode.getRightChild());

				count--;
			}
		}
	}

	public int getDiameter() {
		return diameter(root);
	}

	// Longest path between two nodes in a tree
	private int diameter(TNode aNode) {

		/*
		 * Find max of left subtree, right subtree, left diameter and right
		 * diameter
		 */
		if (aNode == null) {
			return 0;
		}
		int heightl = maxHeight(aNode.getLeftChild());
		int heightr = maxHeight(aNode.getRightChild());

		int lDiameter = diameter(aNode.getLeftChild());
		int rDiameter = diameter(aNode.getRightChild());

		return Math.max((heightl + heightr + 1), Math.max(lDiameter, rDiameter));
	}

	// Mirror a tree
	public TNode mirrorTree() {
		return mirror(root);
	}

	// Swap the left subtree with the right subtree
	private TNode mirror(TNode mirrorNode) {

		if (mirrorNode == null) {
			return mirrorNode;
		}

		TNode leftMirror = mirror(mirrorNode.getLeftChild());
		TNode rightMirror = mirror(mirrorNode.getRightChild());

		mirrorNode.setLeftChild(rightMirror);
		mirrorNode.setRightChild(leftMirror);

		return mirrorNode;
	}

	// Convert tree to a List
	public void asList(List<TNode> nodes) {

		asListUtil(nodes, this.root);
	}

	private void asListUtil(List<TNode> nodes, TNode n) {
		if (n == null) {
			return;
		}

		asListUtil(nodes, n.getLeftChild());
		nodes.add(n);
		asListUtil(nodes, n.getRightChild());

	}

	public void balance() {

		List<TNode> nodes = new ArrayList<TNode>();

		asList(nodes);

		setRoot(buildTree(nodes, 0, nodes.size() - 1));
	}

	// Build Tree from a List of Nodes
	private TNode buildTree(List<TNode> nodes, int start, int end) {

		if (start > end) {
			return null;
		}

		int mid = (start + end) / 2;

		TNode midNode = nodes.get(mid);

		midNode.setLeftChild(buildTree(nodes, start, mid - 1));
		midNode.setRightChild(buildTree(nodes, mid + 1, end));

		return midNode;
	}

	public boolean areIdentical(TNode root1, TNode root2) {
		if (root1 == null && root2 == null) {
			return true;
		} else if (root1 != null && root2 != null) {
			if (root1.getKey() == root2.getKey() && areIdentical(root1.getLeftChild(), root2.getLeftChild())
					&& areIdentical(root1.getRightChild(), root2.getRightChild())) {
				return true;
			}
		}
		return false;
	}

}
