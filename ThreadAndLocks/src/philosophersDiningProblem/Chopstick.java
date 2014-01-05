package philosophersDiningProblem;
// 哲学家吃饭问题关键是一只手拿着筷子之后，发现另一只筷子被占用，不把自己占有的资源释放掉，使得其他想用这个资源的也等着，因为这个是个循环的连所以会出现deadlock 的情况
// 筷子的本质就是一个锁，锁的形式是一个reentranlock 有把筷子拿起来和放下的过程，拿起来就是上锁，放下就是释放锁，原来的问题是上锁如果锁被占用就会一直waiting 
// 我们要修改的是就是将尝试这个锁，如果可以的话就占用，如果不行就放弃，返回的值是true 还是false
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Chopstick {
	private Lock lock;

	public Chopstick() {
		lock = new ReentrantLock();
	}

	public boolean pickUp() {
		return lock.tryLock();
	}

	public void putDown() {
		lock.unlock();
	}
}
