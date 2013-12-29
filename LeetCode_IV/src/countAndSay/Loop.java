package countAndSay;
// 因为第一个已经确定，肯定有第一个值，可以将初始值设置好，然后进去如果相同就跟新count 如果不同就将这个塞进string buffer 里面。
// 然后更新这个为新的char 和count
// 最后将最后一个也塞进去。
// 然后更新string 
public class Loop {
	public static String countAndSay(int n) {
		if (n <=0 ) {
			return null;
		}
		String s = "1";
		
		for (int i = 1 ; i < n; i++) {
			StringBuffer sb = new StringBuffer();
			char c = s.charAt(0);
			int count = 1;
			for (int j = 1; j < s.length(); j++) {
				if (s.charAt(j) == c) {
					count++;
				} else {
					sb.append(count);
					sb.append(c);
					c = s.charAt(j);
					count = 1;
				}
			}
			
			sb.append(count);
			sb.append(c);
			s = sb.toString();
		}
		return s;
	}
	
	public static void main(String[] args) {
		for (int i = 1; i < 8 ; i++) {
			System.out.println(countAndSay(i));
		}
	}
}
