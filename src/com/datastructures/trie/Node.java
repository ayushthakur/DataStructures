package com.datastructures.trie;

import java.util.HashMap;
import java.util.Map;

public class Node {
	private String value;
	private HashMap<Character, Node> children = new HashMap<Character, Node>();
	private boolean isEnd;

	public Node() {
		super();
		this.isEnd = false;
	}

	public HashMap<Character, Node> getChildren() {
		return children;
	}

	public void setChildren(HashMap<Character, Node> children) {
		this.children = children;
	}

	public boolean isEnd() {
		return isEnd;
	}

	public void setEnd(boolean isEnd) {
		this.isEnd = isEnd;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String ch) {
		this.value = ch;
	}

	public Node getFirstChild() {
		Map.Entry<Character, Node> entry = this.children.entrySet().iterator().next();
		Node childNode = entry.getValue();
		return childNode;
	}
	
	public Character getFirstChildValue(){
		Map.Entry<Character, Node> entry = this.children.entrySet().iterator().next();
		Character value = entry.getKey();
		return value;
	}
}
