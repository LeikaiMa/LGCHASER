package generateParentheses;
// 括号的不同形式，是从最开始的空的开始，开始往里面插括号，原则是插在最开始的，遇到一个左边的括号，插在左边的括号后面，
// 要注意，自己第一次出错是在将开始插（）放在内层的循环里面。实际上应该是放在外城的循环里面。原来用的是递归的方法，其实可以用两个hashset 进行轮换的方法，实现iterative 的方法，执行的次数是n 的大小。
// 储存的形式因为可能有重复的，所以用的是hashset 来进行储存。
import java.util.ArrayList;
import java.util.HashSet;

public class Iterative {
	public static ArrayList<String> generateParenthesis(int n) {
		ArrayList<String> results = new ArrayList<String>();
		HashSet<String> paren = new HashSet<String>();
		paren.add("");

		for (int i = 0; i < n; i++) {
			HashSet<String> tmp = new HashSet<String>();
			for (String s : paren) {
				for (int j = 0; j < s.length(); j++) {
					if (s.charAt(j) == '(') {
						tmp.add(insertParen(s, j));
					}
				}
				tmp.add("()" + s);
			}
			paren = tmp;
		}
		results.addAll(paren);
		return results;
	}

	private static String insertParen(String s, int j) {
		StringBuffer sb = new StringBuffer();
		sb.append(s.substring(0, j + 1));
		sb.append("()");
		sb.append(s.substring(j + 1));
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(generateParenthesis(1));
	}
}
