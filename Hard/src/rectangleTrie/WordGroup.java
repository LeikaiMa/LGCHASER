package rectangleTrie;

import java.util.ArrayList;
import java.util.Hashtable;
// 将wordgroup 建出来，里面有按照顺利存的group 可以根据index 来进行去，
// 有一个hashtable 存的lookup。里面存的是单词，可以直接查找到。
// 里面也可以存多个group 先遍历，查找最大的length 然后按照length 将数据存进去
public class WordGroup {
	private Hashtable<String, Boolean> lookup = new Hashtable<String, Boolean>();
	private ArrayList<String> group = new ArrayList<String>();
	
	public WordGroup() {
		
	}
	
	public boolean containsWord(String s) {
		return lookup.containsKey(s);
	}
	
	public void addWord(String s) {
		group.add(s);
		lookup.put(s, true);
	}
	
	public int length() {
		return group.size();
	}
	
	public String getWord(int i) {
		return group.get(i);
	}
	
	public ArrayList<String> getWords() {
		return group;
	}
	
	public static WordGroup[] createWordGroups(String[] list) {
		WordGroup[] groupList;
		int maxWordLength = 0;
		
		for (int i = 0; i < list.length; i++) {
			if (list[i].length() > maxWordLength) {
				maxWordLength = list[i].length();
			}
		}
		
		groupList = new WordGroup[maxWordLength];
		for (int i = 0; i < list.length; i++) {
			int wordLength = list[i].length() - 1;
			if (groupList[wordLength] == null) {
				groupList[wordLength] = new WordGroup();
			}
			groupList[wordLength].addWord(list[i]);
		}
		return groupList;
	}
}
