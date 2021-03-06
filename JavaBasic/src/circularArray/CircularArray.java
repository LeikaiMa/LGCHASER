package circularArray;
// 要实现generic 的要在class 后面要加上<T> 这个功能。
// 因为是一个array 所以里面有一个以T 为类型的array 因为是要成环的，而里面的数组实际上是不能成环的，所以要以一个head，每次移动的时候将这个head 更新。
// 然后constructor 是根据 用户提供的size 来进行生成，因为不能生成generic 类型的数组，所以直接生成Object 类型，然后将其cast 成T型的。
// 因为是要进行rotate 所以有个rotate 的函数，因为里面本质上是不会动的，所以是移动了head 这个就需要一个convert 的函数，如果index 是负数的要加上总共的长度，然后head 加要移动的长度 
// 因为有可能会超过总共的长度，所以取余。
// get 的函数，也是因为head 可能不是1，所以要先convert 一下，这样从数组里面取出来的才正确。
// set 同样也是。
// 然后是要自己实现一个iterator，这个时候就要让这个class implement一个iterable 同样是generic 也需要是T的类型
// 要自己实现一个iterator 类型是iterator<T> 返回的是自己建的一个inner class
// 叫circularArrayIterator generic 就要和主的不同，虽然传进来的是T，但是标记的是TI 同时要implement 的是iterator
// 在这里有两个内部的参量一个index 开始的时候赋值为-1 还有一个就是数组，在constructor 的时候就直接赋值为array 的items 这个数组。
// 在新建这个iterator 的时候new 里面用this 代表的是这个class 
// 在这个iterator 里面要override 三个method 一个是hasNext 就是比较_current 是不是小于 length - 1 因为开始的时候是-1
// 一个是next 这个时候先让index++ 然后从数组里面取值，这个时候因为自己已经赋值了，所以用现在自己的，返回的是TI 的类型，所以要将这个得到的强制转换为TI
// 还有一个是remove 的因为没有实现所以可以throw new UnsupportedOperationException("..")
// 之前如果超过边界了还有个java.lang.IndexOutOfBoundException
import java.util.Iterator;

public class CircularArray<T> implements Iterable<T> {
	private T[] items;
	private int head = 0;

	@SuppressWarnings("unchecked")
	public CircularArray(int size) {
		items = (T[]) new Object[size];
	}

	public void rotate(int shiftRight) {
		head = convert(shiftRight);
	}

	private int convert(int index) {
		if (index < 0) {
			index += items.length;
		}

		return (head + index) % items.length;
	}

	public T get(int i) {
		if (i < 0 || i >= items.length) {
			throw new java.lang.IndexOutOfBoundsException("...");
		}
		return items[convert(i)];
	}

	public void set(int i, T item) {
		items[convert(i)] = item;
	}

	public Iterator<T> iterator() {
		return new CircularArrayIterator<T>(this);
	}

	private class CircularArrayIterator<TI> implements Iterator<TI> {
		private int _current = -1;
		private TI[] _items;

		public CircularArrayIterator(CircularArray<TI> array) {
			_items = array.items;
		}

		public boolean hasNext() {
			return _current < items.length - 1;
		}

		public TI next() {
			_current++;
			TI item = (TI) _items[convert(_current)];
			return item;
		}

		public void remove() {
			throw new UnsupportedOperationException("...");
		}
	}
}
