package testArray;
//这里比较的时候是i 和j 都是从0 开始，然后两个所在的位置不同，就应该移动的是j 的位置，而这个位置应该是之前算出来的是next 所对应的。
//如果是相同的，i 和j 都是要+1 比较下一位，如果j 变成了-1 就表示这个完全没有可能成立，就应该i移动到下一位。此时j 也要+1变成0 开始进行比较。
public class KMPExamplePrefix {
	public static int KMP(String ts, String ps) {

	    char[] t = ts.toCharArray();

	    char[] p = ps.toCharArray();

	    int i = 0; // 主串的位置

	    int j = 0; // 模式串的位置

	    int[] next = KMP.getNext(ps);

	    while (i < t.length && j < p.length) {

	       if (j == -1 || t[i] == p[j]) { // 当j为-1时，要移动的是i，当然j也要归0

	           i++;

	           j++;

	       } else {

	           // i不需要回溯了

	           // i = i - j + 1;

	           j = next[j]; // j回到指定位置

	       }

	    }

	    if (j == p.length) {

	       return i - j;

	    } else {

	       return -1;

	    }

	}
}
