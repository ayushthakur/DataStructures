package com.datastructures.linkedlist;

import com.datastructures.binarytree.BinaryTree;
import com.datastructures.binarytree.TNode;

public class LinkedList {
	private LNode root = null;

	public LinkedList() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LinkedList(LNode root) {
		super();
		this.root = root;
	}

	public LNode getRoot() {
		return root;
	}

	public void setRoot(LNode root) {
		this.root = root;
	}

	public void addNode(int key) {
		if (isEmpty()) {
			root = new LNode(key);
		} else {
			LNode newNode = new LNode(key);
			newNode.setNext(root);
			root = newNode;
		}
	}

	public void showList() {
		LNode tempNode = root;
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
				LNode previousNode = null;
				LNode currNode = root;
				while (currNode != null) {
					if (currNode.getKey() == key) {
						previousNode.setNext(currNode.getNext());
						currNode.setNext(null);
					}
					previousNode = currNode;
					currNode = currNode.getNext();
				}
			}
		}
	}

	// Find the nth node form the last
	public int nFromLast(int n) {
		LNode head = root;
		LNode skipNode = root;
		// If last Node is considered then count=1 else count = 0
		int count = 1;
		while (count != n) {
			skipNode = skipNode.getNext();
			count++;
		}
		while (skipNode.getNext() != null) {
			head = head.getNext();
			skipNode = skipNode.getNext();
		}

		return head.getKey();
	}

	// Merge two LinkedLists with alternating nodes
	public void merge(LinkedList linkedList2) {
		LNode head1 = root;
		LNode head2 = linkedList2.getRoot();
		LNode next1, next2;

		while (head1 != null && head2 != null) {
			next1 = head1.getNext();
			next2 = head2.getNext();

			head2.setNext(next1);
			head1.setNext(head2);

			head1 = next1;
			head2 = next2;
		}

		linkedList2.setRoot(head2);
	}

	public boolean isEmpty() {
		if (root == null) {
			return true;
		}
		return false;
	}

	public LinkedList addList(LinkedList list2) {
		LNode l1 = this.root;
		LNode l2 = list2.getRoot();
		int carry = 0;
		LinkedList sumList = new LinkedList();
		while (l1 != null && l2 != null) {

			int sum = l1.getKey() + l2.getKey() + carry;

			if (sum > 9) {
				carry = 1;
				sum -= 10;
			} else {
				carry = 0;
			}
			LNode sumNode = new LNode(sum);
			sumList.addNode(sumNode.getKey());
			l1 = l1.getNext();
			l2 = l2.getNext();
		}
		if (carry > 0) {
			sumList.addNode(carry);
		}
		return sumList;
	}

	public void reverse() {
		LNode previous = null;
		LNode current = this.root;
		LNode next = null;

		while (current != null) {
			next = current.getNext();
			current.setNext(previous);
			previous = current;
			current = next;
		}

		this.root = previous;
	}

	public int size() {
		int count = 0;
		LNode focusNode = this.root;

		while (focusNode != null) {
			count++;
			focusNode = focusNode.getNext();
		}
		return count;
	}

	public int lengthFromNode(LNode n) {
		int count = 0;
		LNode focusNode = n;

		while (focusNode != null) {
			count++;
			focusNode = focusNode.getNext();
		}
		System.out.println("Length form node: " + count);
		return count;
	}

	public TNode sortedListToBST() {
		return sortedListToBSTUtil(size());
	}

	private TNode sortedListToBSTUtil(int n) {
		
		if (n <= 0) {
			return null;
		}

		TNode leftSubtree = sortedListToBSTUtil(n / 2);

		TNode treeRoot = new TNode(this.root.getKey());
		
		treeRoot.setLeftChild(leftSubtree);
		
		this.root = this.root.getNext();

		treeRoot.setRightChild(sortedListToBSTUtil(n - n / 2 - 1));

		return treeRoot;
	}

	public void sort() {

		LNode focusNode = this.root;
		BinaryTree tempT = new BinaryTree();
		while (focusNode != null) {
			tempT.addChild(focusNode.getKey());
			focusNode = focusNode.getNext();
		}

		LinkedList l1 = new LinkedList();
		treeToLinkedList(tempT.getRoot(), l1);
		this.root = l1.getRoot();
	}

	public void treeToLinkedList(TNode tNode, LinkedList l1) {
		if (tNode == null) {
			return;
		}
		treeToLinkedList(tNode.getLeftChild(), l1);
		l1.addNode(tNode.getKey());
		treeToLinkedList(tNode.getRightChild(), l1);
	}
}
