package largestRectangleInHistogram;
//VI
//这里面利用的是index 可以直接去从height 里面找对应的高度。 这样就只需要一个stack 进行维护。
//这里面没有办法记录最后一个index的位置，所以就只能比他要大的或者相等的都塞进去。如果是小的，就要将前面pop 出来计算。
//这里不要将前一个进行维护，利用的是现在这个肯定是存在的那个的后面一个，所以下面的index 可以用那个来进行计算。这就是i- peek -1 的原因
//不过有可能会一直pop出来到没有的情况，这个时候就默认一直到最开始， 就直接是i
//因为要和for 循环的++ 抵消，那么要在里面加上--
//开始push的 时候如果stack 是空的，就不需要比较直接塞进去。
//最后的时候也要将里面的所有的元素都pop 出来，计算最大的面积。
//最后返回最大的面积。
//http://www.geeksforgeeks.org/largest-rectangle-under-histogram/
import java.util.Stack;
//这里犯了一个错误，就是应该是-1 自己当时写成了+1，要注意的是理解里面的含义，加上括号是 + 1 index + 1 表示刚刚pop 出的index
public class StackStoreIndex {
    public int largestRectangleArea(int[] height) {
        if (height == null) {
            return 0;
        }
        
        Stack<Integer> stack = new Stack<Integer>();
        int max = 0;
        
        int i = 0;
        
        while (i < height.length) {
            if (stack.isEmpty() || height[stack.peek()] <= height[i]) {
                stack.push(i);
                i++;
            } else {
                int index = stack.pop();
                max =  Math.max(max, height[index] * (stack.isEmpty() ? i : i - stack.peek() - 1));
            }
         }
         
         while (!stack.isEmpty()) {
             int index = stack.pop();
             max = Math.max(max, height[index] * (stack.isEmpty() ? i : i - stack.peek() - 1));
         }
         
         return max;
    }
}
