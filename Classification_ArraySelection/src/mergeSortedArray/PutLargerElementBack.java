package mergeSortedArray;
//VII
//这个是比较简单的题，要注意的是从后向前，如果相等优先去填充那个要插进来的值，这样可以减少原来array 的元素的移动。
//出来的条件是只要一个插完就出来，看剩下的如果是要插入的，就继续插完，否则就说明已经插完了。

//要注意的是最后的时候应该是while 而不是if
public class PutLargerElementBack {
    public void merge(int A[], int m, int B[], int n) {
        int index = m + n - 1;
        m--;
        n--;
        
        while (m >= 0 && n >= 0) {
            if (B[n] >= A[m]) {
                A[index--] = B[n--];
            } else {
                A[index--] = A[m--];
            }
        }
        
        while (n >= 0) {
            A[index--] = B[n--];
        }
    }
}
