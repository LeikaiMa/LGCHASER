package suffixTree;

import java.util.ArrayList;
// root 没有任何内容，然后从开始第一个substring 插入这个root，如果有相同的也是在有的基础上进行插入
public class SuffixTree {
	SuffixTreeNode root = new SuffixTreeNode();
	public SuffixTree(String s) {
		for (int i = 0; i < s.length(); i++) {
			String suffix = s.substring(i);
			root.insertString(suffix, i);
		}
	}
	
	public ArrayList<Integer> search(String s) {
		return root.search(s);
	}
}
