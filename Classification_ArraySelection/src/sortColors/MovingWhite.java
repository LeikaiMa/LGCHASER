package sortColors;
//VI
//因为是要one pass 所以直接遍历一遍进行判断。类似于quick sort 有一个pivot
//有三个坐标表示红白蓝，开始的时候红色和白色都在0 蓝色的是在最后。
//白色的开始扫描，如果是红色的假如红色和白色的不在一个地方，说明红色的坐标现在在白色，这样交换，然后都加1，如果两个坐标相同，说明两个都是红色，都在同一个位置。就不需要交换，直接两个加1
//如果是白色那么白色+1
//如果蓝色的话，那么先交换，把蓝色换到最后，然后蓝色-1，因为现在这个是未知的，所以白色的坐标不动，等下次check，
//直到白色超过蓝色，这里面如果有蓝色会多移动一次，如果没有那么就是正常的，保证么有蓝色的时候，最后一个是红色还能正常使用。

//这里是先将最开始的红色给过滤掉。这样就没有不必要的自身的交换了。
public class MovingWhite {
    public void sortColors(int[] A) {
        if (A == null || A.length == 0) {
            return;
        }
        
        int red = 0;
        int white = 0;
        int blue = A.length - 1;
        
        while (white < A.length && A[white] == 0) {
            white++;
            red++;
        }
        
        while (white <= blue) {
            if (A[white] ==  0) {
                swap(A, red, white);
                red++;
                white++;
            } else if (A[white] == 1) {
                white++;
            } else {
                swap(A, white, blue);
                blue--;
            }
        }
     }
     
     
     private void swap(int[] A, int a, int b) {
         int tmp = A[a];
         A[a] = A[b];
         A[b] = tmp;
     }
}
