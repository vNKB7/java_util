package zwz.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test {
	public static void main(String[] args){
		String biaoduan = "[一二三四五六七八九十]标段";
		String text = "那是三标段对吧";
		Pattern p = Pattern.compile(biaoduan);
		Matcher m = p.matcher(text);
		while (m.find()) {
			String t = m.group().trim();
			if (t.length() > 0) {
				System.out.println(t);
			}
		}
	}
}
