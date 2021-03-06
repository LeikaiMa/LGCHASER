package overLoadingVSoverRiding;
// overload 是有相同的名字但是不同的type 以及不同的argument
// override 是相同的名字和相同的功能但是不同的用法。比如在这里的printMe
public class IntroductionOverriding {
	public static void main(String[] args) {
		Shape[] shapes = new Shape[2];
		Circle circle = new Circle();
		Ambiguous ambiguous = new Ambiguous();
		
		shapes[0] = circle;
		shapes[1] = ambiguous;
		
		for(Shape s: shapes) {
			s.printMe();
			System.out.println(s.computeArea());
		}
	}
}
