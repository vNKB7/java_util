package basic.lambda;

public class Feature {

	// 可选类型声明 - 无需声明参数的类型。编译器可以从该参数的值推断。
	// 可选圆括号参数 - 无需在括号中声明参数。对于多个参数，括号是必需的。
	// 可选大括号 - 表达式主体没有必要使用大括号，如果主体中含有一个单独的语句。
	// 可选return关键字 - 编译器会自动返回值，如果主体有一个表达式返回的值。花括号是必需的，以表明表达式返回一个值。

	public static void main(String[] args) {
		Feature ft = new Feature();

		// with type declaration
		MathOperation addition = (int a, int b) -> a + b;

		// with out type declaration
		MathOperation subtraction = (a, b) -> a - b;

		// with return statement along with curly braces
		MathOperation multiplication = (int a, int b) -> {
			return a * b;
		};
		// without return statement and without curly braces
		MathOperation division = (int a, int b) -> a / b;

		System.out.println("10 + 5 = " + ft.operate(10, 5, addition));
		System.out.println("10 - 5 = " + ft.operate(10, 5, subtraction));
		System.out.println("10 x 5 = " + ft.operate(10, 5, multiplication));
		System.out.println("10 / 5 = " + ft.operate(10, 5, division));

		// with parenthesis
		GreetingService greetService1 = message -> System.out.println("Hello "
				+ message);

		// without parenthesis
		GreetingService greetService2 = (message) -> System.out
				.println("Hello " + message);

		greetService1.sayMessage("Mahesh");
		greetService2.sayMessage("Suresh");
	}

	interface MathOperation {
		int operation(int a, int b);
	}

	interface GreetingService {
		void sayMessage(String message);
	}

	private int operate(int a, int b, MathOperation mathOperation) {
		return mathOperation.operation(a, b);
	}

}
