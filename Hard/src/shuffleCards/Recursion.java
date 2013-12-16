package shuffleCards;
// 洗牌最基本的思想是在洗当前一张牌，前面的牌用同样的方法洗。
// 这样很自然用到了递归的思想。
// base case 是没有牌洗。
// 到底和哪一张牌进行交换是用rand 来进行，
// random 是很基本的 block 输入进 lower 和 higher
// lower+ random * 长度。
public class Recursion {
	int rand(int lower, int higher) {
		return lower + (int) (Math.random() * (higher - lower + 1));
	}

	int[] shuffleArrayRecursively(int[] cards, int i) {
		if (i == 0) {
			return cards;
		}

		shuffleArrayRecursively(cards, i - 1);
		int k = rand(0, i);

		int temp = cards[k];
		cards[k] = cards[i];
		cards[i] = temp;

		return cards;
	}
}
