package letterCombinationOfPhoneNumber;
// 典型DFS的问题，用map 将里面对应的关系存起来，然后遍历的时候一层一层的加上去，然后进入，出来之后删去。知道到尾部，将buffer 的东西塞入最后结果里面
// 注意点是没有时候用输出的“” 而不是空，
// 而buffer 初始状态的情况也是赋值为“”
// 然后buffer要删除的是delete 后面写index 而不是arraylist 里面的remove
import java.util.ArrayList;
import java.util.HashMap;

public class DFS {
	public static ArrayList<String> letterCombinations(String digits) {
		ArrayList<String> results = new ArrayList<String>();
		if (digits == null || digits.length() == 0) {
			results.add("");
			return results;
		}
		HashMap<Character, String> digit2Letter = new HashMap<Character, String>();

		digit2Letter.put('0', "");
		digit2Letter.put('1', "");
		digit2Letter.put('2', "abc");
		digit2Letter.put('3', "def");
		digit2Letter.put('4', "ghi");
		digit2Letter.put('5', "jkl");
		digit2Letter.put('6', "mno");
		digit2Letter.put('7', "pqrs");
		digit2Letter.put('8', "tuv");
		digit2Letter.put('9', "wxyz");

		StringBuffer letters = new StringBuffer("");
		letterCombinationsHelper(digits, digit2Letter, letters, results, 0);
		return results;
	}

	private static  void letterCombinationsHelper(String digits,
			HashMap<Character, String> digit2Letter, StringBuffer letters,
			ArrayList<String> results, int index) {
		if (index == digits.length()) {
			results.add(letters.toString());
		} else {
			char c = digits.charAt(index);
			if (c == '0' || c == '1' || c == '*' || c == '#') {
				letterCombinationsHelper(digits, digit2Letter, letters,
						results, index + 1);
			} else {
				String candidates = digit2Letter.get(c);
				for (int i = 0; i < candidates.length(); i++) {
					letters.append(candidates.charAt(i));
					letterCombinationsHelper(digits, digit2Letter, letters,
							results, index + 1);
					letters.deleteCharAt(letters.length() - 1);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		System.out.println(letterCombinations("23"));
	}
}
