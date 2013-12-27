package oneWordATime;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
// 从一个单词每次变换一个字母，这个字母必须是字典里面的，最终到达另一个单词。
// 展开来看，就是一个单词后面有很多种途径，然后展开一直到目的地的单词，整个展开像一张图，然后走最短的路径。
// 这时候就可以用BST， 在BST中主要是一个QUEUE，在QUEUE 全部结束后还没有找到想要的就说明没有这种情况，返回的是null
// 如果是要算depth 就要用两个queue 之间做一个轮换，将一个queue 全部排解完，把结果存到一个tmp的queue里面，然后这个queue 全部结束。之后进行轮换。
// 如果不需要算总共的depth，就可以直接取一个，然后将符合的直接塞到这个queue 里面。
// 这里面的candidates 粗略的是这个目前单词，替换一个字母形成的所有单词。
// 这里面用的是一个helper 函数。是从头到尾替换成A-Z， 注意的是之前就要把都换成大写。
// 替换的时候改成char Array 因为他改动比较好改，但是比较的时候还是原来的用charAt 来进行比较，因为他不变。
// 放进set 时候用string 的时候，新建可以直接用new String 把array 放进去。
// 取到这些candidates 之后，可以直接用for 来进行，不要担心要重新进入函数再走一遍。
// 首先看是否已经到达终点，如果到了就可以输出结果。
// 这时候要用backTrack 的方法，建一个list 现在有已经有两个值，一个是candidate 还有一个是原来的值，先将candidate 存进去，然后将原来的值backtrack 依次存进去list
// 存list 的时候因为是要正序排，所以可以在linkedlist add (0, v)或者可以直接用addFirst
// 直到为null 的时候，返回输出。
// 因为要backtrace 所以用一个map 将两个的联系关系在之前就存起来，以为是tree 的形式向下展开，这个时候要存就应该是反过来存，这样不会有重复的将原来的覆盖。
// 记住如果是一对多，就应该反过来存进tree
// 如果不是最后的结果，这个时候就应该将这个存到queue 里面
// 因为是刚刚是粗略的结果，所以要进行过滤。一个是要是字典里的词，还有一个是没有访问过的。这个时候就要建一个visited 的set，将每次的结果放进这个set
// 如果都通过了，就存进queue 而且要标记为已经访问，最后还要将这个路径连接关系保存起来，保存方法是反过来的多对一。
public class BackTrackBST {
	LinkedList<String> transform(String startWord, String stopWord, Set<String> dictionary) {
		startWord = startWord.toUpperCase();
		stopWord = stopWord.toUpperCase();
		Queue<String> actionQueue = new LinkedList<String>();
		Set<String> visitedSet= new HashSet<String>();
		Map<String, String> backtrackMap = new TreeMap<String, String>();
		
		actionQueue.add(startWord);
		visitedSet.add(startWord);
		
		while (!actionQueue.isEmpty()) {
			String w = actionQueue.poll();
			for (String v: getOneEditWords(w)) {
				if (v.equals(stopWord)) {
					LinkedList<String> list = new LinkedList<String>();
					list.add(v);
					while (w != null) {
						list.add(0, w);
						w = backtrackMap.get(w);
					}
					return list;
				}
				
				if (dictionary.contains(v)) {
					if (!visitedSet.contains(v)) {
						actionQueue.add(v);
						visitedSet.add(v);
						backtrackMap.put(v, w);
					}
				}
			}
		}
		return null;
		
	}
	
	Set<String> getOneEditWords(String word) {
		Set<String> words = new TreeSet<String>();
		for (int i = 0; i < word.length(); i++) {
			char[] wordArray = word.toCharArray();
			for (char c = 'A'; c <= 'Z'; c++) {
				if (c != word.charAt(i)) {
					wordArray[i] = c;
					words.add(new String(wordArray));
				}
			}
		}
		return words;
	}
}
