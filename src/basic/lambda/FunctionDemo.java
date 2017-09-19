package basic.lambda;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionDemo {

	public void predicateTest() {
		Predicate<String> predicate = (s) -> s.length() > 0;
		boolean test = predicate.test("test");
		System.out.println("字符串长度大于0:" + test);

		test = predicate.test("");
		System.out.println("字符串长度大于0:" + test);

		test = predicate.negate().test("");
		System.out.println("字符串长度小于0:" + test);

		Predicate<Object> pre = Objects::nonNull;
		Object ob = null;
		test = pre.test(ob);
		System.out.println("对象不为空:" + test);
		ob = new Object();
		test = pre.test(ob);
		System.out.println("对象不为空:" + test);
	}

	public void functionTest() {
		Function<String, Integer> toInteger = Integer::valueOf;
		// toInteger的执行结果作为第二个backToString的输入
		Function<String, String> backToString = toInteger
				.andThen(String::valueOf);
		String result = backToString.apply("1234");
		System.out.println(result);

		Function<Integer, Integer> add = (i) -> {
			System.out.println("frist input:" + i);
			return i * 2;
		};
		Function<Integer, Integer> zero = add.andThen((i) -> {
			System.out.println("second input:" + i);
			return i * 0;
		});

		Integer res = zero.apply(8);
		System.out.println(res);
	}

	public void supplierTest() {
		Supplier<String> supplier = () -> "special type value";
		String s = supplier.get();
		System.out.println(s);
	}

	public void consumerTest() {
		Consumer<Integer> add5 = (p) -> {
			System.out.println("old value:" + p);
			p = p + 5;
			System.out.println("new value:" + p);
		};
		add5.accept(10);
	}

	public static void main(String[] args) {
		FunctionDemo fd = new FunctionDemo();
		// fd.predicateTest();
		// fd.functionTest();
		// fd.supplierTest();
		fd.consumerTest();
	}

}
