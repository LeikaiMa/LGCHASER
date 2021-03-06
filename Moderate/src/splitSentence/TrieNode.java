package splitSentence;
// trie 为了看prefix 是否存在，里面有自身的character 和一系列的children 作为连接之后的node
// 里面判断这个是不是这边是不是一个单词的结束，所以有一个terminate 来看是否是最后结束的标志
// 如果要加一个word 首先判断这个word 是不是存在或者是不是空的。
// 然后开始找哪个child 是现在这个第一个单词，如果不存在，就新建一个加到children 的list 里面。
// 如果存在就看是不是长度大于1，如果等于1 就可以直接将child 的terminate 设置为 true
// 如果不是，就将substring 1 传到这个child 里面进行相应的操作。
// get child 是将children 进行遍历，然后找到相同的，就返回这个node ，如果找不到就返回null

import java.util.LinkedList;

public class TrieNode {
	private LinkedList<TrieNode> children;
	private boolean terminates = false;

	private char character;

	public TrieNode() {
		children = new LinkedList<TrieNode>();
	}

	public TrieNode(char character) {
		this();
		this.character = character;
	}

	public char getChar() {
		return character;
	}

	public void addWord(String word) {
		if (word == null || word.isEmpty()) {
			return;
		}

		TrieNode child;
		char firstChar = word.charAt(0);

		TrieNode t = getChild(firstChar);

		if (t == null) {
			child = new TrieNode(firstChar);
			children.add(child);
		} else {
			child = t;
		}

		if (word.length() > 1) {
			child.addWord(word.substring(1));
		} else {
			child.setTerminates(true);
		}

	}

	TrieNode getChild(char c) {
		for (TrieNode t : children) {
			if (t.getChar() == c) {
				return t;
			}
		}
		return null;
	}

	public boolean terminates() {
		return terminates;
	}

	public void setTerminates(boolean t) {
		terminates = t;
	}
}
