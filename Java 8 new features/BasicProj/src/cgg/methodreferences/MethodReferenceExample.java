package cgg.methodreferences;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Function;

public class MethodReferenceExample {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		
		//Runnable r = ()->System.out.println("My task is running");
		
		Runnable r = MethodReferenceExample::myRun;
		executorService.execute(r);
		System.out.println("-------------------------");
		
		List<Integer> numbers = Arrays.asList(4,9,36,100);
		numbers.forEach(System.out::println);
		System.out.println("---------------------------------");
		
		List<Double> findSquareRoots = MethodReferenceExample.findSquareRoots(numbers,Integer::new);
		findSquareRoots.forEach(System.out::println);
		
		System.out.println("-------------------------");
		List<Person> persons=new ArrayList<Person>();
		persons.add(new Person("Bean",27));
		persons.add(new Person("Sean",21));
		persons.add(new Person("Martin",45));
		persons.add(new Person("Frank",27));
		
		
		List<String> personNames=MethodReferenceExample.getPersonNames(persons,Person::getName);
        personNames.forEach(System.out::println);
        
        System.out.println("-------------------------");
        List<String> names=new ArrayList<>();
        names.add("David");
        names.add("Richard");
        names.add("Samuel");
        names.add("Rose");
        names.add("John");
        
        names.forEach(x->System.out.println(x));
        names.forEach(System.out::println);


		

	}
	
	private static List<String> getPersonNames(List<Person> persons,Function<Person,String> f){
		List<String> result=new ArrayList<>();
		persons.forEach(n->result.add(f.apply(n)));
		return result;
	}
	private static void myRun() {
		System.out.println("My task is running...");
	}

	private static List<Double> findSquareRoots(List<Integer> numbers,Function<Integer,Integer> f){
		List<Double> result=new ArrayList<>();
		
		numbers.forEach(x->result.add(Math.sqrt(f.apply(x))));
		
		return result;
	}
}
