package rectangleTrie;
// 要求横竖都是单词的最大size
// 首先按照单词的长度分到每个不同的list 里面，index 是单词的长度 -1
// 然后有最大的长度，和最大的trie
// 要求最大的肯定是最长的开始，然后长宽是从1开始，然后两个要相乘等于size 这时候用控制变量法，看除下来是不是整除。
// 这样长宽定下来可以建rectangle，这时候可以分到private 的method 里面。
// 如果直接返回存在的值就直接返回，如果返回的不存在就继续进行，如果循环结束之后还是没有得到想要的值，就直接返回null
// 然后进入第一个私有函数，首先检查相对应的长宽有没有相对应的单词存在，如果没有就直接返回空。
// 如果有，看trie 有没有按照这些单词建出相应的，如果没有就要先新建，因为开始的时候只是建立了数组，没有新建里面的具体的内容
// 然后做好了准备工作，建好对应的trie 就开始一步一步建立相应的单词，
// 一行一行的填，因为这个算作一个递归。 所以base case 是h 于最终的相等，算作最终确立是完全的rectangle，检查每一行是不是就是单词。如果是就返回这个rectangle 如果不是就返回null
// 如果没有到base case ，这个时候应该算作是中间过渡，这个时候为了节约时间，检查partial 是不是，如果不是就没有必要继续进行，如果是才放行。
// 检查partial的时候用的是trie ，成功之后再增加下一行的单词，依然是全部的单词进行一一尝试。
// 如果不是返回。将现在的单词替换成新的，因为每次都是新建的reference 所以不需要进行删减。直到完全不行然后返回null。
// 退到最外面一层，如果成功就直接返回，如果不成功是null 就换长和宽，然后再进行尝试。
// 如果一直到最后还是不行就返回null
// 这题主要学习如何将整个题目模块化，如何将题目单独的东西分到相应的class 里面
import java.util.ArrayList;

public class Question {
	private int maxWordLength;
	private WordGroup[] groupList;
	private Trie trieList[];

	public Question(String[] list) {
		groupList = WordGroup.createWordGroups(list);
		maxWordLength = groupList.length;
		trieList = new Trie[maxWordLength];
	}

	public Rectangle maxRectangle() {
		int maxSize = maxWordLength * maxWordLength;

		for (int z = maxSize; z > 0; z--) {
			for (int i = 1; i <= maxWordLength; i++) {
				if (z % i == 0) {
					int j = z / i;
					if (j <= maxWordLength) {
						Rectangle rectangle = makeRectangle(i, j);
						if (rectangle != null) {
							return rectangle;
						}
					}
				}
			}
		}
		return null;
	}

	private Rectangle makeRectangle(int length, int height) {
		if (groupList[length - 1] == null || groupList[height - 1] == null) {
			return null;
		}

		if (trieList[height - 1] == null) {
			ArrayList<String> words = groupList[height - 1].getWords();
			trieList[height - 1] = new Trie(words);
		}

		return makePartialRectangle(length, height, new Rectangle(length));
	}

	private Rectangle makePartialRectangle(int l, int h, Rectangle rectangle) {
		if (rectangle.height == h) {
			if (rectangle.isComplete(l, h, groupList[h - 1])) {
				return rectangle;
			} else {
				return null;
			}
		}

		if (!rectangle.isPartialOK(l, trieList[h - 1])) {
			return null;
		}

		for (int i = 0; i < groupList[l - 1].length(); i++) {
			Rectangle orgPlus = rectangle.append(groupList[l - 1].getWord(i));
			Rectangle rect = makePartialRectangle(l, h, orgPlus);
			if (rect != null) {
				return rect;
			}
		}
		return null;
	}
}
