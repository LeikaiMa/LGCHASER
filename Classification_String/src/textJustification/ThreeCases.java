package textJustification;
//IV
//这个要比之前自己写的更加简洁，因为考虑到如果只有一个单词或者是最后一个list 这样话都是加上一个空格然后最后将整个string 补充到所指定的长度。
//开始考虑这题的时候，主要也就是分三种情况，一种是只有一个单词，一种是不是结尾但不止一个单词，还有一个是结尾。
//这里用的一个小技巧是到达第一个超过的时候将前面的全部合并起来。这样的话有一种情况就是最后一个超出了范围，虽然for loop 里面是这个范围，但是在if 里面之前先判断是否已经到了，这样可以直接短路进去。
//lastI 是从0 是利用0 肯定单个不会超过L 总共判断的长度是总共的length 和 i 这个length 加上中间的空格，因为是超前一个，直接减就是空格的个数。
//如果超过了说明之前的肯定是最大的满足的。
//计算出中间的space 的个数，是直接相减，因为是计算前一个所以是要减1，然后先插一个单词一个空格，判断如果是最后一个就不要加空格，最后加上多余的空格
//如果是多个单词的不是最后一行的情况，那么要计算正常的每个的空格数，这个时候用整除来进行，然后多余的是用求余来进行，然后从左向右来+1 来补充
//最后如果不是最后一个，需要将现在这个补到cur len里面。因为是提前一个计算。
//如果还是满足，就将现在的len 加上去。
import java.util.ArrayList;
//这里犯的错误是一个是words 写成word 然后很多地方应该是length 没有加，stringbuffer 的地方应该是append 自己写成了add，然后在如果如果只有一个单词或者是最后一个单词的时候应该后面加空格使其左对齐。
//虽然最后还是改对了，但是很多地方没有原来那个conciser 写的好，
//比如不需要count 这个计数器，i 和lastI 差就是个数。然后word是最后和只有一个也是可以合并。都是统一在后面加
//然后extra space 也可以和平常的space 合在一起。用个三元判断，看是否超过，如果没有超过，空格的个数+1 如果超过了，就不变。
public class ThreeCases {
    public ArrayList<String> fullJustify(String[] words, int L) {
        ArrayList<String> results = new ArrayList<String>();
        if (words.length == 0) {
            return results;
        }
        
        int lastI = 0;
        int count = 1;
        int len = words[0].length();
        int i = 1;
        
        while (i <= words.length) {
            if (i == words.length || (len + words[i].length() + count) > L ) {
                StringBuffer sb = new StringBuffer();
                if (i == words.length) {
                    for (int index = lastI; index < i; index++) {
                        sb.append(words[index]);
                        if (index != i - 1) {
                            sb.append(' ');
                        }
                    }
                    addSpace(sb, L - len - count + 1);
                    results.add(sb.toString());
                } else if (count == 1) {
                    sb.append(words[lastI]);
                    addSpace(sb, L - len);
                    lastI = i;
                    count = 1;
                    len = words[i].length();
                    results.add(sb.toString());
                } else {
                    int spaceLeft = L - len;
                    int nSpace = spaceLeft / (count - 1);
                    int extraSpace = spaceLeft % (count - 1);
                    for (int index = lastI; index < i; index++) {
                        sb.append(words[index]);
                        if (index != i - 1) {
                            addSpace(sb, nSpace);
                            if (index - lastI < extraSpace) {
                                sb.append(' ');
                            }
                        }
                    }
                    results.add(sb.toString());
                    lastI = i;
                    count = 1;
                    len = words[i].length();
                }
                i++;
            } else {
                count++;
                len += words[i].length();
                i++;
            }
        }
        
        return results;
        
    }
    
    
    private void addSpace(StringBuffer sb, int n) {
        for (int i = 0; i < n; i++) {
            sb.append(' ');
        }
    }
}
