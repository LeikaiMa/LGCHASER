package locks;
// 可以用lock 来进行锁要锁的东西，在class 里面生成一个Lock 的变量
// 然后生成的时候new ReentrantLock()
// 然后需要用lock 但是时候就在前面放上lock.lock()
// 出来的时候用lock.unlock()
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockedATM {
	private Lock lock;
	private int balance = 100;

	public LockedATM() {
		lock = new ReentrantLock();
	}

	public int withdraw(int value) {
		lock.lock();
		int temp = balance;
		try {
			Thread.sleep(100);
			temp = temp - value;
			Thread.sleep(100);
			balance = temp;
		} catch (InterruptedException e) {
		}
		lock.unlock();
		return temp;
	}

	public int deposit(int value) {
		lock.lock();
		int temp = balance;
		try {
			Thread.sleep(100);
			temp = temp + value;
			Thread.sleep(300);
			balance = temp;
		} catch (InterruptedException e) {

		}
		lock.unlock();
		return temp;
	}
}
