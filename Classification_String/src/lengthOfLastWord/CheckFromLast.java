package lengthOfLastWord;
// III
//要先过滤掉最后的可能的空格，如果全部是空格直接返回0
//再从后向前数不是空格的数，如果遇到空格就提前出来。
//最后返回数的个数。
public class CheckFromLast {
	public int lengthOfLastWord(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        
        int index = s.length() - 1;
        while (index >= 0 && s.charAt(index) == ' ') {
            index--;
        }
        
        int num = 0;
        while (index >= 0 && s.charAt(index) != ' ') {
            num++;
            index--;
        }
        
        return num;
    }
}
