package com.datastructures.trie;

public class Trie {
	Node root;

	public Trie() {
		super();
		root = new Node();
	}

	public void add(String s) {
		Node currNode = root;

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (currNode.getChildren().containsKey(c)) {
				currNode = currNode.getChildren().get(c);
			} else {
				Node node = new Node();
				currNode.getChildren().put(c, node);
				currNode = currNode.getChildren().get(c);
				currNode.setEnd(true);
			}
		}
	}

	public boolean contains(String s){
		Node focusNode = root;
		boolean flag = true;
		for(int i=0;i<s.length();i++){
			if(focusNode.getChildren().containsKey(s.charAt(i))){
				focusNode = focusNode.getChildren().get(s.charAt(i));
			}else{
				flag = false;
			}
		}
		return flag;
	}
}
