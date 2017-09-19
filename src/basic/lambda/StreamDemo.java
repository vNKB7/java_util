package basic.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

//Stream的使用过程有着固定的模式：
//
//创建Stream
//通过中间操作，对原始Stream进行“变化”并生成新的Stream
//使用完结操作，生成最终结果 
//也就是
//创建——>变化——>完结

public class StreamDemo {
	List<String> lists;

	public StreamDemo() {
		lists = new ArrayList<>();
		lists.add("a1");
		lists.add("a2");
		lists.add("b1");
		lists.add("b2");
		lists.add("b3");
		lists.add("o1");
	}

	public void streamFilterTest() {
		lists.stream().filter((s -> s.startsWith("a")))
				.forEach(System.out::println);

		// 等价于以上操作
		Predicate<String> predicate = (s) -> s.startsWith("a");
		lists.stream().filter(predicate).forEach(System.out::println);

		// 连续过滤
		Predicate<String> predicate1 = (s -> s.endsWith("1"));
		lists.stream().filter(predicate).filter(predicate1)
				.forEach(System.out::println);
	}

	public void streamSortedTest() {
		System.out.println("默认Comparator");
		lists.stream().sorted().filter((s -> s.startsWith("a")))
				.forEach(System.out::println);

		System.out.println("自定义Comparator");
		lists.stream().sorted((p1, p2) -> p2.compareTo(p1))
				.filter((s -> s.startsWith("a"))).forEach(System.out::println);

	}

	public void streamMapTest() {
		lists.stream().map(String::toUpperCase)
				.sorted((a, b) -> b.compareTo(a)).forEach(System.out::println);

		System.out.println("自定义映射规则");
		Function<String, String> function = (p) -> {
			return p + ".txt";
		};
		lists.stream().map(String::toUpperCase).map(function)
				.sorted((a, b) -> b.compareTo(a)).forEach(System.out::println);

	}

	public void streamMatchTest() {
		// 流对象中只要有一个元素匹配就返回true
		boolean anyStartWithA = lists.stream().anyMatch(
				(s -> s.startsWith("a")));
		System.out.println(anyStartWithA);
		// 流对象中每个元素都匹配就返回true
		boolean allStartWithA = lists.stream().allMatch(
				(s -> s.startsWith("a")));
		System.out.println(allStartWithA);
	}

	public void streamCollectTest() {
		List<String> list = lists.stream().filter((p) -> p.startsWith("a"))
				.sorted().collect(Collectors.toList());
		System.out.println(list);

	}

	public void streamCountTest() {
		long count = lists.stream().filter((s -> s.startsWith("a"))).count();
		System.out.println(count);
	}
	
	 public void streamReduceTest() {
	        Optional<String> optional = lists.stream().sorted().reduce((s1, s2) -> {
	            System.out.println(s1 + "|" + s2);
	            return s1 + "|" + s2;
	        });
	    }

	public static void main(String[] args) {
		StreamDemo sd = new StreamDemo();
		// sd.streamFilterTest();
		// sd.streamSortedTest();
		// sd.streamMapTest();
		// sd.streamMatchTest();
		// sd.streamCollectTest();
//		sd.streamCountTest();
		sd.streamReduceTest();
	}

}
