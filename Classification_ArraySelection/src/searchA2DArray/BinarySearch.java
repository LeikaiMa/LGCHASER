package searchA2DArray;
//VI
//这个利用的是将整个二维数组变成一维数组，然后将index 转换为所对应的 row 和column 然后进行同样的比较
public class BinarySearch {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null) {
            return false;
        }
        int row = matrix.length;
        if (row == 0)  {
            return false;
        }
        
        int column = matrix[0].length;
        int low = 0;
        int high = row * column - 1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (target == matrix[mid / column][mid % column]) {
                return true;
            } else if (target > matrix[mid / column][mid % column]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        return false;
    }
}
