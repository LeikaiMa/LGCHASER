package validNumber;
// 因为是一个字母一个字母往后检查，所以可以利用automata 这个方法，具体形式类似于状态机，一个状态看输入量决定跳的状态。
// 跳的状态就是用一个二维数组来进行表示，row 表示状态的个数，column 表示输入量的个数，
// 这样就有个问题，输入的参量如何用数字来进行表示，想到了可以用enum 然后java 里面他有个method 是叫做ordinal 可以调出他的index
// 因为是从0开始的，所以如果想要有个个数就只要在最后面加一个参量，例如这题用的num_inputs 这样正好是个数，
// 每个标明名字比较好进行后面的 操作。
// 下面是研究里面的输入状态，总共有6种，每次状态要考虑这些输入量的跳转情况。
// 例如有不符合的字符，统一用invalid 来进行表示， 有空格，有+- 号这个统一用的是sign 来进行表示，有数字，有指数形式，指数包括E 和e 这六种形式。
// 可以通过状态情况来进行跳转，也可以从输入变量来进行统一画状态图，来确定里面的跳转条件。
// 研究发现通过状态图，来考虑每个输入量还是比较方便而且不会漏。
// 首先刚进来的时候是是状态0， 这时候可能输入空格，跳转状态0 如果是数字，跳转状态1 如果是是+- 跳转状态3 如果是 .  跳转状态2 开始的就只有这些情况，其他的状态都是错的都是跳转到状态-1
// 研究状态1，这个状态是数字，而且是刚开始的数字，前面什么都没有，可以输入的数字，还是自己本身，可以是小数点，跳到状态4，是数字加上小数点的形式。或者是指数，跳到新的状态5，如果是空格，就是说明已经到快结束了，跳状态8 其他的状态的都是不合适的。
// 研究状态2，这个状态是开始就是小数点，情况比较特殊，他能够跳的状态也就是后面是跟上数字，这样和状态4一样都是小数点后面加上数字，其他无论什么输入字符都是不合适的，不能跟空格，不能跟指数加减号等等invalid 什么的也都不行。
// 研究状态3，这个状态是开头是+-号，这种情况和状态0差不多，就是不能再跟+- 所以如果是数字跳状态1，小数点跳状态2其他的都不行。
// 研究状态4，这个状态是前面跟上一个小数点的数字，可以跟的是数字还是跳本身，可以是指数，这样跳的是状态5，可以是空格，这个时候就说明快结束了。跳到状态8，其他情况都不行。
// 研究状态5，这个状态是研究指数的形式，可以是加上+-号，跳到状态是状态6，可以是数字，这样跳到状态7，因为这是指数后面的数字，所以是一个新的状态。 这个还不能后面接空格，也不能接小数点，因为小数点就只能用1次，而且指数也没有小数形式的
// 研究状态6，这个状态是指数后面的加减号，这个后面只能接数字，而且算是指数后面的数字，是状态7，其他都不行。
// 研究状态7，这个状态是指数后面的数字，可以接的数字本身，跳自己，可以接的是空格，那么就临近最后的结果，跳状态8，其他都不行。
// 研究状态8，这个状态是最后的空格形式，只能是空格，跳本身，其他都是不符合的，都是要跳-1的状态。
// 通过状态图，来写跳转的数组，就是在哪个状态下接收什么什么参量，值是下个状态是什么。
// 这样跳转的table 就建好了，就是在程序本身进行一个一个比较，开始状态的是0，一个一个进行比较，状态不断进行跳转，如果状态是-1的情况，就直接返回false
// 如果全部出来，要看最后的状态是不能够成为最终状态，最终的状态只能是以数字或者空格结尾，但空格不能是完全空格，也就是状态 1 4 7 8 这些状态。
// 比较好的例子，能够学习automata 的方法。图可以参考下面链接
// 参考http://discuss.leetcode.com/questions/241/valid-number
// 还有一个是新建二维数组的方法。不用一个一个插进去。

public class Automata {
	public enum InputType {
		INVALID, SPACE, SIGN, DIGIT, DOT, EXPONENT, NUM_INPUTS

	}

	public static int[][] transitionTable = { { -1, 0, 3, 1, 2, -1 },
			{ -1, 8, -1, 1, 4, 5 }, { -1, -1, -1, 4, -1, -1 },
			{ -1, -1, -1, 1, 2, -1 }, { -1, 8, -1, 4, -1, 5 },
			{ -1, -1, 6, 7, -1, -1 }, { -1, -1, -1, 7, -1, -1 },
			{ -1, 8, -1, 7, -1, -1 }, { -1, 8, -1, -1, -1, -1 }

	};

	public static boolean isNumber(String s) {
		if (s == null || s.length() == 0) {
			return false;
		}
		int state = 0;
		for (int i = 0; i < s.length(); i++) {
			InputType inputType = InputType.INVALID;
			char c = s.charAt(i);
			if (c == ' ') {
				inputType = InputType.SPACE;
			} else if (c == '+' || c == '-') {
				inputType = InputType.SIGN;
			} else if (Character.isDigit(c)) {
				inputType = InputType.DIGIT;
			} else if (c == '.') {
				inputType = InputType.DOT;
			} else if (c == 'e' || c == 'E') {
				inputType = InputType.EXPONENT;
			}
			state = transitionTable[state][inputType.ordinal()];
			if (state == -1) {
				return false;
			}
		}

		return state == 1 || state == 4 || state == 7 || state == 8;
	}
	
	public static void main(String[] args) {
		System.out.println(isNumber("0") == true);
		System.out.println(isNumber("-0") == true);
		System.out.println(isNumber(" 0.1 ") == true);
		System.out.println(isNumber("abc") == false);
		System.out.println(isNumber("1 a") == false);
		System.out.println(isNumber("2e10") == true);
		System.out.println(isNumber(".1") == true);
		System.out.println(isNumber("3.") == true);
		System.out.println(isNumber(".") == false);
		System.out.println(isNumber("+.8") == true);
		System.out.println(isNumber("+-.") == false);
		System.out.println(isNumber("6e6.5") == false);
		System.out.println(isNumber(" 005047e+6") == true);
		System.out.println(isNumber("6+1") == false);
		System.out.println(isNumber("4e+") == false);
	}
}