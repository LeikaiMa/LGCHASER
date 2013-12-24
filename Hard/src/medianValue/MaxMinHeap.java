package medianValue;

import java.util.PriorityQueue;
// 找一个随机数的中位数
// 可以建两个heap 一个是maxHeap 一个是minHeap 这样两个顶部肯定就是这个排好序的最中间的两个。
// 假设max存的比min 的要多或者相等，那么如果要多，那么表示是一个奇数个数的数组，这样肯定就是多出的那一个是中位数。
// 如果是相同的，表示应该是两个的平均数。如果max 没有值说明就没有任何存进来， 就直接返回0
// 存的时候先判断是否相等，如果相等 在这个基础上如果min 有值，而且比最上面的值还要大说明肯定是大的一边，要满足max 的个数要比min的要大。
// 所以是先将min的最上面的值取出来存到max 里面，然后将现在这个值存到min 里面
// 否则就直接存到max 里面。这样也能保证max 要比min 多一个
// 如果max 的要比min 的个数要多。如果要存的值比max 的最上面的 值还要小，就说明这个数应该是小的一半，就应该把max 最上面的那个值先存到min 里面
// 然后将数存到max 里面
// 否则就直接存到min 里面，让两个heap 都相等。
public class MaxMinHeap {
//	private Comparator<Integer> maxHeapComparator;
//	private Comparator<Integer> minHeapComparator;
	private PriorityQueue<Integer> maxHeap, minHeap;

	public void addNewNumber(int randomNumber) {
		if (maxHeap.size() >= minHeap.size()) {
			if ((minHeap.peek() != null) && randomNumber > minHeap.peek()) {
				maxHeap.offer(minHeap.poll());
				minHeap.offer(randomNumber);
			} else {
				maxHeap.offer(randomNumber);
			}
		} else {
			if (randomNumber < maxHeap.peek()) {
				minHeap.offer(maxHeap.poll());
				maxHeap.offer(randomNumber);
			} else {
				minHeap.offer(randomNumber);
			}
		}
	}

	public double getMedian() {
		if (maxHeap.isEmpty()) {
			return 0;
		}

		if (maxHeap.size() == minHeap.size()) {
			return ((double) minHeap.peek() + (double) maxHeap.peek()) / 2;
		} else {
			return maxHeap.peek();
		}

	}
}
