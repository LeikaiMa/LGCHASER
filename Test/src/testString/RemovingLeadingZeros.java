package testString;
// 这个保证了删除了0 但是保证0 在最后不被删除。
public class RemovingLeadingZeros {
	public static void main(String[] args) {
		String[] in = {
			    "01234",         // "[1234]"
			    "0001234a",      // "[1234a]"
			    "101234",        // "[101234]"
			    "000002829839",  // "[2829839]"
			    "0",             // "[0]"
			    "0000000",       // "[0]"
			    "0000009",       // "[9]"
			    "000000z",       // "[z]"
			    "000000.z",      // "[.z]"
			};
		
		for (String s : in) {
		    System.out.println("[" + s.replaceFirst("^0+(?!$)", "") + "]");
		}
	}
}
