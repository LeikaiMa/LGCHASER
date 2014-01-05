package deadLock;

public class DeadLock {
//	如果是deadlock 就会肯定满足四种情况
//	1. 互斥，只有一个process 在某一时刻access resources
//	2. hold and wait 一个process 已经hold resources 想要其他的resources 但是没有将自己的resources relinquish
//	3. 没有优先级， 一个process 不能优先获得某个其他的process 的资源
//	4. 环形等待 circular wait 两个或者更多的process 形成一个环链，每个process 都在等其他的在链上的资源
//	解决的方法一般是破坏第四点，就是破坏环形等待
	
}
