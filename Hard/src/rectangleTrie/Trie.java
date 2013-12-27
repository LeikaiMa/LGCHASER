package rectangleTrie;
// 建Trie 的直接将一个list 的string 放进来或者是一个String 的数组进来都可以。
// root 本身没有char 而后面带着一个list 的children
// 如果找是否prefix 存在就要从root 开始找有没有child 代表prefix 里面的值，如果一个没有就直接false。
import java.util.ArrayList;

public class Trie {
	private TrieNode root;

	public Trie(ArrayList<String> list) {
		root = new TrieNode();
		for (String word : list) {
			root.addWord(word);
		}
	}

	public Trie(String[] list) {
		root = new TrieNode();
		for (String word : list) {
			root.addWord(word);
		}
	}

	public boolean contains(String prefix, boolean exact) {
		TrieNode lastNode = root;
		int i = 0;
		for (i = 0; i < prefix.length(); i++) {
			lastNode = lastNode.getChild(prefix.charAt(i));
			if (lastNode == null) {
				return false;
			}
		}
		return !exact || lastNode.terminates();
	}
	
	public boolean contains(String prefix) {
		return contains(prefix, false);
	}
}
