package testStringBuffer;
// 先记录last position 的位置，然后直接delete 掉就可以了
// 如果开始没有值同样的处理
// 没有加新的东西同样也是可以这么处理
public class DeletePreviousAdded {
	public static void main(String[] args) {
		StringBuffer sb= new StringBuffer();
//		
		sb.append("abc");
		int lastPos= sb.length();
		System.out.println(lastPos);
//		sb.append("def");
		System.out.println(sb.delete(lastPos, sb.length()));
	}
}
