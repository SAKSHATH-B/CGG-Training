package cgg.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class ListDemo {

	public static void main(String[] args) {
		//type-safe
		ArrayList<String> al = new ArrayList<>();
		al.add("abc");
		al.add("12");
		al.add("hi");
		al.add("abc");
				
		System.out.println(al);
		al.get(0);
		al.get(1);
		System.out.println("--------------------");
		for (String s: al) {
			System.out.println(s);
		}
		
		System.out.println("---------------------");
		Iterator<String> iter = al.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
          ListIterator<String> listIterator = al.listIterator();
          System.out.println("Forwrad List");
          while(listIterator.hasNext()) {
        	  System.out.println(listIterator.next());
          }
          
          System.out.println("Backward List");
          while(listIterator.hasPrevious()) {
        	  System.out.println(listIterator.previous());
          }
          System.out.println("for each method");
          al.forEach(System.out::println);
		//non-type safe
		LinkedList ll = new LinkedList();
		ll.add("pqr");
		ll.add(12.5f);
		ll.add(12);
		ll.add(12);
		
		System.out.println(ll);
		System.out.println(ll.get(1));
		System.out.println("--------------------");
		for (Object o : ll) {
			System.out.println(o);
		}
	}

}
