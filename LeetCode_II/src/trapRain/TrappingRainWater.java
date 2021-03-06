package trapRain;

import java.util.ArrayList;

public class TrappingRainWater {
	public static int trap(int[] A) {
		int max = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] > max) {
				max = A[i];
			}
		}
		ArrayList<ArrayList<Integer>> heights = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < max; i++) {
			heights.add(new ArrayList<Integer>());
		}

		for (int i = 0; i < A.length; i++) {
			if (A[i] > 0) {
				for (int j = A[i] - 1; j >= 0; j--) {
					heights.get(j).add(i);
				}
			}
		}

		int total = 0;
		for (int i = 0; i < max; i++) {
			ArrayList<Integer> height = heights.get(i);
			if (height.size() > 1) {
				for (int j = 1; j < height.size(); j++) {
					total += height.get(j) - height.get(j - 1) - 1;
				}
			}
		}
		return total;
	}
	
	public static void main(String[] args) {
		int[] input = {0,1,0,2,1,0,1,3,2,1,2,1};
		int trapping;
		trapping = trap(input);
		System.out.println(trapping);
	}
}
