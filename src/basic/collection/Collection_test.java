package basic.collection;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Collection_test {

	public static void main(String[] args) {
//		Set<String> set = new HashSet<String>();
//		set.add("London");
//		set.add("Paris");
//		set.add("New York");
//		
//		System.out.println(set);
//		
//		List<String> list = new ArrayList<String>();
//		list.add("a");
//		list.add("b");
//		
//		System.out.println(list);
		
		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		TreeSet<String> treeSet = new TreeSet<String>(list);
		List<String> list2 = new LinkedList<String>();
		list2.get(1);
		List<String> list3 = Arrays.asList("red", "green", "blue");
		Collections.synchronizedList(new ArrayList());
		StringTokenizer tokens = new StringTokenizer("","");
		HashMap<String, String> a = new HashMap<String, String>();
		Iterator<Entry<String, String>> it = (Iterator<Entry<String, String>>) a.entrySet();
		Collections.shuffle(list3);
		List<String> list4 = new ArrayList<>();
		
		
	}

}
