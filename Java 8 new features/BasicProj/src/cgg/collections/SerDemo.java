package cgg.collections;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class SerDemo {

	public static void main(String[] args) {
		HashSet<Integer> hs = new HashSet<>();
		hs.add(12);
		hs.add(14);
		hs.add(5);
		hs.add(4);
		hs.add(12);
		
		System.out.println(hs);
		System.out.println("------------");
		for (Integer i : hs) {
			System.out.println(i);
		}
		LinkedHashSet<Integer> lhs = new LinkedHashSet<>();
		lhs.add(12);
		lhs.add(14);
		lhs.add(5);
		lhs.add(4);
		lhs.add(12);
		
		System.out.println(lhs);
		System.out.println("-------------------");
		
		for (Integer i : lhs) {
			System.out.println(i);
		}
		System.out.println("------Iterator-------");
		Iterator<Integer> iterator = lhs.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
		System.out.println("------------for each method-----------");
		lhs.forEach(System.out::println);
		
		TreeSet<String> ts = new TreeSet<>();
		ts.add("pqr");
		ts.add("xyz");
		ts.add("abc");
		ts.add("uvw");
		
		System.out.println(ts);

	}

}
