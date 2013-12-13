package replaceSpace;
// 如果在原来的string 里面要进行增加或者将原来的字符替换为更长的字符串。
// 如果还是原来的字符串，最好是先估算出总长度，然后在字符串的最后开始，一次往前，这样就不会覆盖掉没有处理的数据。
public class ReplaceSpaces {
	public void replaceSpaces(char[] str, int length) {
		int spaceCount = 0, newLength, i;
		for (i = 0; i < length; i++) {
			if (str[i] == ' ') {
				spaceCount++;
			}
		}

		newLength = length + spaceCount * 2;
		str[newLength] = '\0';
		for (i = length - 1; i >= 0; i--) {
			if (str[i] == ' ') {
				str[newLength - 1] = '0';
				str[newLength - 2] = '2';
				str[newLength - 3] = '%';
				newLength = newLength - 3;
			} else {
				str[newLength - 1] = str[i];
				newLength = newLength - 1;
			}
		}
	}
}
