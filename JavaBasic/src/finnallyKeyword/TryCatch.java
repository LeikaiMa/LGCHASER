package finnallyKeyword;
// try 和 catch 的用法是先执行一部分代码，然后遇到了不合格的地方就跑到catch 里面，然后catch 执行代码，
// 执行完了先执行finally 的代码，然后再返回值。
// finalize 是在destroy 这个object 的时候进行调用，
// protected void finalize() throws Throwable{ close open files, resources, etc}
public class TryCatch {
	public static String lem() {
		System.out.println("lem");
		return "return from lem";
	}

	public static String foo() {
		int x = 0;
		int y = 5;
		try {
			System.out.println("start try");
			int b = y / x;
			System.out.println("end try");
			System.out.println(b);
			return "return from try";
		} catch (Exception ex) {
			System.out.println("catch");
			return lem() + " | returned from catch";
		} finally {
			System.out.println("finally");
		}
	}

	public static void bar() {
		System.out.println("start bar");
		String v = foo();
		System.out.println(v);
		System.out.println("end bar");
	}

	public static void main(String[] args) {
		bar();
	}
}
