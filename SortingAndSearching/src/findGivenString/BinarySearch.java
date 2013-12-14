package findGivenString;
// 对于一个已经sort 好的数组而言，要找到指定的string 自然会想到是二分法，但首先都要检查是否有越界的情况，如果有直接返回。如果没有进行递归。
// 因为递归的输入值不太相同，所以要另写一个函数。
// 新的函数里面同样也是需要先check 是否正确。然后定一下mid，根据mid 来进行相应的比较。
// 这个比较难解决的如果正好碰到“” 就无法比较。所以要做的修改是把mid 移到存在值的string 当中，可以用的是true + break 的形式。
// 同样要解决越界的问题。 其他的情况是判断这个mid 两边值是否存在。
// 与integer 不同的是，string 相比较可以用他自带的compareTo 这个函数，这样可以作为同样的比较。
// 在中间移动的时候自定义left 和right 来寻找最靠近mid 的不是空的string。这样可以节省遍历次数。

public class BinarySearch {
	public int searchR(String[] strings, String str, int first, int last) {
		if (first > last) {
			return -1;
		}

		int mid = (last + first) / 2;
		if (strings[mid].isEmpty()) {
			int left = mid - 1;
			int right = mid + 1;

			while (true) {
				if (left < first && right > last) {
					return -1;
				} else if (right <= last && !strings[right].isEmpty()) {
					mid = right;
					break;
				} else if (left >= first && !strings[left].isEmpty()) {
					mid = left;
					break;
				}
				right++;
				left--;
			}
		}
		
		if (str.equals(strings[mid])) {
			return mid;
		} else if (strings[mid].compareTo(str) < 0) {
			return searchR(strings, str, mid + 1, last);
		} else {
			return searchR(strings, str, first, mid - 1);
		}
	}

	public int search(String[] strings, String str) {
		if (strings == null || str == null || str == "") {
			return -1;
		}
		return searchR(strings, str, 0, strings.length - 1);
	}
}
