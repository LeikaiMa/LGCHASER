package wordLadderII;
//V
//这个是要将所有的情况都输出来，而且是要最短的路径，所以用的是是BFS，因为要将最后的结果输出来，所以用的还是backtrack的方法，
//因为这个是所有的值，所以每一个值不一定是只从一个过来的，那么backtrack 的value 就不能仅仅是一个string 而应该是一个arraylist
//然后要注意的是上面到下一层的情况有可能是几个指向同一个，所以就不能很快的去更新visited ，但是要注意的是这个只能是在同一层出现，如果不在同一层出现，就不是最短的路径。
//所以得出的结论是是一层一层的更新visited 这样和level 遍历一样，设置一个中间变量。等到结束这一层结束之后再把所有visit 过的东西放进大的visit 的里面。
//而且这样的情况就是要得到全部的路径，最后一个end也要做一个node 存到map 里面。而不是像只出一条，遇到end 就开始backtrack
//采用的策略是是在每一层结束之后看整个的back track 的map 里面有没有end 这个node 如果有就说明结束了。可以进行backtrack 然后把结果输出来。
//在倒推的时候要注意的是因为是arraylist 所以开始将end 也包装成arraylist 这样可以满足递归的形式。其实也可以用while 来进行，但是递归写的快一点就用了递归。
//还有一个原因只有递归，从最后的开始才能new 足够线路，如果是正着过来就不知道有多少条线过来，还要每次都new 出来然后进行复制。
//现在这可以直接进行修改，
//base case 是看arraylist 里面有么有start 就说明已经到头了，这时候可以递归倒推回来
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
//原来写的比较好。但是这个是自己写的，总结经验就是一个是要用hashset 去重，因为很多情况可能会有重复。 还有一个到了最后一个应该就不要再加了，而是直接将这个放进去。因为每次都是之前就加好了。
//之前有个比较好的，就是直接看contain 就不用用prev 但是要返回之前的值。之前那个是正着加值，现在是倒着加值。
public class SaveVistiedStatusAfterEachLevel {
    public static ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
        ArrayList<ArrayList<String>> results = new ArrayList<ArrayList<String>>();
        HashSet<String> level = new HashSet<String>();
        level.add(start);
        if (start.equals(end)) {
        	ArrayList<String> result = new ArrayList<String>();
            result.add(end);
            return results;
        }
        
        HashSet<String> visited = new HashSet<String>();
        visited.add(start);
        
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        
        while (!level.isEmpty()) {
            HashSet<String> tmp = new HashSet<String>();
            for (String s : level) {
                helper(s, end, map, visited, dict, tmp);
            }
            
            visited.addAll(tmp);
            
            if (visited.contains(end)) {
                ArrayList<String> result = new ArrayList<String>();
                result.add(end);
                backTrack(results, end, start, map, result);
                return results;
            } else {
                level = tmp;
            }
        }
        
        return results;
    }
    
    private static void backTrack(ArrayList<ArrayList<String>> results, String prev, String start, HashMap<String, ArrayList<String>> map, ArrayList<String> result) {
        if (prev.equals(start)) {
            results.add(new ArrayList<String>(result));
        } else {
            ArrayList<String> parents = map.get(prev);
            for (String s : parents) {
                result.add(0, s);
                backTrack(results, s, start, map, result);
                result.remove(0);
            }
        }
    }
    
    private static void helper(String s, String end, HashMap<String, ArrayList<String>> map, HashSet<String> visited, HashSet<String> dict, HashSet<String> tmp) {
        for (int i = 0; i < s.length(); i++) {
            char[] word = s.toCharArray();
            
            for (char c = 'a'; c <= 'z'; c++) {
                word[i] = c;
                String w = new String(word);
                if (!visited.contains(w) && (dict.contains(w) || w.equals(end))) {
                    tmp.add(w);
                    if (map.containsKey(w)) {
                        map.get(w).add(s);
                    } else {
                        ArrayList<String> parents = new ArrayList<String>();
                        parents.add(s);
                        map.put(w, parents);
                    }
                }
            }
        }
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
