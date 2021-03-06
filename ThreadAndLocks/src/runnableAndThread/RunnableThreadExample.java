package runnableAndThread;
// 一种是implement runnable 的class 里面 用run 来表示干什么事儿
// 然后在外面生成这个class 的instance 然后新建一个thread 里面传进去的参数就是这个runnable 的class
// 然后用这个thread 进行start 
public class RunnableThreadExample implements Runnable {
	public int count = 0;

	public void run() {
		System.out.println("RunnableThread starting.");
		try {
			while (count < 5) {
				Thread.sleep(500);
				System.out.println("In Thread, count is " + count);
				count++;
			}
		} catch (InterruptedException exc) {
			System.out.println("RunnableThread interrupted.");
		}
		System.out.println("RunnableThread terminating.");
	}

	public static void main(String[] args) {
		RunnableThreadExample instance = new RunnableThreadExample();
		Thread thread = new Thread(instance);
		thread.start();

		while (instance.count != 5) {
			try {
				Thread.sleep(250);
			} catch (InterruptedException exc) {
				exc.printStackTrace();
			}
		}
	}

}
