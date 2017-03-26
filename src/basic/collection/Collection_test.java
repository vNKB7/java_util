package basic.collection;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Collection_test {

	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		set.add("London");
		set.add("Paris");
		set.add("New York");
		
		System.out.println(set);
		
		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		
		System.out.println(list);
		
	}

}
