package multiplyStrings;
//VII
//其实仔细思考不需要字符串数组来进行储存，可以是直接用一个最终的结果的数组来进行存储，在计算的时候记得要进行维护。
//而且可以中间就用int 来进行储存，最后全部转为字符串，省的中间一直在转换。
//同样的计算过程要加上carry 然后用一个二维数组。 因为两个相乘的结果最长就是两个长度的和。
//从一个数的最后开始，然后和另外一个数从后向前每一位进行相乘，得到的乘积加上carry 就是这一次的结果，然后和i + j 这一位进行相加，这样能够顺便把最后想加的工作一起做了
//然后余数是这一位，整除的数是carry
//最后一个数字乘完，有可能还有carry ，将i + 第二个数的长度。这样就是他前面的一位，而且也将后面的错位也考虑进去了。
//最后要输出的时候，因为前面的0 不需要，就先判断是不是0 如果是就往后移动一位，注意这里面是进行到倒数第二位就结束，因为要保留最后一个0
//然后将结果插到buffer 里面，因为之前存储的时候是反着的，所以在buffer 里面只要进行append 就可以了。
//比较巧妙，不用太多的memory 来进行处理。
public class MPlusNArrayResult {
    public String multiply(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        
        int[] result = new int[len1 + len2];
        
        for (int i = 0; i < len2; i++) {
            for (int j = 0; j < len1; j++) {
                int sum = result[i + j] + (num2.charAt(len2 - 1 - i) - '0') * (num1.charAt(len1 - 1 - j) - '0');
                result[i + j] = sum % 10;
                result[i + j + 1] = sum / 10 + result[i + j + 1];
            }
        }
        
        StringBuffer sb = new StringBuffer();
        int i = len1 + len2 - 1;
        while (i > 0 && result[i] == 0) {
            i--;
        }
        
        while (i >= 0) {
            sb.append(result[i--]);
        }
        
        return sb.toString();
    }
}
