package provideLockNoDeadLock;
// locknode 建立的时候是有自己的id 和lock 和最大的lock 数
// 他有三种状态一个visiting 一个是fresh还有一个visited 从这个可以到下面一个node 上去形成一个graph ，这个就是他的child 用一个arraylist 进行标示。
// 可以joinTo 也就是arraylist里面add 也可以 remove 就是arraylist 里面remove
// 看有没有cycle 在图里面就是用一个DFS的方法，首先讲所有的lock 都变成fresh 用给一个visit 的数组来进行标示。 而上面的状态可以用枚举，enumeration 来进行表示
// 然后进入另一个多一个参量的梁金星表示，因为是要多条链来进行表示，所以有一个touch node 的hashmap 来进行储存，可以用id 作为key 然后走没有走过用boolean 来表示。
// DFS的时候开始的时候标记为visiting 然后走他的child 一个一个dfs 走完之后标记为 visited
// base case 的情况是如果已经标记在visiting 就返回true 如果最后都没有返回true 就返回false
// get lock 就是如果里面有lock 就返回lock 没有lock就新建一个返回
// get id 就是发挥里面的lock id
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// remove element 是直接将这个元素出现的第一次删除。
public class LockNode {
	public enum VisitState {
		FRESH, VISITING, VISITED
	};

	private ArrayList<LockNode> children;

	private int lockId;
	private Lock lock;
	private int maxLocks;

	public LockNode(int id, int max) {
		lockId = id;
		maxLocks = max;
	}

	public void joinTo(LockNode node) {
		children.add(node);
	}

	public void remove(LockNode node) {
		children.remove(node);
	}

	public boolean hasCycle(HashMap<Integer, Boolean> touchedNodes) {
		VisitState[] visited = new VisitState[maxLocks];
		for (int i = 0; i < maxLocks; i++) {
			visited[i] = VisitState.FRESH;
		}
		return hasCycle(visited, touchedNodes);
	}

	public boolean hasCycle(VisitState[] visited,
			HashMap<Integer, Boolean> touchedNodes) {
		if (touchedNodes.containsKey(lockId)) {
			touchedNodes.put(lockId, true);
		}

		if (visited[lockId] == VisitState.VISITING) {
			return true;
		} else if (visited[lockId] == VisitState.FRESH) {
			visited[lockId] = VisitState.VISITING;
			for (LockNode n : children) {
				if (n.hasCycle(visited, touchedNodes)) {
					return true;
				}
			}

			visited[lockId] = VisitState.VISITED;
		}

		return false;
	}

	public Lock getLock() {
		if (lock == null) {
			lock = new ReentrantLock();
		}
		return lock;
	}

	public int getId() {
		return lockId;
	}
}
