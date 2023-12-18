package cgg.streamoperations;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;


public class StreamOperation {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		
		list.add("FFFA");
		list.add("AAFA");
		list.add("DDFD");
		list.add("BBFB");
		
		/* Stream<String> stream = list.stream(); */ //intermediate opeartion
		
		/* Stream<String> distinct = stream.distinct(); */ //intermediate operation
		
		/* long count = distinct.count(); */ //terminal operation
		
		long count = list.stream().distinct().count();
		System.out.println(count);
		
		//streams cannot be reused
		
		boolean anyMatch=list.stream().anyMatch(s->s.contains("FA"));
		System.out.println(anyMatch);
		
		System.out.println("------------------------------");
		
		List<Student> stuList = new ArrayList<>();
		
		  stuList.add(new Student("PK",23));
		  stuList.add(new Student("KK",26));
		  stuList.add(new Student("MK",23));
		  stuList.add(new Student("SK",21));
		  stuList.add(new Student("RK",40));
		  stuList.add(new Student("BK",30));
		  //stuList.add(new Student("DK",80));
		  
		  
		  Stream<Student> filteredList=stuList.stream().filter(s->s.getAge()>25);
		  filteredList.forEach(System.out::println);
		  
		  System.out.println("----------------------------");
		  
		  boolean allMatch = stuList.stream().allMatch(s->s.getName().contains("K"));
		  System.out.println(allMatch);
		  
		  System.out.println("---------------------------");
		  boolean anyMatch2 = stuList.stream().anyMatch(s->s.getAge()>35);
		  System.out.println(anyMatch2);
		  
		  System.out.println("---------------------------");
		  boolean noneMatch = stuList.stream().noneMatch(s->s.getAge()>55);
		  System.out.println(noneMatch);
		  

	}

}
