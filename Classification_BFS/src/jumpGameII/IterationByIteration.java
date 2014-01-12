package jumpGameII;
//IV
//因为要看总共的步数，所以每次更新的时候要等在maxCover 这个范围内全部算完之后再更新，这个时候就要用一个变量进行临时存储。
//这里用的是newMaxCover 然后整体放到一个while true 中，如果是相等的情况，就说明已经不能前进了，这时候就是不能到达最后。
//其他情况只需要cover 超过最后一个就可以返回jump 的次数。

//这里犯错的原因是开始的时候如果只有1个就算到了，直接返回0，而其他的是在这个范围内先算好了，看下一次最大去哪里，如果能到就算这个step 成功如果不行就要下次在从这个开始到新的max
public class IterationByIteration {
    public int jump(int[] A) {
        if (A.length == 1) {
            return 0;
        }
        int maxCover = 0;
        int lastI = A.length - 1;
        int step = 0;
        
        for (int i = 0; i <= maxCover;) {
            int m = maxCover;
            step++;
            
            while (i <= maxCover) {
                m = Math.max(m, A[i] + i);
                if (m >= lastI) {
                    return step;
                }
                i++;
            }
            
            maxCover = m;
        }
        
        return -1;
     }
}
