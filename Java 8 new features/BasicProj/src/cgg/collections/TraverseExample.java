package cgg.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.TreeSet;

public class TraverseExample {

	public static void main(String[] args) {
		ArrayList<String> names= new ArrayList<>();
		names.add("ABC");
		names.add("PQR");
		names.add("XYZ");
		names.add("DEF");
		names.add("ABC");
		
		//for each loop
		for(String str:names) {
			System.out.print(str+"\t"+str.length()+"\t");
			StringBuffer sb = new StringBuffer(str);
		    System.out.println(sb.reverse());
		}
		
		System.out.println("-----------------------------");
		
		//traversing using iterator:forward traversing
		Iterator<String> itr = names.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		System.out.println("-----------------------");
		//backward traversal of collection : LISTITERATOR
		ListIterator<String> litr = names.listIterator(names.size());
        while(litr.hasPrevious()) {
        	System.out.println(litr.previous());
        }
        
        //Enumeration
        System.out.println("---------FOR EACH METHOD-------------------");
        //for each method
        names.forEach(e->System.out.println(e));
        
        System.out.println("SORTING OF ELEMENTS");
        TreeSet<String> set = new TreeSet<String>();
        set.addAll(names);
        set.forEach(e->System.out.println(e));
	}

}
