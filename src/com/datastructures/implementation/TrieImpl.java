package com.datastructures.implementation;

import com.datastructures.trie.Trie;

public class TrieImpl {
	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.add("hello");
		trie.add("helium");
		trie.add("helicopter");
		System.out.println("Added!");
		System.out.println(trie.contains("hell"));
	}
}
