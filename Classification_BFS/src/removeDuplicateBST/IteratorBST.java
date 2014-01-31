package removeDuplicateBST;

import java.util.Iterator;
//要将output 的iterator 按照 input 的iterator来输出，但是中间要去重，这里用的是BST 来check是否为重，然后返回的是boolean 的值来判断是否有重复。
//我个人感觉也可以用hashset 来进行保存，进行去重。
//如果是input 的iterator 应该就要implement 一个iterator 然后要重写其中的hasNext next 以及 remove 的函数
//hasNext 是判断里面的count 是不是为0 而next是将里面的一个值搞出来，然后count--
//如果是outputIterator要传进去一个input 的iterator 进去，开始的时候要有一个nextElement 提前保存进去。还有一个root 来建 BST用来判断是不是重复。
//进来的时候要将inputIterator 的第一个放进去，同时要判断hasNext 以及要把这个加进去，add 的时候，开始只要用value ，而在下面用root 和value 来插入
//hasNext 是看 nextElement 是不是null 这个时候就用到了Integer 在这个里面也是要用 BST 来进行看如果是null 的话就说明root 就没有。
//如果没有就要新建。如果有就要看这个val 是不是和这个相同。如果相同，就说明不行，就返回false，如果是小的，就应该到左边，如果左边是null 就新建一个，然后返回的是true
//如果是有的就递归下去，然后的是递归返回的值，同理是右边的值。
//next就是将这个nextElement作为返回值存起来。再把这个置为null。然后从inputIterator 里面去找有没有新的，如果返回的是true 就将他放进nextElement 然后跳出来。

public class IteratorBST {
	public static void main(String[] args) {
		System.out.println("Input\tOutput");
		Iterator<Integer> inputIterator = new InputIterator(30);
		Iterator<Integer> outputIterator = new OutputIterator(inputIterator);
		while (outputIterator.hasNext()) {
			System.out.println("\t<<" + outputIterator.next());
		}
	}
	
	private static class InputIterator implements Iterator<Integer> {
		int count;

		public InputIterator(int count) {
			this.count = count;
		}

		@Override
		public boolean hasNext() {
			return count != 0;
		}

		@Override
		public Integer next() {
			int input = (int) (Math.random() * 30);
			System.out.println(">>" + input);
			count--;
			return input;
		}

		@Override
		public void remove() {

		}
	}

	private static class OutputIterator implements Iterator<Integer> {
		Iterator<Integer> inputIterator;
		Integer nextElement;
		TreeNode root;

		public OutputIterator(Iterator<Integer> inputIterator) {
			this.inputIterator = inputIterator;
			if (inputIterator.hasNext()) {
				nextElement = inputIterator.next();
				if (nextElement != null) {
					add(nextElement);
				}
			}
		}

		private boolean add(int value) {
			return add(root, value);
		}

		private boolean add(TreeNode current, int value) {
			TreeNode node = new TreeNode(value);
			if (current == null) {
				root = node;
				return true;
			}

			if (current.val == value) {
				return false;
			}

			if (current.val > value) {
				if (current.left == null) {
					current.left = node;
					return true;
				} else {
					return add(current.left, value);
				}
			} else {
				if (current.right == null) {
					current.right = node;
					return true;
				} else {
					return add(current.right, value);
				}
			}
		}

		@Override
		public boolean hasNext() {
			return nextElement != null;
		}

		@Override
		public Integer next() {
			int output = nextElement;
			nextElement = null;
			while (inputIterator.hasNext()) {
				int input = inputIterator.next();
				if (add(input)) {
					nextElement = input;
					break;
				}
			}
			return output;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub

		}
	}

}
