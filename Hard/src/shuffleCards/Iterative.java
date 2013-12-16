package shuffleCards;
// 因为已经知道int 的array， 所以可以直接用iteration 的方法来进行，避免用递归的方法。
// 从前往后依次洗牌，取random 也是之前的数值。 不涉及到后面的数值
public class Iterative {
	int rand(int lower, int higher) {
		return lower + (int) (Math.random() * (higher - lower + 1));
	}

	public void shuffleArrayIteratively(int[] cards) {
		for (int i = 0; i < cards.length; i++) {
			int k = rand(0, i);
			int temp = cards[k];
			cards[k] = cards[i];
			cards[i] = temp;
		}
	}
}
