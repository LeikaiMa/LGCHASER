package longestCombinedWord;
// 如果是拆成任意部分的情况，就需要一部分一部分拆开进行验算，可以分为左边和后边两个部分，然后右边继续用同样的方法进行验证。 这时候就要反复调用自身
// 开始的时候还是和原来一样，将所有的都存到一个hashmap 中作为之后的检查，然后按照长度进行排序，保证从长到短进行排序，提高几率。
// 之后看这个能不能由里面的进行组合。 因为不能由自己来表示自己，所以开始有个是否是原始单词的flag 来进行check
// 进入里面如果不是原始单词才确定这个是否在map 里面有值。
// 然后一点一点延生进行check 左右是否都存在如果是就直接返回。如果不是可以将这个存进map 里面，标记好，作为DP 的一部分，这样能够避免重复计算。
import java.util.Arrays;
import java.util.HashMap;

public class CombinedAnyWords {
	String printLongestWord(String arr[]) {
		HashMap<String, Boolean> map = new HashMap<>();
		for (String str : arr) {
			map.put(str, true);
		}

		Arrays.sort(arr, new LengthComparator());
		for (String s : arr) {
			if (canBuildWord(s, true, map)) {
				System.out.println(s);
				return s;
			}
		}

		return "";
	}

	boolean canBuildWord(String str, boolean isOriginalWord,
			HashMap<String, Boolean> map) {
		if (map.containsKey(str) && !isOriginalWord) {
			return map.get(str);
		}

		for (int i = 1; i < str.length(); i++) {
			String left = str.substring(0, i);
			String right = str.substring(i);
			if (map.containsKey(left) && map.get(left) == true && canBuildWord(right, false, map)) {
				return true;
			}
		}
		
		map.put(str, false);
		return false;
	}
}
