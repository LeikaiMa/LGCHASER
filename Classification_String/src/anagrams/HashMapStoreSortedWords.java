package anagrams;
//VII
//通过思考，了解到string是可以自己sort 的，先将string 拆成char array 然后用 char array 进行sort 得到了一个sort 好的array
//然后将这些array 放进一个hashmap
//这里用到了anagram 的本质，所有的单词的总数都相同，而且每个单词的字母组成也相同。这样排完序之后就是相同的string
//放到hashmap 那么相同的anagram 就是相同的key， 后面存的时候放到arraylist 里面用他的index 而不是 具体的string 可以省空间。
//然后将hashmap size里面超过1的value 都取出来，这里用到了values() 这个collection比较实用，还有对应的有keySet() entrySet() 这些在以后的写的时候都可以写
//尤其是没有提示的时候，要知道会用这个。
//最重要的是了解这个的本质，然后通过这个本质来找相应的工具。 这样能够更好的完成任务。
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
//这个要注意的是所有的都要写进去，所以应该就不是>1 就返回而是应该是>1 都加进最后结果里面。
public class HashMapStoreSortedWords {
	public ArrayList<String> anagrams(String[] strs) {
        ArrayList<String> results = new ArrayList<String>();
        if (strs == null || strs.length == 0) {
            return results;
        }
        
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        
        for (String s : strs) {
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String word = new String(c);
            
            if (map.containsKey(word)) {
                map.get(word).add(s);
            } else {
                ArrayList<String> result = new ArrayList<String>();
                result.add(s);
                map.put(word, result);
            }
        }
        
        for (ArrayList<String> result : map.values()) {
            if (result.size() > 1) {
                results.addAll(result);
            }
        }
        
        return results;
    }
}
