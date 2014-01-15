package removeDuplicatesFromSortedArrayII;
//V
//如果是要可以有固定个数的重复，相比较前面的两指针运算，就是要多加一个计数器，看看是不是超过这个数，如果超过这个数就只有fast 向前走，当做过滤。
//如果没有超过，一种是相同的情况，这样计数器+1 size+1， slow 这个指针也往前走，但是不要忘了将fast 里面的值复制过来。 这个开始做的时候忘记了。
//如果不同的情况count 要置1，同时slow往前移动一位，将fast 的复制过来，size 同样要进行扩大。
//这种题目主要是细心的程度。

//这里省略了size 因为slow 就是最长的位置。+1 就是长度。
public class CountFrequency {
	public int removeDuplicates(int[] A) {
        if (A == null) {
            return 0;
        }
        
        if (A.length <= 2) {
            return A.length;
        }
        
        int slow = 0;
        int fast = 1;
        int count = 1;
        while (fast < A.length) {
            if (A[fast] == A[slow] && count < 2) {
                A[++slow] = A[fast];
                count++;
            } else if (A[fast] != A[slow]) {
                A[++slow] = A[fast];
                count = 1;
            }
            fast++;
        }
        
        return slow + 1;
    }
}
