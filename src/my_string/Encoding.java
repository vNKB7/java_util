package my_string;

public class Encoding {

	public static boolean is_chinese(String str) {
		String regex = "^[\u4e00-\u9fa5]+$";
		return str.matches(regex);
	}

}
