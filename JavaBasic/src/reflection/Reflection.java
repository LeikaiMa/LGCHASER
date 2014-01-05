package reflection;

import java.awt.Rectangle;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

// reflection 能够得到java class 和object 的information
// 能够了解到class 在运行的时候method 的field 代表的是什么
// 能够生成一个class 的新的 instance
// 能够直接得到和存放 Object 的field reference 不管access 的modifier 是什么、

// reflection 的几点好处，
// 一个是能够观察和操控application 的runtime 的behavior 
// 第二个是可能够帮助debugging 和testing 程序，因为我们可以直接取得methods constructor 还有field 的东西
// 第三个我们能够在不知道method 的情况下通过名字来进行调用。 让用户给我们一个class name， constructor 的parameter 还有method 的name
//  这样就可以生成一个object 调用method
public class Reflection {
	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Object[] doubleArgs = new Object[] { 4.2, 3.9 };
		@SuppressWarnings("rawtypes")
		Class rectangleDefinition = Class.forName("MyProj.Rectangle");

		@SuppressWarnings("rawtypes")
		Class[] doubleArgsClass = new Class[] { double.class, double.class };
		@SuppressWarnings({ "unchecked", "rawtypes" })
		Constructor doubleArgsConstructor = rectangleDefinition.getConstructor(doubleArgsClass);
		
		Rectangle rectangle = (Rectangle) doubleArgsConstructor.newInstance(doubleArgs);
		
		@SuppressWarnings("unchecked")
		Method m = rectangleDefinition.getDeclaredMethod("area");
		@SuppressWarnings("unused")
		Double area = (Double) m.invoke(rectangle);
	}
}
