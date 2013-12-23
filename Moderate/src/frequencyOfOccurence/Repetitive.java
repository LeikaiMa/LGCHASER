package frequencyOfOccurence;
// 如果只是一次，就只需要遍历一遍用O（n）的时间
// 如果需要很多次，就需要先将所有的word 存进一个hashtable 里面。注意之前要先统一大小写。要先trim 如果还有值就存进table 
// 然后每次找frequency 就可以直接从table 里面去读。
import java.util.Hashtable;

public class Repetitive {
	Hashtable<String, Integer> setupDictionary(String[] book) {
		Hashtable<String, Integer> table = new Hashtable<>();
		for (String word : book) {
			word = word.toLowerCase();
			if (word.trim() != "") {
				if (!table.contains(word)) {
					table.put(word, 0);
				}
				table.put(word, table.get(word) + 1);
			}
		}
		return table;
	}

	int getFrequency(Hashtable<String, Integer> table, String word) {
		if (table == null || word == null) {
			return -1;
		}

		word = word.toLowerCase();
		if (table.containsKey(word)) {
			return table.get(word);
		}

		return 0;
	}
}
