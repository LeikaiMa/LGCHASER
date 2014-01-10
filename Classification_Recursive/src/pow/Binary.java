package pow;
//III
//pow 看起来简单但是实际上要要加快计算速度需要考虑很多方面。
//首先是要考虑到底数和指数的符号。先将两个都变为正数，这样处理会比较好。
//如果底数是负数，需要看指数是不是偶数，如果是偶数，结果也就正数，如果是奇数，结果是负数。
//如果指数是负数，需要在最后的时候取倒数。
//开始的时候判断指数是不是 0 如果是0 可以直接返回1
//底数也可以判断是否是 0 1 -1，但本题没有考虑到
//接下来是如果指数比较大的情况，需要加快速度。指数的乘法是可以换算成底数的幂指数。
//可以让底数自己乘以自己，这样每次幂指数可以以2的系数减少。
//但是除以2太多之后余数可能会很大，这个时候不用for循环依次相乘，而是可以再用本身进行递归。再把结果相乘。速度会以指数上升


// 这种问题拿到手一般要想到用二分法来加快速度，因为二分法是logn 这样速度会很快
// 然后就是分情况进行表示
// 如果是n 为0 的时候这个时候就是base case
// 如果是不是就要分成一半一半进行计算。
// 如果是偶数，就只要将两个half 相乘就可以了
// 如果是奇数，表示少乘了一个，如果是n 是正数就是直接再乘以相同的
// 如果是负数就除以这个值。
public class Binary {
	public double pow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        
        double half = pow(x, n / 2);
        
        if (n % 2 == 0) {
            return half * half;
        } else if (n > 0) {
            return half * half * x;
        } else {
            return half * half / x;
        }
    }
}
