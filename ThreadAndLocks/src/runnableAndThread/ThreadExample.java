package runnableAndThread;
// 也可以用extends thread 的方法来进行，里面同样的是implement 一个run 的方法
// 然后外面只要new 一个出来，之后直接start 就可以了
// extend thread class 和implement runnable interface 的区别
// 因为java 不支持多重继承，所以extend Thread 之后不能extend 其他的class 如果是implement runnable interface 还可以extend 其他 class
// 有些class 如果只是想runnable 没有必要全部继承thread 的class
public class ThreadExample extends Thread {
	int count = 0;

	public void run() {
		System.out.println("Thread starting");
		try {
			while (count < 5) {
				Thread.sleep(500);
				System.out.println("In Thread, count is " + count);
				count++;
			}
		} catch (InterruptedException exc) {
			System.out.println("Thread interrupted");
		}

		System.out.println("Thread terminating");
	}

	public static void main(String[] args) {
		ThreadExample instance = new ThreadExample();
		instance.start();

		while (instance.count != 5) {
			try {
				Thread.sleep(250);
			} catch (InterruptedException exc) {
				exc.printStackTrace();
			}
		}
	}
}
