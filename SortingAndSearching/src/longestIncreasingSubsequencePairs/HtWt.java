package longestIncreasingSubsequencePairs;

public class HtWt implements Comparable<HtWt> {
	Integer Ht;
	Integer Wt;

	public int compareTo(HtWt s) {
		HtWt second = s;
		if (this.Ht != second.Ht) {
			return this.Ht.compareTo(second.Ht);
		} else {
			return this.Wt.compareTo(second.Wt);
		}
	}

	public boolean isBefore(HtWt other) {
		if (this.Ht.intValue() < other.Ht.intValue()
				&& this.Wt.intValue() < other.Wt.intValue()) {
			return true;
		} else {
			return false;
		}
	}
}
