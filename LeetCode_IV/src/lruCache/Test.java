package lruCache;

public class Test {
	public static void main(String[]  args) {
		LRUCache cache = new LRUCache(2);
		cache.set(2, 1);
		cache.print();
		cache.set(2, 2);	
		cache.print();
		cache.get(2);
		cache.print();
		cache.set(1, 1);
		cache.print();
		cache.set(4, 1);
		cache.print();
		System.out.println(cache.get(2));
		
	}
}
