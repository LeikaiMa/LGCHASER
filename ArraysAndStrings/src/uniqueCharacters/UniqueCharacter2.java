package uniqueCharacters;

// 如果考虑到字符元素的总数比较少，可以直接用一个int的每个bit 来储存信息。 用这个字符的index 然后右移存到int 的固定位置。
// 存的时候用 |， 比较的时候用& 这样能够判断这一位是否被占用。
public class UniqueCharacter2 {

	public boolean isUniqueChars(String str) {
		int checker = 0;
		for(int i = 0; i < str.length(); i++) {
			int val = str.charAt(i) - 'a';
			if ((checker & (1 << val)) > 0) {
				return false;
			}
			checker |= (1 << val);
		}
		return true;
	}
}
