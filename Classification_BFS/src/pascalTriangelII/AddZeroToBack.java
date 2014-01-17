package pascalTriangelII;
//VI
//就是在最后面插上一个1，然后从倒数第二开始，将自己和前面一个相加，然后将自己重置。更加快
import java.util.ArrayList;
//现在这个方法是加上0 然后从后面加，也可以是1 然后倒数第二个加，这样就可以将初始的情况包括进去了。
//这边犯的错误是没有应该是== 最后结果是数字的个数+1 所以应该是== 的情况。
public class AddZeroToBack {
	public ArrayList<Integer> getRow(int rowIndex) {
        ArrayList<Integer> level = new ArrayList<Integer>();

        level.add(1);
        
        for (int i = 1; i <= rowIndex; i++) {
            level.add(0);
            for (int j = level.size() - 1; j > 0; j--) {
                level.set(j, level.get(j) + level.get(j - 1));
            }
        }
        
        return level;
    }
}
