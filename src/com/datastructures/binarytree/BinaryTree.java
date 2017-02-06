package com.datastructures.binarytree;

public class BinaryTree {
	Node root = null;

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
		Node childNode = new Node(key);
		Node parent;

		if (isEmpty()) {
			root = childNode;
		} else {
			Node focusNode = root;

			while (true) {
				parent = focusNode;
				if (focusNode.getKey() < key) {
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

	private void inOrderTraverse(Node focusNode) {
		if (focusNode != null) {
			inOrderTraverse(focusNode.getLeftChild());
			System.out.println(focusNode.getKey());
			inOrderTraverse(focusNode.getRightChild());
		}
	}

	public void remove(int key) {
		Node parent = root;
		Node focusNode = root;
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
			Node successor = getInorderSuccessor(focusNode, key);
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
	private Node getInorderSuccessor(Node replaceNode, int key) {
		Node focusNode = replaceNode;

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

	
	//Find the height of the left subtree and the height of the left subtree and add them. Add one for root.
	private int maxHeight(Node aNode) {
		if (aNode == null) {
			return -1;
		}
		int leftHeight = maxHeight(aNode.getLeftChild());
		int rightHeight = maxHeight(aNode.getRightChild());
		if (leftHeight > rightHeight) {
			return leftHeight + 1;
		} else {
			return rightHeight + 1;
		}
	}
}
