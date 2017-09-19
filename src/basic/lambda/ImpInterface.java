package basic.lambda;

public class ImpInterface {

	public static void main(String[] args) {
		Converter<String, Integer> converter = new Converter<String, Integer>() {
			@Override
			public Integer convert(String from) {
				return Integer.valueOf(from);
			}
		};
		Integer result = converter.convert("200");
		System.out.println(result);

		Converter<String, Integer> converter2 = (param) -> Integer
				.valueOf(param);
		Integer result2 = converter2.convert("101");
		System.out.println(result2);
	}

	@FunctionalInterface
	interface Converter<F, T> {

		T convert(F from);

	}

}
