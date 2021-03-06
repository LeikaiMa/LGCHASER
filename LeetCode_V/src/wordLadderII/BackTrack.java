package wordLadderII;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
// 这个是要将所有的情况都输出来，而且是要最短的路径，所以用的是是BFS，因为要将最后的结果输出来，所以用的还是backtrack的方法，
// 因为这个是所有的值，所以每一个值不一定是只从一个过来的，那么backtrack 的value 就不能仅仅是一个string 而应该是一个arraylist
// 然后要注意的是上面到下一层的情况有可能是几个指向同一个，所以就不能很快的去更新visited ，但是要注意的是这个只能是在同一层出现，如果不在同一层出现，就不是最短的路径。
// 所以得出的结论是是一层一层的更新visited 这样和level 遍历一样，设置一个中间变量。等到结束这一层结束之后再把所有visit 过的东西放进大的visit 的里面。
// 而且这样的情况就是要得到全部的路径，最后一个end也要做一个node 存到map 里面。而不是像只出一条，遇到end 就开始backtrack
// 采用的策略是是在每一层结束之后看整个的back track 的map 里面有没有end 这个node 如果有就说明结束了。可以进行backtrack 然后把结果输出来。
// 在倒推的时候要注意的是因为是arraylist 所以开始将end 也包装成arraylist 这样可以满足递归的形式。其实也可以用while 来进行，但是递归写的快一点就用了递归。
// 还有一个原因只有递归，从最后的开始才能new 足够线路，如果是正着过来就不知道有多少条线过来，还要每次都new 出来然后进行复制。
// 现在这可以直接进行修改，
// base case 是看arraylist 里面有么有start 就说明已经到头了，这时候可以递归倒推回来
public class BackTrack {
	public static ArrayList<ArrayList<String>> findLadders(String start,
			String end, HashSet<String> dict) {
		ArrayList<ArrayList<String>> ladders = new ArrayList<ArrayList<String>>();
		HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();

		HashSet<String> visited = new HashSet<String>();
		HashSet<String> levelElements = new HashSet<String>();
		levelElements.add(start);

		while (!levelElements.isEmpty()) {
			HashSet<String> levelVisited = new HashSet<String>();
			HashSet<String> tmpLevelElements = new HashSet<String>();
			for (String s : levelElements) {
				for (String next : getNext(s)) {
					if (next.equals(end)
							|| (dict.contains(next) && !visited.contains(next))) {
						tmpLevelElements.add(next);
						levelVisited.add(next);
						if (map.containsKey(next)) {
							map.get(next).add(s);
						} else {
							ArrayList<String> parent = new ArrayList<String>();
							parent.add(s);
							map.put(next, parent);
						}
					}
				}
			}
			visited.addAll(levelVisited);
			levelElements = tmpLevelElements;
			if (map.containsKey(end)) {
				ArrayList<String> ends = new ArrayList<String>();
				ends.add(end);
				ladders = getBackTrack(map, ends, start);
				return ladders;
			}
		}
		return ladders;
	}

	private static ArrayList<ArrayList<String>> getBackTrack(
			HashMap<String, ArrayList<String>> map, ArrayList<String> end,
			String start) {
		ArrayList<ArrayList<String>> ladders = new ArrayList<ArrayList<String>>();
		if (end.contains(start)) {
			ArrayList<String> ladder = new ArrayList<String>();
			ladder.add(start);
			ladders.add(ladder);
		} else {
			for (String s : end) {
				ArrayList<String> preivous = map.get(s);
				ArrayList<ArrayList<String>> tmp = getBackTrack(map, preivous,
						start);
				for (ArrayList<String> t : tmp) {
					t.add(s);
					ladders.add(t);
				}
			}
		}

		return ladders;
	}

	private static ArrayList<String> getNext(String s) {
		ArrayList<String> nexts = new ArrayList<String>();
		for (int i = 0; i < s.length(); i++) {
			char[] word = s.toCharArray();
			for (char c = 'a'; c <= 'z'; c++) {
				if (c == s.charAt(i)) {
					continue;
				}
				word[i] = c;
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
		ArrayList<ArrayList<String>> ladders = new ArrayList<ArrayList<String>>();
		ladders = findLadders(start, end, dict);
		for (ArrayList<String> ladder: ladders) {
			System.out.println(ladder);
		}
		System.out.println();
		start = "a";
		end = "c";
		dict = new HashSet<String>();
		dict.add("a");
		dict.add("b");
		dict.add("c");
		
		ladders = findLadders(start, end, dict);
		for (ArrayList<String> ladder: ladders) {
			System.out.println(ladder);
		}
		System.out.println();
		start = "hot";
		end = "dog";
		dict = new HashSet<String>();

		dict.add("hot");
		dict.add("dog");
		
		ladders = findLadders(start, end, dict);
		for (ArrayList<String> ladder: ladders) {
			System.out.println(ladder);
		}
		System.out.println();
		start = "hot";
		end = "dog";
		dict = new HashSet<String>();
		dict.add("hot");
		dict.add("dot");
		dict.add("dog");
		

		ladders = findLadders(start, end, dict);
		for (ArrayList<String> ladder: ladders) {
			System.out.println(ladder);
		}
		
		System.out.println();
		
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
		
		ladders = findLadders(start, end, dict);
		for (ArrayList<String> ladder: ladders) {
			System.out.println(ladder);
		}

	}

}
