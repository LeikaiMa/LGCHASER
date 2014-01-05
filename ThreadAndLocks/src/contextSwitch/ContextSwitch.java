package contextSwitch;

public class ContextSwitch {
//	context switch指的是在两个process 之间进行切换的花费的时间。 从哇听的process 带到 execution 然后让executing 的process 到waiting
//	需要记录last 和 first instruction 的timestamp ，然后他们的差就是结果。
//	要解决的两个问题是，一个我们不知道什么时候swapping开始，还有一个就是可能会有interrupt 
//	为了解决了这个问题，要建立一个task scheduler 来处理这个问题，当p1 执行完了p2 会被执行，所以要有个data channel 来进行执行，例如 一个pipe line
//	1. p2 block 住开始等待p1的data
//	2. p1 marks start time
//	3. p1 发送 token 给p2
//	4. p1 试图读 p2 的回应，这个时候就是context switch
//	5. p2 被scheduled 接受这个token
//	6. p2 发送一个response token 给p1
//	7. p2 打算读p1 的回应，这个也是context switch
//	8. p1 被安排了，接受token
//	9. p1 记录end time
//	T = 2 *（Td + Tc + Tr）
//	END TIME - START TIME 就是T p1 p2 都有发送和接受时间，在发送和接受时间之间就有context switch time 也就是发送之后那边接受的时间。
//	很容易计算T 但是要减去Td Tr 这个是后可以自己发给自己，这样中间没有context switch
//	这个可执行很多次，因为里面有很多种意想不到的kernel interrput 和 kernel threads 我们要选足校的。
// 	以上能基本解决问题，但是因为要给予underlying 的system 不能保证p2 已接受到data token 就被选中。
}
