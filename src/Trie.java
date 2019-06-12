

import java.util.ArrayList;
import java.util.HashMap;

//import test.UberTest.TrieNode;

class TrieNode {
	public HashMap<Character, TrieNode> map;
	public boolean isWord;
	TrieNode() {
		map = new HashMap<Character, TrieNode>();
		isWord = false;
	}
}

public class Trie{

	public TrieNode root;

	Trie(){
		root = new TrieNode();
	}

	public void custructTrie(ArrayList<String> dictionary) {
		for(String word : dictionary)
			addWord(word);
	}

	private void addWord(String word) {
		TrieNode current = root;
		char[] wordArray = word.toCharArray();
		for(int i = 0; i<wordArray.length; i++) {
			if(!current.map.containsKey(Character.toUpperCase(wordArray[i]))) {
				current.map.put(wordArray[i], new TrieNode());
			}
			current = current.map.get(wordArray[i]);
		}
		current.isWord = true;
	}
}

