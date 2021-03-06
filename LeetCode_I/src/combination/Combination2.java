package combination;

public class Combination2 {
	 public static void combination1() {
         /*全组合：
          * 思路是利用二进制的特性，每次加1即可遍历所有位的不同情况，很好理解
         代码同上
             */
         String arr[] = { "a", "b", "c"};
         int all = arr.length;
         int nbit = 1 << all;
         for (int i = 0; i < nbit; i++) {
             StringBuffer sb = new StringBuffer();
             for (int j = 0; j < all; j++) {
                 if ((i & (1 << j)) != 0) {
                     sb.append(arr[j]);
                 }
             }
             System.out.println(sb);
         }
	 }
}
