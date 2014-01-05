package threadVSProcess;

public class TVSP {
// process 可以看成program 的一个instance 而且他的resources 都是独立分配的，比如CPU 时间和 memory。 每个process 都有独立的address space
// 不同的process 之间不能互相访问对方的变量和栈，如果一个process 想访问另一个进程的资源，inter-process communication 就要进行调用，比如pipes files sockets 还有其他的一些形式
// thread 是存在process 里面的而且share process 的资源，多个thread 在同一个process 共享一个heap space 每个thread 有自己的register 和自己的stack 但是能够写heap memory
//	thread 是一个很特殊的process 的path ，一旦一个thread 修改了process 的resources，change 能够立刻被其他的thread 看到。
}
