package shortestDistanceOfWords;
// 最近的距离有个好处是只要遇到就可以直接处理，而不像最远的要依靠以前储存的值。
// 同样是两个对象，很自然的想到用两个指针最为index 的postiion 开始的时候直接赋值为-1， min 最开始的时候赋值为max
// 然后遇到两个中的一个进行更新，计算新的distance 与原来的min来进行比较。但是要考虑的是要保证已经有数据在之前记录下来了。
// 换句话将就是pos 不是原始的数据-1
// 得到的distance也是新到的减去以前已经保存的，这样就不需要加上绝对值来进行处理。
// 最后比较完了之后返回min 
// 如果必须是ordered 的话就是需要将一种顺序的进行注释。 
// 仅仅记录他最新的position

// 如果是要经常的做这样的操作，我们就需要把这些值的出现的index 存起来。可以用一个hashtable 然后value 是一个list， list 里面是所有的index。
// 然后要比较两个只需要将两个list merge 起来。可以新建一个wrapper class 然后sort 整个merge list class 里面还有一个参量是他原先的list 到底是什么
// 然后遍历整个list 找出最近的两个不同的距离。就得到结果
// 关键点在于先把每一个存在一个list 里面这样以后随便取哪个数据都不需要再遍历原始的数据，只需要从hashtable 里面进行读出就可以了
public class Shortest {
	
	public int shortest(String[] words, String word1, String word2) {
		int min = Integer.MAX_VALUE;
		int lastPosWord1 = -1;
		int lastPosWord2 = -1;
		for (int i = 0; i < words.length; i++) {
			String currentWord = words[i];
			if (currentWord.equals(word1)) {
				lastPosWord1 = i;
				int distance = lastPosWord1 - lastPosWord2;
				if (lastPosWord2 >= 0 && min > distance) {
					min = distance;
				}
			} else if (currentWord.equals(lastPosWord2)) {
				lastPosWord2 = i;
				int distance = lastPosWord2 - lastPosWord1;
				if (lastPosWord1 >= 0 && min > distance) {
					min = distance;
				}
			}
		}
		
		return min;
	}
}
