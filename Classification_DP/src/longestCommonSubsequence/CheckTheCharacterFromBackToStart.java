package longestCommonSubsequence;
// 要求两个最长的common sequence ，这个common sequence 指的是可以删去其中的元素，然后剩下共同的，就是共同的徐律。
// 用dp 的方法来进行储存，所有的组合都需要进行尝试。然后他的基本条件是放在最后两个都是length 的时候这个是为0的长度。
// 如果相同的就说明是两个同时+1之后这个地方存进来的，如果不同就说明是是i+1 或者是 j+1 的地方过来的，因为是直接删除一个，所以取两个的大值。
// 这样到了00 的情况后退出
// 后面就是从 0 0 开始，如果两个元素相同，那么就加到stringbuffer 里面，然后将两个的index 都+1 如果是不同的就看i+1 j 和 i j+1 哪一个更多。
// 然后选更多的一个。知道i 或者j 有一个过界。
// http://www.dsalgo.com/2013/02/longest-common-subsequence.html
public class CheckTheCharacterFromBackToStart {
	
	public static void main(String[] args) {
		String a = "alfkjalfjlkj";
		String b = "ajflaklfjlaj";
		String result = findLCS(a, b);
		System.out.println(result);
	}
	
	
	private static String findLCS(String a, String b) {
		int[][] memo = new int[a.length() + 1][b.length() + 1];

		for (int i = a.length() - 1; i >= 0; i--) {
			for (int j = b.length() - 1; j >= 0; j--) {
				if (a.charAt(i) == b.charAt(j)) {
					memo[i][j] = memo[i + 1][j + 1] + 1;
				} else {
					memo[i][j] = Math.max(memo[i + 1][j], memo[i][j + 1]);
				}
			}
		}

		int i = 0;
		int j = 0;

		StringBuffer result = new StringBuffer();

		while (i < a.length() && j < b.length()) {
			if (a.charAt(i) == b.charAt(j)) {
				result.append(a.charAt(i));
				i++;
				j++;
			} else if (memo[i + 1][j] > memo[i][j + 1]) {
				i++;
			} else {
				j++;
			}
		}

		return result.toString();
	}
}
