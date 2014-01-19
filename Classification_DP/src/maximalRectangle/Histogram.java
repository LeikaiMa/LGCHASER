package maximalRectangle;
//VIII
//这题还是比较难的，尤其是刚拿到手的时候，这时候就要会将以前的积累的用起来，
//同样是求最大的面积，可以将之前的最大面积的直方图用起来。
//现在难度是如何将这个转换为直方图，可以从第一行开始，一行一行的进行扫描，如果是1，就说明是高度为1的方柱，然后看他上面有没有方柱，如果有就加上上面的高度，就变成更高的直方柱
//合并的后就只要加上去就可以了。因为没有的话就是0，加上去也没有影响。
//然后可以得到每一行的直方柱图。
//然后遍历每一行求出每一行的最大的面积，和外面保存的最大值进行比较更新。
//现在剩下的问题就是求每一行的直方图最大面积。
//用一个stack作为值保存的地方，从前往后如果里面是空的或者是比最高的要大或者等于就塞进去。
//如果小就将里面pop 出来，这个pop 出来的当做最大的值这个值就是要计算的矩形的高度，长度就是现在这个index 到比较的index 的距离。（这个要注意，不是用比较的那个做宽）
//因为已经pop出来就不知道是那个index 就从stack peek 一下，刚刚pop 出来就是后面一个。如果里面已经全部pop 出来了。长就是现在比较的index
//因为要重新比较，所以要--，为和上面的++ 进行抵消。
//最后将最大的值输出，作为这一行最大的面积。出来和每一行进行比较。
import java.util.Stack;

public class Histogram {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        
        int max = 0; 
        int row = matrix.length;
        int column = matrix[0].length;
        
        int[][] heights = new int[row][column + 1];
        
        for (int j = 0; j < column; j++) {
            if (matrix[0][j] == '1') {
                heights[0][j] = 1;
            }
        }
        
        for (int i = 1; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (matrix[i][j] == '1') {
                    heights[i][j] = 1 + heights[i - 1][j];
                }
            }
        }
        
        for (int i = 0; i < row; i++) {
            max = Math.max(max, getMaxArea(heights, i));
        }
        
        return max;
    }
    
    
    public int getMaxArea(int[][] heights, int row) {
        int max = 0;
        Stack<Integer> stack = new Stack<Integer>();
        
        for (int j = 0; j < heights[0].length; j++) {
            if (stack.isEmpty() || heights[row][stack.peek()] <=  heights[row][j]) {
                stack.push(j);
            } else {
                int height = heights[row][stack.pop()];
                max = Math.max(max, height *(stack.isEmpty() ? j : j - stack.peek() - 1));
                j--;
            }
        }
        
        return max;
    }
}
