package implementStrStr;
//VII
//KMP 的方法主要就是因为如果这个不行，最好不要从前面一个一个进行比较而是应该跳到前面最合适的位置。
//这样就要有一个dp 的数组来记录下一次要跳的位置，所以会有一个next 的array 来进行记录
//next 表示如果这一位和要比较的string 的某一位不同应该要跳哪一位。
//这里就应该要计算整个跳转的位置。一个是j 表示现在要填的位置，一个是k 表示前面要跳转的位置。
//开始next 0 的时候表示如果没有匹配应该去哪里，用-1表示，这样能够标记出这个是头，
//所以k 也是从-1开始
//如果两个地方是相同的，就应该跳到现在k 标志位置 + 1 因为现在比较的是前一位，所以记录的结果应该是后一位的， 所以是j 是从0 开始，然后最后记录的是next[++j] = ++k
//应为开始是有个默认的情况所以是k 是 -1  的时候也是无条件开始，还有一种情况是两个是相同的情况。
//如果不同的情况应该k 就要返回前面的情况，而k 最有效的是next[k] 的，所以返回k 更新为next[k] 跳转到前面。

//这里有一个优化的情况是有可能是++j 和 ++k的位置p 上面相同，那么应该next[j] 所在的位置应该是next[k] 的位置。
//如果不是还是按照原来的，因为之前已经自加过了，所以是next[j] = k 的情况。

//这里比较的时候是i 和j 都是从0 开始，然后两个所在的位置不同，就应该移动的是j 的位置，而这个位置应该是之前算出来的是next 所对应的。
//如果是相同的，i 和j 都是要+1 比较下一位，如果j 变成了-1 就表示这个完全没有可能成立，就应该i移动到下一位。此时j 也要+1变成0 开始进行比较。

// 这里面一个是要注意的是getNext 这个函数中j 开始是0开始的，但是因为每次都是写后面一个，所以他的条件是 length - 1
// 而且在开始找的时候，条件是i 或者是j 到达末尾就出来，如果是j 到了末尾就说明有结果，如果是i 到了就说明没有结果
// 开头的情况要先判断 两个是不是empty 以及两个的长度是不是被比较的 比要比较的还要来的短
// 在主函数里面是两个都从0开始，j 如果是1 或者两个相等就往后，如果不相等，j 跳到next 来进行比较
// 在帮助函数里，j 开始 0 k开始是-1 k是-1 的时候或者两个相同的情况，就填next 如果下一个位置还是相同的，那么next j 也就是next k。
// 如果不相同，那么就是k 跳回 next k
public class KMPVersion {
	public String strStr(String haystack, String needle) {
		if (haystack.length() < needle.length()) {
			return null;
		}

		if (needle.length() == 0) {
			return haystack;
		}
		char[] h = haystack.toCharArray();
		char[] n = needle.toCharArray();

		int[] next = getNext(needle);
		int i = 0;
		int j = 0;

		while (i < h.length && j < n.length) {
			if (j == -1 || h[i] == n[j]) {
				i++;
				j++;
			} else {
				j = next[j];
			}
		}

		if (j == n.length) {
			return haystack.substring(i - j);
		} else {
			return null;
		}
	}

	public int[] getNext(String needle) {
		char[] p = needle.toCharArray();
		int[] next = new int[p.length];

		next[0] = -1;
		int j = 0;
		int k = -1;

		while (j < p.length - 1) {
			if (k == -1 || p[j] == p[k]) {
				if (p[++j] == p[++k]) {
					next[j] = next[k];
				} else {
					next[j] = k;
				}
			} else {
				k = next[k];
			}
		}

		return next;
	}
}
