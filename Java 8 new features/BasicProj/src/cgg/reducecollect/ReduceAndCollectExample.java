package cgg.reducecollect;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ReduceAndCollectExample {

	public static void main(String[] args) {
		List<Integer> integers = new ArrayList<>();
		
		integers.add(10);
		integers.add(20);
		integers.add(30);
		
		Integer sum = integers.stream().reduce(100,(x,y)->x+y);
        System.out.println(sum);
        
        System.out.println("--------------------------");
        List<String> names=new ArrayList<>();
        names.add("ABC");
        names.add("PQR");
        names.add("XYZ");
        
        List<String> collect = names.stream().map(e->e.toLowerCase()).collect(Collectors.toList());
        collect.forEach(System.out::println);
	}

}
