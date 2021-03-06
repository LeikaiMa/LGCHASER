package distributedBinaryTreeSum;
//这个是从leaf 开始往上传递值，然后到了最顶层之后往下再传递值，每次都是传的sum
//有一个node 记录自己的value 然后记录sum 记录receiveCount就是记录来的次数
//每个node 新建的时候除了将自己的value 赋值进去同时也要新建一个thread 用一个noderunner 这个是implement runnable 所以是要new 一个thread 
//send 是将sum 加上传进来的值，得到的计数器++
//对于一个thread 里面run 同样开始的时候要start flag 进行阻塞
//然后先数自己的child 有几个，然后看得到getReceivedCount 每次send 都是将node 的sum 进行累计。然后将sum 传给自己parent 
//如果有parent 送完之后就要等，这个时候同样需要一样while 进行阻塞。条件是再从parent 接收到一个值。
//如果是parent node sum 就变成 sum如果自己有child 然后send 给child 最后将自己的sum print 出来
public class BottomToTopToBottom {
	public static volatile boolean startFlag = false;

	public static void main(String[] args) {
		Node a = new Node(1);
		Node b = new Node(2);
		Node c = new Node(3);
		Node d = new Node(4);
		Node e = new Node(5);
		Node f = new Node(6);
		Node g = new Node(7);
		Node h = new Node(8);
		a.left = b;
		b.parent = a;
		a.right = c;
		c.parent = a;
		b.left = d;
		d.parent = b;
		c.left = e;
		e.parent = c;
		c.right = f;
		f.parent = c;
		f.left = g;
		g.parent = f;
		f.right = h;
		h.parent = f;
		startFlag = true;
	}

	public static class Node {
		Node parent;
		Node left;
		Node right;

		int value;
		int sum = 0;
		int receiveCount = 0;

		public Node(int value) {
			this.value = value;
			NodeRunner nodeRunner = new NodeRunner(this, value);
			new Thread(nodeRunner).start();
		}

		public synchronized void send(Integer data) {
			sum += data;
			receiveCount++;
		}

		public synchronized int getReceivedCount() {
			return receiveCount;
		}

		public static class NodeRunner implements Runnable {
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

				int childCount = 0;
				if (node.left != null) {
					childCount++;
				}

				if (node.right != null) {
					childCount++;
				}

				while (node.getReceivedCount() != childCount) {

				}

				int sum = node.sum + node.value;
				node.sum = 0;

				if (node.parent != null) {
					node.parent.send(sum);
					while (node.getReceivedCount() != childCount + 1) {

					}
				} else {
					node.sum = sum;
				}

				if (node.left != null) {
					node.left.send(node.sum);
				}

				if (node.right != null) {
					node.right.send(node.sum);
				}

				System.out.println("Thread id = " + id + " sum = " + node.sum);
			}

		}
	}
}
