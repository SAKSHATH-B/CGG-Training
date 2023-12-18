package cgg.collections;

import java.util.ArrayList;
import java.util.Collections;

public class SortingExample {

	public static void main(String[] args) {
		ArrayList<Emp> al = new ArrayList<>();
		
		al.add(new Emp("abc","1234",12));
		al.add(new Emp("def","45678",5));
		al.add(new Emp("pqr","123467",14));
		al.add(new Emp("xyz","1234",40));
		
		System.out.println(al);
		
		Collections.sort(al,new IdComparator());
		
		System.out.println(al);
		
		
		ArrayList<Emp> al1= new ArrayList<>(al);
		System.out.println(al1);
		Collections.sort(al1,new NameComparator());
		System.out.println(al1);
		

	}

}
