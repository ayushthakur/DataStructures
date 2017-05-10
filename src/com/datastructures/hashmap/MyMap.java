package com.datastructures.hashmap;

import java.util.ArrayList;
import java.util.HashMap;

public class MyMap<K, V> {

	private ArrayList<HashNode<K, V>> nodeArray;

	private int numOfBucket;

	private int size;

	public int getSize() {
		return size;
	}

	public MyMap() {
		nodeArray = new ArrayList<>();

		numOfBucket = 10;
		for (int i = 0; i < numOfBucket; i++) {
			nodeArray.add(null);
		}
	}

	private int getBucketIndex(K key) {
		int hashCode = key.hashCode();
		int index = hashCode % numOfBucket;
		return index;
	}

	public V get(K key) {
		int index = getBucketIndex(key);

		HashNode<K, V> head = nodeArray.get(index);

		while (head != null) {
			if (head.getKey().equals(key))
				return head.getValue();

			head = head.getNext();
		}

		System.out.println("Value not found in the Map");
		return null;
	}

	public boolean isEmpty() {
		return getSize() == 0;
	}

	// Add values to Map
	public void add(K key, V value) {
		int index = getBucketIndex(key);

		HashNode<K, V> head = this.nodeArray.get(index);

		// Check if the node is already present. Collision techniques can be
		// used here.

		while (head != null) {
			
			if (head.getKey().equals(key)) {
				head.setValue(value);
				return;
			}
			head = head.getNext();
		}
		
		
		this.size++;

		head = nodeArray.get(index);

		HashNode<K, V> newNode = new HashNode<K, V>(key, value);

		newNode.setNext(head);
		nodeArray.set(index, newNode);

		// if load factor crosses threshold, double the hashmap.
		// Optimum load factor is 0.75f
		if ((size * 1.0) / numOfBucket >= 0.7) {
			ArrayList<HashNode<K, V>> temp = nodeArray;
			this.nodeArray = new ArrayList<>();
			this.numOfBucket *= 2;
			this.size = 0;
			for (int i = 0; i < numOfBucket; i++) {
				nodeArray.add(null);
			}

			for (HashNode<K, V> node : temp) {
				while (node != null) {
					add(node.getKey(), node.getValue());
					node = node.getNext();
				}
			}
		}
	}

	public void remove(K key) {
		int index = getBucketIndex(key);

		HashNode<K, V> head = nodeArray.get(index);

		HashNode<K, V> prev = null;

		while (head != null) {
			if (head.getKey().equals(key)) {
				break;
			}
			prev = head;
			head = head.getNext();
		}
		if (head == null)
			return;

		this.size--;

		if (prev != null)
			prev.setNext(null);
		else
			nodeArray.set(index, head.getNext());

	}

	public void printMap() {
		HashNode<K, V> head = null;
		for (int i = 0; i < nodeArray.size(); i++)
			if (nodeArray.get(i) != null) {
				head = nodeArray.get(i);
				while(head != null){
					System.out.println("Key: "+head.getKey().toString()+"\tValue: "+head.getValue().toString());
					head = head.getNext();
				}
			}
		
	}

	public static void main(String[] args) {
		MyMap<Integer, String> myMap = new MyMap<>();

		myMap.add(1, "Anshuman");
		myMap.add(2, "Ashutosh");
		myMap.add(3, "Piyush");
		myMap.add(3, "Bafna");

		myMap.printMap();

	}
}
