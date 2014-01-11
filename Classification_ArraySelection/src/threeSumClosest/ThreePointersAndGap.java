package threeSumClosest;
//III
//同样的方法，一个作为array的遍历，还有连个作为另一种遍历，两头进行夹击，过小，左边+1， 过大右边-1
//如果是相等正好直接返回。
//有个gap 最大值作为比较记录。
//每次在里面遍历的时候记住gap 然后和这个标杆进行比较。如果比这个还要小就更新标杆
import java.util.Arrays;

public class ThreePointersAndGap {
    public int threeSumClosest(int[] num, int target) {
        Arrays.sort(num);
        int min = Integer.MAX_VALUE;
        int result = Integer.MAX_VALUE;
        
        for (int i = 0; i < num.length; i++) {
            for (int j = i + 1, k = num.length - 1; j < k;) {
                int sum = num[i] + num[j] + num[k];
                
                if (sum == target) {
                    return target;
                }
                
                int gap = Math.abs(sum - target);
                
                if (gap < min) {
                    min = gap;
                    result = sum;
                }
                
                if (sum > target) {
                    k--;
                } 
                if (sum < target) {
                    j++;
                }
            }
        }
        
        return result;
    }
}
