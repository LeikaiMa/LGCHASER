package wordLadder;
//V
//这个是单向的，每一次进行的时候是取这个生成新的和自己不同的元素，如果到达结果，返回正确，然后将走过的步数+1之后返回。因为这个算是预测下一步，所以要+1
//如果不是就将这个放在新的level的list 里面，类似于visited 的功能，这里破换字典直接删掉里面的元素。
//然后将新的 list 和现在的list 进行更换，不断地循环，直到没有备选值为止，这时候没有找到结果，说明是没有值。
//这个思路比较清楚，可以直接一步一步走下去。
import java.util.ArrayList;
import java.util.HashSet;
//这个要注意的是在每次判断完了之后，将这个的值给删掉，这样下次在里面进行比较的时候就不需要再有重复的进行比较
//而且也也是最短的距离。要注意的是，本来是想等到下一次再删，但是有可能在这一层里面就有很多相同的，如果不删，会加进去很多相同的，所以应该得到一个就删一个。
//还有一个自己没有注意的是每次的时候应该将len + 1
public class RemoveDirectlyFromHashSet {
	public int ladderLength(String start, String end, HashSet<String> dict) {
		if (start.equals(end)) {
			return 1;
		}

		ArrayList<String> level = new ArrayList<String>();

		level.add(start);

		int len = 0;

		while (!level.isEmpty()) {
			len++;
			ArrayList<String> tmp = new ArrayList<String>();
			for (String s : level) {
				if (helper(dict, s, tmp, end)) {
					return len + 1;
				}
			}

			level = tmp;
		}

		return 0;
	}

	private boolean helper(HashSet<String> dict, String s,
			ArrayList<String> tmp, String end) {
		for (int i = 0; i < s.length(); i++) {
			char word[] = s.toCharArray();
			for (char c = 'a'; c <= 'z'; c++) {
				word[i] = c;
				String w = new String(word);

				if (w.equals(end)) {
					return true;
				} else if (dict.contains(w)) {
					tmp.add(w);
					dict.remove(w);
				}
			}
		}

		return false;
	}
}
