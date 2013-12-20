package validPalindrome;

public class ValidPalindrome {
	public static boolean isPalindrome(String s) {
		if (s == null) {
			return false;
		}
		if (s.isEmpty()) {
			return true;
		}

		s = s.replaceAll("[^a-zA-Z0-9]", "");
		int l = 0;
		int h = s.length() - 1;
		while (l < h) {
			char low = s.charAt(l);
			char high = s.charAt(h);
			if (low == high) {
				l++;
				h--;
				continue;
			}
			if (Character.isLetter(low) && Character.isLetter(high)) {
				if (Character.toLowerCase(low) == Character.toLowerCase(high)) {
					l++;
					h--;
					continue;
				}
			}
			break;
		}
		if (l < h) {
			return false;
		} else {
			return true;
		}
	}

	public static void main(String[] args) {
		String s = "A man, a plan, a canal: Panama";
		System.out.println(isPalindrome(s) == true);
		s = "race a car";
		System.out.println(isPalindrome(s) == false);
		s = "1a2";
		System.out.println(isPalindrome(s) == false);
	}
}
