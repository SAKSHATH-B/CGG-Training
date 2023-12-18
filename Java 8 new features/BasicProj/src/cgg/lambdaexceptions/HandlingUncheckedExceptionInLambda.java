package cgg.lambdaexceptions;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class HandlingUncheckedExceptionInLambda {

	public static void main(String[] args) {
		//List<Integer> integers= Arrays.asList(3,9,7,6,10,20);
		List<Integer> integers= Arrays.asList(3,9,7,0,10,20);
		/*
		 * integers.forEach(i->{ try { System.out.println(50/i); }
		 * catch(ArithmeticException e) {
		 * System.out.println("Arithmetic Exception Occurred: "+e.getMessage()); }
		 * 
		 * 
		 * 
		 * });
		 */
		
		//integers.forEach(lambdaWrapper(i->System.out.println(50/i)));
		integers.forEach(consumerWrapper(i->System.out.println(50/i),Exception.class));

}
	
	private static <T,E extends Exception> Consumer<T> consumerWrapper(Consumer<T> consumer,Class<E> c){
		return i->{
			try {
				consumer.accept(i);
			}
			catch(ArithmeticException e) {
				System.out.println("Exception has occurred: "+e.getMessage());
			}
		};
	}
/*
 * private static Consumer<Integer> lambdaWrapper(Consumer<Integer> consumer){
 * 
 * return i->{ try { consumer.accept(i); }catch(ArithmeticException e) {
 * System.out.println("Arithmetic Exception Occurred: "+e.getMessage()); } }; }
 */
}
