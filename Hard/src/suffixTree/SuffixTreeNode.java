package suffixTree;

import java.util.ArrayList;
import java.util.HashMap;
// 将里面的数据进行插入的时候，把里面的index 插入，然后建立一个hashmap 存入里面有可能的后缀node 以及里面的 character
// 如果有相同的character 可以用这个hashmap 进行分叉处理。
// 然后如果这个还是一个string 可以将string 后面的remainder 继续按照这种形式进行存储。
// 查找string 是否是suffix 时候，通过check 是否是children 里面，来判断是否有这个suffix ，但是有这个suffix 不代表只有这一个，可以用remainder深入进去来进行check
// 如果下面仍然匹配就说明有，直到没有剩余的可以匹配了。这时候返回所有的index，因为可能有很多种，所以会是一个arraylist

public class SuffixTreeNode {
	HashMap<Character, SuffixTreeNode> children = new HashMap<Character, SuffixTreeNode>();
	char value;
	ArrayList<Integer> indexes = new ArrayList<Integer>();

	public SuffixTreeNode() {

	}

	public void insertString(String s, int index) {
		indexes.add(index);
		if (s != null && s.length() > 0) {
			value = s.charAt(0);
			SuffixTreeNode child = null;
			if (children.containsKey(value)) {
				child = children.get(value);
			} else {
				child = new SuffixTreeNode();
				children.put(value, child);
			}

			String remainder = s.substring(1);
			child.insertString(remainder, index);
		}
	}

	public ArrayList<Integer> search(String s) {
		if (s == null || s.length() == 0) {
			return indexes;
		} else {
			char first = s.charAt(0);
			if (children.containsKey(first)) {
				String remainder = s.substring(1);
				return children.get(first).search(remainder);
			}
		}
		return null;
	}
}
