package distributedDoublyLinkedSum;
//每个node 是一个 double linked list 有next 和prev 里面有自己的值value 和 收到的值data
//每次新建的时候都会新开一个thread，以及自己的值。
//还有一个synchronized 的method 就是别人发给自己的值
//每个thread 新建的时候会有两个参量，一个这个node，还有是这个value 当做自己的id
//因为要所有的node 都建好才能互相通信，所以有个全局的volatile 的变量start flag
//开始有个while 循环，只要这个flag 不成功一直block 住，然后打通之后，就开始通信，除了最右边的一开始就通信，其他的要有个while 循环阻塞住。block 的时候用try 加上sleep 10 millisecond
//这就是data 这个接受值的作用。如果被send 之后这个data就不是null 这个也就是为什么用integer 的原因，而不用int 
//接收到这个值之后，就要将接收到的值和自己本身 的值相加，如果前面有prev就传过去。然后自己变成null 等待返回值。
//这个时候同样因为变成了null 用一个while 循环来block 住，因为最左边 没有清为null 所以不会有这个block
//然后如果接收到返回值就打印出来，如果有next 就再传给下一个值。
//比较新的题型，所以要多注意
public class TwoIterations {
	public static volatile boolean startFlag = false;

	public static void main(String[] args) {
		Node a = new Node(1);
		Node b = new Node(2);
		Node c = new Node(3);
		Node d = new Node(4);
		Node e = new Node(5);
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		e.prev = d;
		d.prev = c;
		c.prev = b;
		b.prev = a;
		startFlag = true;
	}

	private static class Node {
		Node next;
		Node prev;

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

			if (node.next == null) {
				node.prev.send(node.value);
			} else {
				while (node.data == null) {
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {

					}
				}

				int sum = node.data + node.value;
				if (node.prev != null) {
					node.data = null;
					node.prev.send(sum);
				}
			}

			while (node.data == null) {
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {

				}
			}

			if (node.prev == null) {
				node.data = node.data + node.value;
			}

			System.out.println("id: " + id + " sum: " + node.data);
			if (node.next != null) {
				node.next.send(node.data);
			}
		}
	}
}
