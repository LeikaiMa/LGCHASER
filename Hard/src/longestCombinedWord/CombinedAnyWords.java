package longestCombinedWord;

import java.util.Arrays;
import java.util.HashMap;

public class CombinedAnyWords {
	String printLongestWord(String arr[]) {
		HashMap<String, Boolean> map = new HashMap<>();
		for (String str : arr) {
			map.put(str, true);
		}
		
		Arrays.sort(arr, new LengthComparator());
		return null;
	}
}
