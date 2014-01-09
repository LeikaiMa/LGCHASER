package validPalindrome;
// II
//首先将非字母和数字的用replace 进行替换掉，然后把string 转换为小写。
//然后头尾一次向内靠拢，如果不同就直接返回false 否则返回true
//这个比另一种写起来更加容易，但是应为要把所有的lowercase 所以要慢一点。
//另外一种是遇到不同的看是否是字母，如果变成全大写或者全小写再进行比较。
public class FrontBackReplaceNonCharacter {
	public boolean isPalindrome(String s) {
        if (s == null) {
            return true;
        }
        
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        
        return true;
     }
}
