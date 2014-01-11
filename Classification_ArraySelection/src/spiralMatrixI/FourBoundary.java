package spiralMatrixI;
//III
//按照螺旋式输出值，可以不像旋转一样，可以按照螺旋式的一层一层的遍历。
//设置4个参量，左右上下，作为边界。
//首先是底部横着，然后是右边竖着，但是要将第一个去掉。
//然后是顶部倒着横着，也要去掉第一个，最后是左边的竖着倒着，要去掉第一个和最后一个。
//但是要注意的是，首先要判断matrix 是不是存在。
//其次要判断的是如果是top 和 bottom 相等 right 和left 相等就只能输出一个。所以在第三个和第四个的循环当中就多了一个判断条件。
//while 循环的时候要记得计数器等等每次循环时候要+1 或者-1
import java.util.ArrayList;
// 这里面边界条件的判定就只是top > bottom 或者 left > right 就可以了。只要有一边超过了，就说明已经过了，就说明扫描结束，而不需要看总共的size 是不是到了想要的row * column 
public class FourBoundary {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        if (matrix == null || matrix.length == 0) {
            return result;
        }
        
        int row = matrix.length;
        int column = matrix[0].length;
        
        int top = 0; 
        int bottom = row - 1;
        int left = 0;
        int right = column - 1;
        
        while (top <= bottom && left <= right) {
            if (top <= bottom) {
                for (int j = left; j <= right; j++) {
                    result.add(matrix[top][j]);
                }
            }
            
            if (right >= left) {
                for (int i =  top + 1; i <= bottom; i++) {
                    result.add(matrix[i][right]);
                }
            }
            
            if (bottom > top) {
                for (int j = right - 1; j >= left; j--) {
                    result.add(matrix[bottom][j]);
                }
            }
            
            if (left < right) {
                for (int i = bottom - 1; i > top; i--) {
                    result.add(matrix[i][left]);
                }
            }
            
            top++;
            bottom--;
            left++;
            right--;
        }
        
        return result;
    }
}
