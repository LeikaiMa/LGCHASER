package singleNumberII;
//III
//这个是受到从两个里面挑一个的启发。 因为所有的integer 都是 32位，可以用一个32位的数组来记录每一个bit 的总的次数。
//因为除了一个之外所有的都是3个，所以取余3的话肯定就是多出来的一个，然后再将这个拼回原来的32位就得到多出来的一个数字。

//这边还是要注意优先级的问题。<< 要比+小
public class Mod3 {
	public int singleNumber(int[] A) {
        int[] bits = new int[32];
        
        for (int i = 0; i < 32; i++) {
            for (int j = 0; j < A.length; j++) {
                if (((A[j] >> i) & 1) == 1) {
                    bits[i]++;
                }
                
                bits[i] = bits[i] % 3;
            }
        }
        
        int result = 0;
        for (int i = 31; i >= 0; i--) {
            result = (result << 1) + bits[i];
        }
        
        return result;
    }
}
