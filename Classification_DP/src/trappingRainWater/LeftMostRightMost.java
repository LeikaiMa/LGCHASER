package trappingRainWater;
// II
//集水问题，是要看左边和右边都有比自己高，自己算低点就可以集水。
//从左往右记录在自己左边最高的是多少，可以作为左边界。
//从右往左记录右边最高的是多少，可以作为右边界。
//集水的高度是左边界和右边界的小值。然后和本身做差，这样能够得到集水的多少。
//这样做的好处是左右一共两边就可以，O（n） 的复杂度，空间上也只要一个一维数组就可以了
//需要注意的是两个边界条件，可以开始的时候就用最两边做为max 这样能够避免处理边界。可以减少code 的复杂度。

// 要记住以两边为边界，这样比较好，要了解问题的本质，是找两边最高的值。
// 然后用两个数组来储存之前的最大值的结果。
public class LeftMostRightMost {
    public int trap(int[] A) {
        int total = 0;
        if (A == null || A.length <= 2) {
            return total;
        }
        
        int[] leftMost = new int[A.length];
        int[] rightMost = new int[A.length];
        
        int max = A[0];
        for (int i = 1; i < A.length - 1; i++) {
            leftMost[i] = max;
            max = Math.max(max, A[i]);
        }
        
        max = A[A.length - 1];
        for (int i = A.length - 2; i > 0; i--) {
            rightMost[i] = max;
            max = Math.max(max, A[i]);
        }
        
        for (int i = 1; i < A.length - 1; i++) {
            int min = Math.min(leftMost[i], rightMost[i]);
            if (A[i] < min) {
                total += min - A[i];
            }
        }
        
        return total;
    }
}
