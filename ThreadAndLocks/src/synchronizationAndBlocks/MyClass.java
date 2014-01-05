package synchronizationAndBlocks;
//如果是两个线程同时调用一个函数，而这个函数在一个instance 里面，那么如果synchronized 情况，就要等待，直到这个进行完了，另一个才能继续执行。
//童谣的可以将某段代码给synchronized
//用synchronized(this) {}
public class MyClass extends Thread {
	private String name;
	private MyObject myObj;

	public MyClass(MyObject obj, String n) {
		name = n;
		myObj = obj;
	}

	public void run() {
		// myObj.foo(name);
		if (name.equals("1")) {
			myObj.foo(name);
		} else if (name.equals("2")) {
			myObj.bar(name);
		}
	}

	public static void main(String[] args) {
		// MyObject obj1 = new MyObject();
		// MyObject obj2 = new MyObject();
		//
		// MyClass thread1 = new MyClass(obj1, "1");
		// MyClass thread2 = new MyClass(obj2, "2");
		//
		// thread1.start();
		// thread2.start();

		MyObject obj = new MyObject();
		MyClass thread1 = new MyClass(obj, "1");
		MyClass thread2 = new MyClass(obj, "2");
		thread1.start();
		thread2.start();
	}
}
