package com.datastructures.trie;

import java.util.HashMap;

public class Node {
	private HashMap<Character, Node> children = new HashMap<Character, Node>();
	private boolean isEnd;
	
	public Node(){
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
	
	
}
