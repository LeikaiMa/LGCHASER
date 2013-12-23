package encodingXML;
// 可以用一个树状的结构来表示，基本的思路就是按照里面的要求一步一步进行。需要继续深入的先写下函数，等整体思路完成之后，写相应的空下来的函数的内容。
public class TreeEncoding {
	public static String encodeToString(Element root) {
		StringBuffer sb = new StringBuffer();
		encode(root, sb);
		return sb.toString();
	}
	
	public static void encode(Element root, StringBuffer sb) {
		encode(root.getNameCode(), sb);
		for (Attribute a: root.attributes) {
			encode(a, sb);
		}
		
		encode("0", sb);
		
		if (root.value != null && root.value != "") {
			encode(root.value, sb);
		} else {
			for (Element e: root.child) {
				encode(e, sb);
			}
		}
		encode("0", sb);
	}
	
	public static void encode(String v, StringBuffer sb) {
		sb.append(v);
		sb.append(" ");
	}
	
	public static void encode(Attribute attr, StringBuffer sb) {
		encode(attr.getTagCode(), sb);
		encode(attr.value, sb);
	}
}
