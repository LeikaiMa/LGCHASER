package twoSum;
//III
//求两个数的和等于指定的值。可以边遍历边看是否有对应的值已经存了。
//这个时候用hashmap 来进行存储，可以使取值的复杂度降低。如果没有存过，可以将自己的补数和index 存进hashmap 中
//这样能够只进行一遍遍历就能得到答案。
import java.util.HashMap;
//这边要注意的是一个是返回的不是真正的index 而要+1 以后的值
//hashmap 是containsKey，contains 是指的entry
public class HashMapStoreComplement {
	public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(numbers[i])) {
                result[0] = map.get(numbers[i]) + 1;
                result[1] = i + 1;
                break;
            } else {
                map.put(target - numbers[i], i);
            }
        }
        
        return result;
    }
}
