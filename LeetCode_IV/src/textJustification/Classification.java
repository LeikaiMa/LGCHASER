package textJustification;

import java.util.ArrayList;

public class Classification {
	public static ArrayList<String> fullJustify(String[] words, int L) {
		ArrayList<String> results = new ArrayList<String>();
		if (words == null || words.length == 0) {
			return results;
		}
		int totalWords = words.length;
		int curLen = words[0].length();

		int lastI = 0;
		for (int i = 1; i <= totalWords; i++) {
			if (i == totalWords || curLen + words[i].length() + i - lastI > L) {
				StringBuffer result = new StringBuffer();
				int spaceSlots = i - 1 - lastI;
				int totalSpace = L - curLen;
				if (spaceSlots == 0) {
					result.append(words[i - 1]);
					appendSpace(result, totalSpace);

				} else {
					int perSpace = totalSpace / spaceSlots;
					int extraSpace = totalSpace % spaceSlots;
					if (i == totalWords) {
						for (int j = 0; j < spaceSlots; j++) {
							result.append(words[lastI + j]);
							result.append(" ");
						}
						result.append(words[lastI + spaceSlots]);
						appendSpace(result, totalSpace -spaceSlots);

					} else {
						for (int j = 0; j < spaceSlots; j++) {
							result.append(words[lastI + j]);
							appendSpace(result, j < extraSpace ? perSpace + 1
									: perSpace);
						}
						result.append(words[lastI + spaceSlots]);

					}
				}
				results.add(result.toString());
				if (i != totalWords) {
					curLen = words[i].length();
					lastI = i;
				}
			} else {
				curLen += words[i].length();
			}
		}
		return results;
	}

	public static void appendSpace(StringBuffer result, int num) {
		for (int i = 0; i < num; i++) {
			result.append("*");
		}
	}

	public static void main(String[] args) {
//		String[] words = { "This", "is", "an", "example", "of", "text",
//				"justification." };
//		int L = 16;
//		 String[] words = { "a", "b", "c", "d", "e", "f", "g" };
//		 int L = 1;
		 String[] words = { "What","must","be","shall","be."};
		 int L = 12;
		ArrayList<String> results = new ArrayList<>();
		results = fullJustify(words, L);
		System.out.println(results);
	}
}
