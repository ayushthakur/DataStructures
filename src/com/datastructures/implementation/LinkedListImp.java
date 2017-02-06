package com.datastructures.implementation;

import com.datastructures.linkedlist.LinkedList;

public class LinkedListImp {
	public static void main(String[] args) {
		LinkedList linkedList = new LinkedList();
		linkedList.addNode(25);
		linkedList.addNode(40);
		linkedList.addNode(45);
		linkedList.addNode(90);
		linkedList.showList();
		
		System.out.println("Deleting Node now");
		linkedList.deleteNode(45);
		linkedList.showList();
	}
}
