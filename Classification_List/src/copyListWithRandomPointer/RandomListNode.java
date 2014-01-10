package copyListWithRandomPointer;

public class RandomListNode {
	int label;
	RandomListNode next, random;

	RandomListNode(int x) {
		this.label = x;
	}
	
	public String toString() {
		return "val:" + label + "random: " + random.label;
	}
}
