


import java.util.ArrayList;

public class UberTest {

	static ArrayList<String> result;
	static ArrayList<String> dictionary;
	static Trie objTrie;

	public static void main(String args[] ) throws Exception {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT */
		result = new ArrayList<String>();
		dictionary = new ArrayList<String>();
		dictionary.add("UBER");
		dictionary.add("ZEBRA");
		dictionary.add("ARE");
		dictionary.add("BEER");
		dictionary.add("BEERY");

		objTrie = new Trie();
		objTrie.custructTrie(dictionary);

//		TrieNode test = objTrie.root;
//		System.out.println(test.map);
//		System.out.println(test.map.get('B').map.get('E').map.get('E').map.get('R').map.get('Y').isWord);
		
		Character[][] letters = new Character[][]{{'U', 'B', 'Z'}, {'R', 'E', 'E'}, {'A', 'R', 'E'}};

		listWords(letters);
		//System.out.println(result.toString());   
	}

	public static void listWords(Character[][] letters){
		int rows = letters.length;
		int cols = letters[0].length;
		int[][] isVisited = new int[rows][cols];
		appendWords(letters, isVisited, "", 0, 0);
	}

	public static void appendWords(Character[][] letters, int[][] isVisited, String tempWord, int row, int col){
		if(row<0 || col<0 || row>=letters.length || col>=letters[0].length || isVisited[row][col]==1 )
			return;
		
		Character ch = letters[row][col];
		
		isVisited[row][col] = 1;
		appendWords(letters, isVisited, tempWord, row-1, col);
		appendWords(letters, isVisited, tempWord, row+1, col);
		appendWords(letters, isVisited, tempWord, row, col-1);
		appendWords(letters, isVisited, tempWord, row, col+1);
	}
}

