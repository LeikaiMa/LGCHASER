package maximumSubarray;
//VII
//这题之前虽然做过，但是考虑的还是不全面，做负功应该是对前面的sum 完全否定掉才重新置0 而不是仅仅现在这个比前面小
//首先sum 置为0，因为最小的有负数，所以max 先置为min 
//然后sum 每次都进行累计，让max 看sum 是不是超过了，如果超过了就更新。
//一旦sum 变为负值，就说明对后面没有作用，就应该变成0

//这里要注意的是开始的时候要将max 设成最小的值，然后和每次的sum 进行比较。如果sum 变成小于0 的情况，然后还原成0 之后继续进行计算。
public class CheckSumLessThanZero {
    public int maxSubArray(int[] A) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        
        for(int i : A) {
            sum += i;
            if (max < sum) {
                max = sum;
            }
            
            if (sum < 0) {
                sum = 0;
            }
        }
        
        return max;
    }
}
