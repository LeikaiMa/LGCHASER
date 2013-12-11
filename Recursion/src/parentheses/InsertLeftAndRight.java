package parentheses;

// 重新思考这题的本质，其实就是在每个index 里面插入左括号或者是右括号。 但是要满足基本的syntax
// 左括号只要有就可以插，右括号只要是比左括号多就可以插。如果不满足这两条条件就不是正确的，这时候就可以将其舍弃。
// 递归一般的流程也就是先判断不符合的，之后看base case 如果base case 不满足就要进行递归。
// 递归的时候可以检测能否插入左括号，可以的就直接插入，然后移到下一格，进行同样的递归。直到最后。
// 右括号同样也是，也是要满足最基本的条件，因为本质上左括号要先插入，所以左括号在前，右括号在后。
// 但是 两个不是互斥条件，所以不需要if else
// 这里面用到一个string 里一个比较重要的method 就是copyValueOf 就是将character的数组连接在一起。
import java.util.ArrayList;

public class InsertLeftAndRight {
	public void addParen(ArrayList<String> list, int leftRem, int rightRem, char[] str, int count){
		if (leftRem < 0 || rightRem < leftRem) {
			return;
		}
		if (leftRem == 0 && rightRem == 0) {
			String s = String.copyValueOf(str);
			list.add(s);
		} else {
			if (leftRem > 0) {
				str[count] = '(';
				addParen(list, leftRem - 1, rightRem, str, count + 1);
			}
			
			if (rightRem > leftRem) {
				str[count] = ')';
				addParen(list, leftRem, rightRem - 1, str, count + 1);
			}
		}
	}
	
	public ArrayList<String> generateParens(int count) {
		char[] str = new char[count * 2];
		ArrayList<String> list = new ArrayList<String>();
		addParen(list, count, count, str, 0);
		return list;
	}
}
