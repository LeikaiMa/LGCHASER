package scrambleString;

public class DP {
	public static boolean isScramble(String s1, String s2) {
		if (s1 == null && s2 == null) {
			return true;
		}
		if (s1.isEmpty() && s2.isEmpty()) {
			return true;
		}
		int l1 = s1.length();
		int l2 = s2.length();
		if (l1 != l2) {
			return false;
		}
		if (l1 == 1) {
			if (s1.charAt(0) == s2.charAt(0)) {
				return true;
			} else {
				return false;
			}
		}
		int n = l1;
		boolean[][][] dp = new boolean[n][n][n + 1];
		
		for (int i = n-1; i>= 0; i--) {
			for (int j = n -1; j >= 0; j--) {
				for (int k = 1; k <= n - Math.max(i, j); k++) {
					if (s1.substring(i, i+ k).equals(s2.substring(j,j+ k))) {
						dp[i][j][k] = true;
					} else {
						for (int l = 1; l < k; l++) {
							if (dp[i][j][l] && dp[i+l][j+l][k - l] || dp[i][j + k -l][l] && dp[i + l][j][k-l] ) {
								dp[i][j][k] = true;
								break;
							}
						}
					}
				}
			}
		}
		
		return dp[0][0][n];

	}
	
	public static void main(String[] args) {
		String s1= "abcd";
		String s2= "bdac";
//		String s1= "abcdd";
//		String s2= "dbdac";
		System.out.println(isScramble(s1, s2) == false);
		 s1= "ab";
		 s2 = "ba";
		 System.out.println(isScramble(s1, s2) ==  true);
		s1 = "ymjmfxshglxwrrgufcvvzjuietjzzz";
		s2 = "fxczujvmwizrzgxgjmvzelyjthusrf";
		System.out.println(isScramble(s1, s2));
	}
}
