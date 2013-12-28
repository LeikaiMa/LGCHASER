package lruCache;
// 运用linkedhashmap 来进行LRU的cache 的操作，因为读取和存储的时候用的是hash 所以只需要O1 的时间。
// 如果get 的情况是先寻找里面有没有这个，如果没有直接返回-1 如果有就直接get value 将所在的key remove 掉，然后在最后push 进去，所有新的都是最后一个。
// set 的情况是删掉原来的，然后将新的put 进去，也是put 到最后面。如果是超过的话就将最开始的第一个删除然后加到最后一个put 进去。
// 如果是要自己建的可以参考http://blog.csdn.net/violet_program/article/details/15335673
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {
	private LinkedHashMap<Integer, Integer> map;
	private int capacity;

	public LRUCache(int capacity) {
		map = new LinkedHashMap<Integer, Integer>();
		this.capacity = capacity;
	}

	public int get(int key) {
		if (!map.containsKey(key)) {
			return -1;
		} else {
			int value = map.get(key);
			map.remove(key);
			map.put(key, value);
			return value;
		}
	}

	public void set(int key, int value) {
		if (map.containsKey(key)) {
			map.remove(key);
			map.put(key, value);
		} else if (map.size() >= capacity) {
			int k = 0;
			for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
				k = entry.getKey();
				break;
			}
			map.remove(k);
			map.put(key, value);
		} else {
			map.put(key, value);
		}
	}

	public void print() {
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			System.out.println(entry.toString());
		}
	}
}
