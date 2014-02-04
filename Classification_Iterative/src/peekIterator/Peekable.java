package peekIterator;
// 用一个getTop 的方法来看利用iterator constructor 本身就是输入的就是一个iterator 然后里面有的参量就是一个iterator 一个观察有没有peek的boolean
// 还有一个top 保存现在上面的元素，而实际上已经next 到后面去了。而haspeek 就是指的现在这个是不是最后一个。
// 如果是peek 的话可以看有没有peek 如果没有就报错。如果有的话就返回top 的值。
// 如果是pop 的话，就要将top 的值先存起来。然后再getTop 里面将新的top 给得到，然后返回原来的top
// 然后getTop 里面先假设就是没有，然后boolean 值就是false 然后看有没有next 这个值，如果有的话就就到if 里面去，将这个变成true，然后将top 赋值到新的值，也就是用next 返回值。
// 这个是implement一个iterator
import java.util.Iterator;

public class Peekable<T> implements Iterator<T>{
	private Iterator<T> iterator;
	private boolean hasPeek;
	private T top;

	public Peekable(Iterator<T> iterator) {
		this.iterator = iterator;
		getTop();
	}
	
	private void getTop() {
		hasPeek = false;
		if (iterator.hasNext()) {
			hasPeek = true;
			top = iterator.next();
		}
	}

	@Override
	public boolean hasNext() {
		return hasPeek;
	}

	@Override
	public T next() {
		if (!hasPeek) {
			try {
				throw new Exception();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

		T currentTop = top;
		getTop();
		return currentTop;
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub

	}

}
