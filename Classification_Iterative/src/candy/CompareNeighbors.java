package candy;
//VI
//这个用了三遍遍历的方法，先是每个小朋友一个糖
//然后从左边第二个开始，往右走，看左边的小朋友是不是等级比自己低，如果比自己低，应该就要比左边的小朋友多拿一个糖
//然后从右边第二个开始，往左走，看右边的小朋友是不是等级比自己低，如果比自己低，应该就要比右边的小朋友多拿一个糖。
//这个其实就是按照题目出来的推断。
//首先每个小朋友至少有一块糖， 
//然后如果等级比两边高，那么就要比比他低的多拿糖，从左往右遍历，应该就是保证比左边多拿一块。
//从右往左遍历就是保证比右边多拿一块。
//要注意的几点是，首先是如果是数组用iterator 遍历的时候，记住这个不是index 而是具体的值，实际上直接加就可以了
//还有往右走的时候是比较左边的，而不是比较右边，而且是比左边多一块，而不是比自己多一块
//往左走的时候是比较右边，而不是比较左边，而且是要比右边多一块，而不是比自己多一块

//自己做的时候只记得比较了rating 同时还要比较candies 是不是比旁边ratings 小的人相等或者是少，如果是的话就要加
public class CompareNeighbors {
    public int candy(int[] ratings) {
        int total = 0;
        if (ratings == null || ratings.length == 0) {
            return total;
        }
        
        int len = ratings.length;
        
        int[] candies = new int[len];
        
        for (int i = 0; i < len; i++) {
            candies[i] = 1;
        }
        
        for (int i = 1; i < len; i++) {
            if (ratings[i] > ratings[i - 1] && candies[i] <= candies[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }
        
        for (int i = len - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1] && candies[i] <= candies[i + 1]) {
                candies[i] = candies[i + 1] + 1;
            } 
        }
        
        for (int i : candies) {
            total += i;
        }
        
        return total;
    }
}
