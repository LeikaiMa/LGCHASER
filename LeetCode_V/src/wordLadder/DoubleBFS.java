package wordLadder;

import java.util.ArrayList;
import java.util.HashSet;
// 这个用的是双向bfs，因为起点和终点都出现了，所以可以同时进行，一种和我一样是两边同时进一步，还有一个是看哪边少，就走哪边，目测后面更加合理一些。
// 因为不把起点和终点放在visited 里面，因为放进去了就没法区分这个是在字典里还是不在字典里。
// 然后两边通过自己的arraylist 的单词衍生出更改一个的单词，
// 同时要判断是不是两边已经汇合了，如果是在另一个list 的visited 发现的，说明是通过字典这个顺序来访问到的，那么看对方是不是本身就在字典里
// 如果本身就是在字典里面，就说明是2 * level -2 ，如果不在字典里就是2 * level -1  因为反向找比正向找少执行一次就要-1
// 因为开始的level 设计为1，然后又加了1，如果找到最后的结果，就直接返回len，其实这个只是检查会不会一步到end ，这样end 直接到start 那一步是多余的
// 反向的话只需要考虑一种情况，比较奇怪，没有搞清楚。但是实际的情况这个只能说一说，操作太多
// 如果这个单词没有访问过，而且是在字典里面的，就加到新的list 里面。

public class DoubleBFS {
	public static int ladderLength(String start, String end,
			HashSet<String> dict) {
		if (start.equals(end)) {
			return 1;
		}

		HashSet<String> visitedS = new HashSet<String>();
		HashSet<String> visitedE = new HashSet<String>();

		int len = 1;
		ArrayList<String> arrayListS = new ArrayList<String>();
		ArrayList<String> arrayListE = new ArrayList<String>();

		arrayListS.add(start);
		arrayListE.add(end);

		while (!arrayListS.isEmpty() && !arrayListE.isEmpty()) {
			len++;
			ArrayList<String> tmpS = new ArrayList<String>();
			for (String s : arrayListS) {
				for (String next : getNext(s)) {
					if (visitedE.contains(next)) {
						return dict.contains(start) ? len * 2 - 2 : len * 2 - 1;
					} else if (next.equals(end)) {
						return len;
					} else if (dict.contains(next) && !visitedS.contains(next)) {
						visitedS.add(next);
						tmpS.add(next);
					}
				}
			}
			arrayListS = tmpS;

			ArrayList<String> tmpE = new ArrayList<String>();
			for (String s : arrayListE) {
				for (String next : getNext(s)) {
					if (visitedS.contains(next)) {
						return len * 2 - 1;
					} else if (next.equals(start)) {
						return len;
					} else if (dict.contains(next) && !visitedE.contains(next)) {

						visitedE.add(next);
						tmpE.add(next);
					}
				}
			}
			arrayListE = tmpE;

		}
		return 0;
	}

	private static ArrayList<String> getNext(String s) {
		ArrayList<String> nexts = new ArrayList<String>();
		for (int i = 0; i < s.length(); i++) {
			char[] word = s.toCharArray();
			for (char c = 'a'; c <= 'z'; c++) {
				if (c != s.charAt(i)) {
					word[i] = c;
				}
				nexts.add(new String(word));
			}
		}
		return nexts;
	}

	public static void main(String[] args) {
		String start = "hit";
		String end = "cog";
		HashSet<String> dict = new HashSet<String>();
		dict.add("hot");
		dict.add("dot");
		dict.add("dog");
		dict.add("lot");
		dict.add("log");

		System.out.println(ladderLength(start, end, dict) == 5);
		start = "a";
		end = "c";
		dict = new HashSet<String>();
		dict.add("a");
		dict.add("b");
		dict.add("c");
		System.out.println(ladderLength(start, end, dict) == 2);

		start = "hot";
		end = "dog";
		dict = new HashSet<String>();

		dict.add("hot");
		dict.add("dog");
		System.out.println(ladderLength(start, end, dict) == 0);

		start = "hot";
		end = "dog";
		dict = new HashSet<String>();
		dict.add("hot");
		dict.add("dot");
		dict.add("dog");

		System.out.println(ladderLength(start, end, dict) == 3);

		start = "red";
		end = "tax";

		dict = new HashSet<String>();
		dict.add("ted");
		dict.add("tex");
		dict.add("red");
		dict.add("tax");
		dict.add("tad");
		dict.add("den");
		dict.add("rex");
		dict.add("pee");
		System.out.println(ladderLength(start, end, dict) == 4);

	}
}
