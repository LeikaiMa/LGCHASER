package magicIndex;

public class BruteForce {
	public static int magicSlow(int[] array) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == i) {
				return 1;
			}
		}
		return -1;
	}
}
