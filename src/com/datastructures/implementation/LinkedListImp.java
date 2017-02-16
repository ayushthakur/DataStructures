package com.datastructures.implementation;

import com.datastructures.linkedlist.LinkedList;

public class LinkedListImp {
	public static void main(String[] args) {
		LinkedList linkedList = new LinkedList();
		linkedList.addNode(1);
		linkedList.addNode(3);
		linkedList.addNode(5);
		linkedList.addNode(7);
//		linkedList.showList();
		
//		System.out.println("Deleting Node now");
//		linkedList.deleteNode(45);
//		linkedList.showList();
//		System.out.println("Second last node: "+linkedList.nFromLast(2));
		
		LinkedList linkedList2 = new LinkedList();
		linkedList2.addNode(2);
		linkedList2.addNode(4);
		linkedList2.addNode(6);
		linkedList2.addNode(8);
		
//		linkedList2.showList();
		
		linkedList.addList(linkedList2).showList();
	}
}
