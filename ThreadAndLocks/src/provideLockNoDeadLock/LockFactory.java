package provideLockNoDeadLock;
// 在lock factory 里卖你有对应lock 有相对应的不同链子和链子上的order 的hashmap
// 在这里constructor 是private 的，如果要得到这个instance 有个static 的mehtod 这个里面返回的是instance
// 检查是否有cycle 传进来的是一个链子，但是这个链子是用array 来编辑哦是，遍历这个链子， 看看这个链子上有没有cycle 调用之前node 里面的cycle 的函数，如果有就直接返回true 
// 这里面hashmap 就有作用了，因为这个list可能会有重复的值，或者在之前的node的里面通过child 已经跑过了，如果是true 就没有必要再跑一遍
// 每个人进来要宣布一下自己要取资源的顺序，首先是建一个hashmap 里面将所有的node 全部塞进去，因为这个链子还没没有将自己和他的下一个node 绑定起来，所以要边存边绑，
// 因为是链子装所以同时要两个一起出现，那么先将头单独的存起来，然后从1开始到最后每个都和前面一个绑起来。
// 然后有了要处理的node 和整个顺序的链子，那么就可以判断这个里面有没有cycle 如果有的话就要将之前存的前后关系都要给先删掉。这个时候也是从1 开始，让之前的吧自己给删了，当然从0 开始把child 也删了也可以。
// 然后返回是错误的就不要进行下面的处理
// 如果没有cycle 就说明这个是对的，那么就应该将这个放进list 里面，新建一个list 然后将这个list 里面的lock node 存进去
// 最后将这个list 放进一个大的lockOrder 的hashmap 里面去，标记好owenerID
// 最后返回成功。
// 要得到里面的锁，就应该是将里面的owneId取出来，如果是空的就返回null
// 然后看里面的head 是不是想要的resource 如果是的话就先将里面的 这个node取出来，删掉这个node 然后将这个lock 取出来。
import java.util.HashMap;
import java.util.LinkedList;
import java.util.concurrent.locks.Lock;

public class LockFactory {
	private static LockFactory instance;

	// private int numberOfLocks = 5;

	private LockNode[] locks;

	private HashMap<Integer, LinkedList<LockNode>> lockOrder;

	private LockFactory(int count) {

	}

	public static LockFactory getInstance() {
		return instance;
	}

	public static synchronized LockFactory initialize(int count) {
		if (instance == null) {
			instance = new LockFactory(count);
		}

		return instance;
	}

	public boolean hasCycle(HashMap<Integer, Boolean> touchedNodes,
			int[] resourcesInOrder) {
		for (int resource : resourcesInOrder) {
			if (touchedNodes.get(resource) == false) {
				LockNode n = locks[resource];
				if (n.hasCycle(touchedNodes)) {
					return true;
				}
			}
		}

		return false;
	}

	public boolean declare(int ownerId, int[] resourcesInOrder) {
		HashMap<Integer, Boolean> touchedNodes = new HashMap<>();

		int index = 1;
		touchedNodes.put(resourcesInOrder[0], false);

		for (index = 1; index < resourcesInOrder.length; index++) {
			LockNode prev = locks[resourcesInOrder[index - 1]];
			LockNode curr = locks[resourcesInOrder[index]];
			prev.joinTo(curr);
			touchedNodes.put(resourcesInOrder[index], false);
		}

		if (hasCycle(touchedNodes, resourcesInOrder)) {
			for (int j = 1; j < resourcesInOrder.length; j++) {
				LockNode p = locks[resourcesInOrder[j - 1]];
				LockNode c = locks[resourcesInOrder[j]];
				p.remove(c);
			}

			return false;
		}

		LinkedList<LockNode> list = new LinkedList<>();
		for (int i = 0; i < resourcesInOrder.length; i++) {
			LockNode resource = locks[resourcesInOrder[i]];
			list.add(resource);
		}
		lockOrder.put(ownerId, list);

		return true;
	}

	public Lock getLock(int ownerId, int resourceID) {
		LinkedList<LockNode> list = lockOrder.get(ownerId);
		if (list == null) {
			return null;
		}
		LockNode head = list.getFirst();
		if (head.getId() == resourceID) {
			list.removeFirst();
			return head.getLock();
		}
		
		return null;
	}
}
