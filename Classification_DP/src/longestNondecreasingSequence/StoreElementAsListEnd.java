package longestNondecreasingSequence;

import java.util.ArrayList;
// store each element as the last one in every arraylist.
// add each element to the previous longest arraylist whose last element is less or equal to this element.
// return the longest arraylist as the result.
public class StoreElementAsListEnd {
	public static ArrayList<Integer> findLongestNondecreasingSequence(
			ArrayList<Integer> input) {
		ArrayList<ArrayList<Integer>> outputs = new ArrayList<>();
		ArrayList<Integer> output = new ArrayList<>();
		if (input.size() < 1) {
			return output;
		}

		output.add(input.get(0));
		outputs.add(output);
		for (int i = 1; i < input.size(); i++) {
			int maxIndex = -1;
			int maxLength = -1;
			for (int j = 0; j < i; j++) {
				if (input.get(i) >= input.get(j)
						&& outputs.get(j).size() > maxLength) {
					maxIndex = j;
					maxLength = outputs.get(j).size();
				}
			}

			if (maxLength == -1) {
				output = new ArrayList<>();

			} else {
				output = new ArrayList<>(outputs.get(maxIndex));

			}
			output.add(input.get(i));
			outputs.add(output);
		}

		output = outputs.get(0);
		for (ArrayList<Integer> list : outputs) {
			if (output.size() < list.size()) {
				output = list;
			}
		}

		return output;
	}

	public static void main(String[] args) {
		ArrayList<Integer> inputs = new ArrayList<>();
		inputs.add(3);
		inputs.add(2);
		inputs.add(6);
		inputs.add(4);
		inputs.add(5);
		inputs.add(1);
		System.out.println(findLongestNondecreasingSequence(inputs));
	}
}
