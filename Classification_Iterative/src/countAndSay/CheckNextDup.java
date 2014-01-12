package countAndSay;
//IV
//因为第一个已经确定，肯定有第一个值，可以将初始值设置好，然后进去如果相同就跟新count 如果不同就将这个塞进string buffer 里面。
//然后更新这个为新的char 和count
//最后将最后一个也塞进去。
//然后更新string 

//这个比原来做的好的是用一个string buffer 来进行存储，然后比较的是和下面一个是不是相等，如果相等直接将index 往后加
//要注意的还是在length - 1 的情况 如果遇到不同的就跳出，将现在有的放到stringbuffer 里面。 然后将这个sb 替换掉s 不断循环。
public class CheckNextDup {
    public String countAndSay(int n) {
        String s = "1";
        for (int i = 1; i < n; i++) {
            StringBuffer sb = new StringBuffer();
            int index = 0;
            
            while (index < s.length()) {
                char c = s.charAt(index);
                int count = 1;
                while (index < s.length() - 1 && s.charAt(index) == s.charAt(index + 1)) {
                    count++;
                    index++;
                }
                sb.append(count);
                sb.append(c);
                index++;
            }
            
            s = sb.toString();
        }
        return s;
    }
}
