package restoreIPAddress;
// 典型的DFS问题。总共每个片段有3种可能， 1， 2， 3 的长度。一共有depth 是5 因为开始的时候是1，如果开始是0 就是4
// base case 是如果到了5，说明前面已经累计了4个片段，其实可以不用这个，因为arraylist 里面的size 已经是有了几个片段，
// 如果这个时候已经有4个片段了，但是还没有到结束那么就说明这种情况不成功。
// 如果是正好到了最后，就将这个放进最后的结果里，去除多余的点是用substring 的方法。
// 如果是在1-4层里面的时候，要注意的一点是，后面够不够1 2 3 种情况，如果已经不够，这种情况就跳过，就不继续dfs
// 还有就是0 只能是一位表示，不能用两个0 或者三个0表示，这时候就要看substring 的第一位是不是0 而且位数如果大于1 就也是直接跳过，
// 其他情况将substring 存进arraylist 然后继续下一层，因为是循环，DFS出来就将这个移除，加上新的
import java.util.ArrayList;

public class DFSRecursive {
	public static ArrayList<String> restoreIpAddresses(String s) {
		ArrayList<String> ips = new ArrayList<String>();
		if (s == null || s.length() < 4) {
			return ips;
		}
		ArrayList<String> pieces = new ArrayList<String>();
		restoreIpAddressesHelper(ips, s, pieces, 0, 1);
		return ips;
	}

	private static void restoreIpAddressesHelper(ArrayList<String> ips, String s,
			ArrayList<String> pieces, int index, int depth) {
		if (depth == 5 && index != s.length()) {
			return;
		} else if (depth == 5 && index == s.length()) {
			StringBuffer sb = new StringBuffer();
			for (String piece : pieces) {
				sb.append(piece);
				sb.append(".");
			}

			ips.add(sb.substring(0, sb.length() - 1));
		} else {
			for (int i = 1; i <= 3; i++) {
				if (index + i > s.length()) {
					continue;
				}
				String partIp = s.substring(index, index + i);
				if (partIp.charAt(0) == '0' && i >1) {
					continue;
				}
				int ip = Integer.valueOf(partIp);
				if (ip >= 0 && ip <= 255) {
					pieces.add(partIp);
					restoreIpAddressesHelper(ips, s, pieces, index + i,
							depth + 1);
					pieces.remove(pieces.size() - 1);
				}
			}

		}

	}
	
	public static void main(String[] args) {
		String ip = "010010";
		System.out.println(restoreIpAddresses(ip));
	}
}
