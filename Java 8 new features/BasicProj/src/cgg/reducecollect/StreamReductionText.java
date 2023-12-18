package cgg.reducecollect;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class StreamReductionText {

	public static void main(String[] args) {
		//1+2+3
		OptionalInt reduced = IntStream.range(1,4).reduce((a,b)->a+b);
        System.out.println(reduced.getAsInt());
        
        System.out.println("--------------------------------------");
        int reducedTwoParams = IntStream.range(1, 4).reduce(10,(a,b)->a+b);
	    System.out.println(reducedTwoParams);
	    
	    System.out.println("---------------------------------");
	    Integer reduce = Arrays.asList(1,2,3).parallelStream().reduce(10,(a,b)->a+b,(a,b)->{
	    	System.out.println("Combiner Called");
	    	return a+b;
	    });
	    //10+1,10+2,10+3
	    //11,12,13
	    //11,12+13
	    //11+25
	    //36
	    System.out.println(reduce);
	}

}
