package climbingStairs;
//VI
//小女孩走楼梯问题还是要用DP的方法，要将每次走的记录下来，以后可以用。不然做了很多重复的工作。

import java.util.HashMap;
//做的时候莫名忘记了将ways 传进去。
public class StoreEachResult {
	public int climbStairs(int n) {
        HashMap<Integer, Integer> ways = new HashMap<Integer, Integer>();
        ways.put(0, 0);
        ways.put(1, 1);
        ways.put(2, 2);
        return helper(n, ways);
    }
    
    public int helper(int n, HashMap<Integer, Integer> ways) {
        if (ways.containsKey(n)) {
            return ways.get(n);
        } 
        
        int total = helper(n - 1, ways) + helper(n - 2, ways);
        ways.put(n, total);
        return total;
    }
}
