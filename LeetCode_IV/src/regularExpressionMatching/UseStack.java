package regularExpressionMatching;

import java.util.Stack;
// 这个方法是用正常前进，但是如果不匹配还是要倒退回来，因为不像另外一个情况，这个* 不能匹配任意，要根据p 不同的情况来进行不同的匹配。所以要将这个存起来。
// 因为要区别带有*号什么时候忽略什么时候要进行比较， 所以用了一个flag 当不行了之后要返回，就将flag 置true 一旦返回了一次之后就把flag 置回false。
// 一个大循环是看s 有没有结束。 首先要判断的是p 是否结束，如果p 结束了，s 还没有结束，说明不正常，要roll back 回去，而看能否back 的方法就是看存的stack 是否是空的，如果不是空的就可以从里面得到最近一次标记的记录点
// 这样将两个都置为标记点的位置，然后因为上次是忽略这个位置。这次就要进行比较，如果比较成功那么S 可以正常的前进一位，但是p 还是保持不变，等待下一次比较压栈，如果在比较的时候还是不行，就继续roll back ，直到要么成功，要么全部rollback 之后还是么有
// 那个时候就要进行返回。
// 下面正常进行，如果遇到了下一个是带有*号，先压栈，然后p+2 先忽略这个重新开始，比较两个的时候要判断有没有两个，不要到了末尾的情况。
// 如果是一个情况，先比较是否是. 然后比较 是否相同，如果是的话那么两个都正常的++
// 如果都不满足，看能否roll back 就是stack 里面有没有值，能roll back 就可以回去
// 如果还是不行，就说明是错误的，返回false
// 出来之后看p 是不是到末尾了。如果没有到看后面的是不是两个两个满足，都是*，这个表示他们都忽略掉了。
// 这个看起来要比递归要好，防止stack over flow
public class UseStack {
	public  boolean isMatch(String s, String p) {
		int indexS = 0;
		int indexP = 0;
		Stack<starIndex> stack = new Stack<starIndex>();
		boolean isBack = false;
		if (s == null || p == null) {
			return false;
		}
		if (s.isEmpty() && p.isEmpty()) {
			return true;
		} else if (p.isEmpty() && !s.isEmpty()) {
			return false;
		}

		int countStar = 0;
		for (int i = 0; i < p.length(); i++) {
			if (p.charAt(i) == '*') {
				countStar++;
			}
		}

		if (p.length() - countStar * 2 > s.length()) {
			return false;
		}
		
		while (indexS < s.length()) {
			if (indexP == p.length()) {
				if (!stack.isEmpty()) {
					starIndex node = stack.pop();
					indexP = node.indexP;
					indexS = node.indexS;
					isBack = true;
					continue;
				} else {
					return false;
				}
			}
			
			char cs = s.charAt(indexS);
			char cp = p.charAt(indexP);
			
			if (isBack) {
				if (cp == '.' || cs == cp) {
					indexS++;
					isBack = false;
					continue;
				} else if (!stack.isEmpty()){
					starIndex node = stack.pop();
					indexP = node.indexP;
					indexS = node.indexS;
					isBack = true;
					continue;
					
				} else {
					return false;
				}
			}
			
			if (indexP + 1 < p.length() && p.charAt(indexP + 1) == '*' ) {
				stack.push(new starIndex(indexS, indexP));
				indexP += 2;
			} else if (cp == '.' || cs == cp) {
				indexP++;
				indexS++;
			} else if (cs != cp && cp != '.' && !stack.isEmpty()) {
				starIndex node = stack.pop();
				indexP = node.indexP;
				indexS = node.indexS;
				isBack = true;
			} else {
				return false;
			}
		}
		
		while (indexP < p.length()) {
			if (indexP + 1 >= p.length()) {
				return false;
			} else if(p.charAt(indexP + 1) != '*') {
				return false;
			}
			indexP += 2;
		}
		
		return true;

	}
	
	public class starIndex {
		int indexS;
		int indexP;
		public starIndex(int s, int p) {
			indexS = s;
			indexP = p;
		}
		public String toString() {
			return "S: " + indexS + " P: " + indexP;
		}
	}
	
	public static void main(String[] args) {
		UseStack useStack = new UseStack();
		System.out.println(useStack.isMatch("aaa", "ab*a*c*a") == true);
		System.out.println(useStack.isMatch("aa", "a") == false);
		System.out.println(useStack.isMatch("aa", "aa") == true);
		System.out.println(useStack.isMatch("aaa", "aa") == false);
		System.out.println(useStack.isMatch("aa", "a*") == true);
		System.out.println(useStack.isMatch("aa", ".*") == true);
		System.out.println(useStack.isMatch("ab", ".*") == true);
		System.out.println(useStack.isMatch("aab", "c*a*b") == true);
	}

}
