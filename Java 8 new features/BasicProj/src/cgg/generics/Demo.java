package cgg.generics;

import java.util.ArrayList;
import java.util.List;

public class Demo {

	public static void main(String[] args) {
		//advantage of type safety errors are caught at compile time
		List<Integer> list = new ArrayList<>();
		//list.add("CGG");
		list.add(123);
		
		
		//type is Object class
		List anotherList = new ArrayList();
		anotherList.add("CGG");
		anotherList.add(12);
		anotherList.add(12.45);
		
		System.out.println(list);
		System.out.println(anotherList);

	}

}
