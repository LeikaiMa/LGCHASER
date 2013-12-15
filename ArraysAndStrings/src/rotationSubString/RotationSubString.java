package rotationSubString;
// 如果是要看是否是rotation ，根据观察可以看出如果将一个string 两个连接到一起，中间收尾连接到一起肯定就是另外一个string
// 但是有些条件要提前可以去除，比如两个string 的长度本来就不一样，或者一个就为空的字符串，这些没必要比的就需要直接排除
public class RotationSubString {
	public boolean isRotation(String s1, String s2) {
		int len = s1.length();
		if (len == s2.length() && len > 0) {
			String s1s1 = s1 + s1;
			return isSubstring(s1s1, s2);
		}
		return false;
	}

	private boolean isSubstring(String s1s1, String s2) {
		// TODO Auto-generated method stub
		return false;
	}
}
