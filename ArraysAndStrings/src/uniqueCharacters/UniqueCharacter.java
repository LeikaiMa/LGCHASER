package uniqueCharacters;
// 只考虑ASCII 因为知道总的个数，可以直接用一个array 来进行标记。
// 可以直接排除的，可以直接在最开始进行排除，这样可以避免多余的计算
// 然后每一次进行check 进行标记。
public class UniqueCharacter {
	public boolean isUniqueChars(String str) {
		if (str.length() > 256) {
			return false;
		}
		
		boolean[] char_set = new boolean[256];
		for (int i= 0; i < str.length(); i++) {
			int val = str.charAt(i);
			if (char_set[val]) {
				return false;
			}
			char_set[val] = true;
		}
		return true;
	}
}
