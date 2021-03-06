package rectangleTrie;

import java.util.ArrayList;
import java.util.Hashtable;

public class ReferenceWordGroup {
	private Hashtable<String, Boolean> lookup = new Hashtable<String, Boolean>();
	private ArrayList<String> group = new ArrayList<String>();

	public ReferenceWordGroup() {

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

	public static ReferenceWordGroup[] createWordGroups(String[] list) {
		ReferenceWordGroup[] groupList;
		int maxWordLength = 0;
		// Find out the length of the longest word
		for (int i = 0; i < list.length; i++) {
			if (list[i].length() > maxWordLength) {
				maxWordLength = list[i].length();
			}
		}

		/*
		 * Group the words in the dictionary into lists of words of same
		 * length.groupList[i] will contain a list of words, each of length
		 * (i+1).
		 */
		groupList = new ReferenceWordGroup[maxWordLength];
		for (int i = 0; i < list.length; i++) {
			/*
			 * We do wordLength - 1 instead of just wordLength since this is
			 * used as an index and no words are of length 0
			 */
			int wordLength = list[i].length() - 1;
			if (groupList[wordLength] == null) {
				groupList[wordLength] = new ReferenceWordGroup();
			}
			groupList[wordLength].addWord(list[i]);
		}
		return groupList;
	}
}
