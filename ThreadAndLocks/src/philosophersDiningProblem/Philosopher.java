package philosophersDiningProblem;

public class Philosopher extends Thread {
	private int bites = 10;
	private Chopstick left;
	private Chopstick right;

	public Philosopher(Chopstick left, Chopstick right) {
		this.left = left;
		this.right = right;
	}

	public void eat() {
		pickUp();
		chew();
		putDown();
	}

	public void pickUp() {
		left.pickUp();
		right.pickUp();
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
