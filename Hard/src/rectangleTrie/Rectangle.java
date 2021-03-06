package rectangleTrie;
// 建立一个新的rectangle 每一个格子里面存储每一个char 行表示字典里面的单词。要检查的是列里面的是不是单词。
// 得到一列的时候值得学习的是，建一个数组，然后将每个列的都存进去。 然后返回的string 直接新建就可以。直接new 出来就可以。
// 看是不是完整的，直接把一列拿出，如果不是词典里的单词直接返回错误。最后返回正确。
// 还要比较是不是正好的是height 如果不是也要返回错误
// 看部分是不是吻合，用trie 来进行。看是不是在trie 里面存在。
// 增加一行里面可以学习的是用getChar 这个函数，是将前面取substring 然后后面第三个参数是目标char 数组，然后是起始的index

public class Rectangle {
	public int height;
	public int length;
	public char[][] matrix;

	public Rectangle(int len) {
		this.length = len;
	}

	public Rectangle(int length, int height, char[][] letters) {
		this.height = letters.length;
		this.length = letters[0].length;
		matrix = letters;
	}

	public char getLetter(int i, int j) {
		return matrix[i][j];
	}

	public String getColumn(int i) {
		char[] column = new char[height];
		for (int j = 0; j < height; j++) {
			column[j] = getLetter(j, i);
		}

		return new String(column);
	}

	public boolean isComplete(int l, int h, WordGroup groupList) {
		if (height == h) {
			for (int i = 0; i < l; i++) {
				String col = getColumn(i);
				if (!groupList.containsWord(col)) {
					return false;
				}
			}
			return true;
		}
		return false;
	}

	public boolean isPartialOK(int l, Trie trie) {
		if (height == 0) {
			return true;
		}
		for (int i = 0; i < l; i++) {
			String col = getColumn(i);
			if (!trie.contains(col)) {
				return false;
			}
		}
		return true;
	}

	public Rectangle append(String s) {
		if (s.length() == length) {
			char[][] temp = new char[height + 1][length];
			for (int i = 0; i < height; i++) {
				for (int j = 0; j < length; j++) {
					temp[i][j] = matrix[i][j];
				}
			}
			s.getChars(0, length, temp[height], 0);
			return new Rectangle(length, height + 1, temp);
		}
		return null;
	}

	public void print() {
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < length; j++) {
				System.out.println(matrix[i][j]);
			}
			System.out.println(" ");
		}
	}
}
