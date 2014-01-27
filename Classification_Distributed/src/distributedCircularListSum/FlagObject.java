package distributedCircularListSum;
//这个因为没有两边的头，所以要通过确定一个object 作为头，这个时候要用一个全局变量然后开始的时候用synchronized 把这个锁起来，
//先得到的先在这个thread，就将他变成first 是first 就往后面传值，如果不是，就用一个while 循环来将他block 起来
//等到过了block 将输入的值和自己加起来然后将自己清空，然后将sum 传给后面一个值。然后一直传，传到最后传回来，变成了sum 将其print 出来
//然后将这个再传给后面一个，那么这个thread 也就结束了
public class FlagObject {
	public static volatile boolean startFlag = false;
	private static Boolean flag = false;

	public static class Node {
		Node next;
		int value;
		Integer data;

		public Node(int value) {
			this.value = value;
			new Thread(new NodeRunner(this, value)).start();
		}

		public synchronized void send(int data) {
			this.data = data;
		}
	}

	private static class NodeRunner implements Runnable {
		Node node;
		int id;

		public NodeRunner(Node node, int id) {
			this.node = node;
			this.id = id;
		}

		@Override
		public void run() {
			while (!startFlag) {

			}

			boolean isFirst = false;

			synchronized (flag) {
				if (flag == false) {
					flag = true;
					isFirst = true;
				}
			}

			if (isFirst) {
				node.next.send(node.value);
			} else {
				while (node.data == null) {
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {

					}
				}

				int sum = node.value + node.data;
				node.data = null;
				node.next.send(sum);
			}

			while (node.data == null) {
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {

				}
			}

			System.out.println("id: " + id + " sum: " + node.data);
			node.next.send(node.data);
		}

	}
}
