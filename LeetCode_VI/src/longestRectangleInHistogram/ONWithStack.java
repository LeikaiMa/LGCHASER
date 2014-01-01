package longestRectangleInHistogram;

import java.util.Stack;
// 求直方图里面最大的面积，本质上是一个stack 的递增维护。
// 主要是将每个每个地方的长度比较之后往stack 里面塞。这里用的是两个stack 一个是记录height 还有一个是记录相对应的index
// 有两个的原因是如果是相同的就不塞进stack 这样需要一个index 来记录所在的位置。而不能只记录一个index 来根据这个index 来找所对应的高度。
// 这里用的策略是如果是比stack 最顶层的要大，那么塞进去，如果相同就进行过滤。如果是小的情况，就要统计前面已经走过的，一个一个pop 出来
// 因为以前是递增的，肯定到目前为止，所有的大小都是刚刚pop出来为往右边最矮的，这个是可能的潜在的最大的面积，与之前暂存的最大面积进行比较，如果是大了，就进行更新。
// 有个最后pop 出来的index 的记录工具，到了最后将最后一个比他大或者相等的值记录下来，然后在这个值算完之后，将这个值维护到现在这个值，也就是把其他的头给削掉。
// 这个有一点好处就是不需要考虑为空的情况，因为第一个一直在被维护。
// 不过要注意的是，最开始的时候要先放一个初始的进去。这样有值进行维护
// 最后全部比较出来就是将所有的现存的都pop出来计算这里面的最大的。
// 本来是可以在最后的height 里面塞一个0 这样就不需要将最后拉出来进行单独处理。
public class ONWithStack {
	public static  int largestRectangleArea(int[] height) {
		if (height == null || height.length == 0) {
			return 0;
		}
		
		Stack<Integer> heights = new Stack<Integer>();
		Stack<Integer> indexes = new Stack<Integer>();
		
		heights.push(height[0]);
		indexes.push(0);
		int max = 0;
		for (int i = 1; i < height.length; i ++ ) {
			if (height[i] > heights.peek()) {
				heights.push(height[i]);
				indexes.push(i);
			} else if (height[i] < heights.peek()) {
				int lastIndex = i;
				while (!heights.isEmpty() && heights.peek() >= height[i]) {
					lastIndex = indexes.peek();
					max = Math.max(heights.pop() * (i - indexes.pop()), max);
				}
				heights.push(height[i]);
				indexes.push(lastIndex);
			}
		}
		
		while (!heights.isEmpty()) {
			max = Math.max(heights.pop() *(height.length - indexes.pop()), max);
		}
		
		return max;
	}
	
	public static void main(String[] args) {
		int[] height = {2,1,5,6,2,3};
		System.out.println(largestRectangleArea(height));
	}
}
