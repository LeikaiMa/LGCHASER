package ran7;
// 由random 5 来造random 7 关键是要使得0-6 分布均匀。 
// 这里用的 5 * random 5 + random 5 来进行表示，这样使得0-6的结果都一样，如果是2 * random 5 +  random 5 结果可能有些次数多有些次数少
// 因为有些已经21-24已经超过了0-6的个数，所以不能返回，这时候就要用到while true 这种情况来一直循环到成功为止。
public class ByRan5 {
	public static int rand7() {
		while (true) {
			int num = 5 * rand5() + rand5();
			if (num < 21) {
				return num % 7;
			}
		}
	}

	private static int rand5() {
		// TODO Auto-generated method stub
		return 0;
	}
}
