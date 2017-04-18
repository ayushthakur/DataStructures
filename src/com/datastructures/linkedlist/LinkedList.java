package com.datastructures.linkedlist;

public class LinkedList {
	private Node root = null;
	
	public LinkedList() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LinkedList(Node root) {
		super();
		this.root = root;
	}

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}

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
						currNode.setNext(null);
						;
					}
					previousNode = currNode;
					currNode = currNode.getNext();
				}
			}
		}
	}

	// Find the nth node form the last
	public int nFromLast(int n) {
		Node head = root;
		Node skipNode = root;
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
		Node head1 = root;
		Node head2 = linkedList2.getRoot();
		Node next1,next2;
		
		while(head1 != null && head2 != null){
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
	
	public LinkedList addList(LinkedList list2){
		Node l1 = this.root;
		Node l2 = list2.getRoot();
		int carry = 0;
		LinkedList sumList = new LinkedList();
		while(l1 != null && l2!= null){
			
			int sum = l1.getKey() + l2.getKey() + carry;
			
			if(sum > 9){
				carry = 1;
				sum -= 10;
			}else{
				carry = 0;
			}
			Node sumNode = new Node(sum);
			sumList.addNode(sumNode.getKey());
			l1 = l1.getNext();
			l2 = l2.getNext();
		}
		if(carry > 0){
			sumList.addNode(carry);
		}
		return sumList;
	}
	
	public void reverse(){
		Node previous = null;
		Node current = this.root;
		Node next = null;
		
		while(current!=null){
			next = current.getNext();
			current.setNext(previous);
			previous = current;
			current = next;
		}
		
		this.root = previous;
	}
}
