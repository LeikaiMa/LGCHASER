package philosophersDiningProblem;
// 哲学家相当于一个thread 他们包括的动作是吃饭，因为是extend 了thread 所以要完成一个void 的run的类，就是这个线程要做的事情。
// 这里定义的thread 要做的事情就是吃10次饭，
// 定义吃的动作，包括三个，拿起筷子，咀嚼，放下筷子。
// 放下筷子就是将自己占用的两个筷子解锁。
// 拿起筷子就是要拿资源，只有拿起筷子才能说明成功，完成咀嚼和放下筷子的过程。
// 拿筷子的过程就是先拿左筷子，如果左筷子都拿不起来就返回false
// 如果拿起左筷子，就尝试右筷子，拿起来就可以吃饭了，拿不起来就要连之前占有的资源一样放掉。
// 返回不行。
public class Philosopher extends Thread {
	private int bites = 10;
	private Chopstick left;
	private Chopstick right;

	public Philosopher(Chopstick left, Chopstick right) {
		this.left = left;
		this.right = right;
	}

	public void eat() {
		if (pickUp()) {
			chew();
			putDown();
		}
	}

	public boolean pickUp() {
		if (!left.pickUp()) {
			return false;
		}
		if (!right.pickUp()) {
			left.putDown();
			return false;
		}
		
		return true;
		
	}

	public void chew() {

	}

	public void putDown() {
		left.putDown();
		right.putDown();
	}

	public void run() {
		for (int i = 0; i < bites; i++) {
			eat();
		}
	}
}
