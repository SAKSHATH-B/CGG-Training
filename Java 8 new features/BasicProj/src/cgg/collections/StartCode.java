package cgg.collections;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.Vector;

public class StartCode {
public static void main(String[] args) {
	/*
	 creating collection
	 
	 1.type safe - same type of elements(objects) are added to collection
	 
	 2.untype safe: different types of eleemnts can be added to coolection
	 */
	
	//type safe collection
	ArrayList<String> names= new ArrayList<>();
	names.add("ABC");
	names.add("PQR");
	names.add("XYZ");
	names.add("DEF");
	names.add("ABC");
	System.out.println(names);
	
	//get
//	System.out.println(names.get(0));
//    System.out.println(names.get(1));
	
	//remove
	names.remove("xyz");
	System.out.println(names);
	
	//size
	System.out.println("Size = "+names.size());
	
	//check item is there or not
	//calls equals method of type
	System.out.println(names.contains("abc"));
	
	//check for empty
	System.out.println(names.isEmpty());
	
	//setting value
	//names.set(1, "PQR");
	names.add(1,"AAA");
	
	System.out.println(names);
	
	//remove all elements
	//names.clear();
	System.out.println(names);
    Vector<String> vector = new Vector<>();
    vector.addAll(names);
    System.out.println("VECTOR " +vector);
    System.out.println("-----------------------");
    
    HashSet<Double> nms= new HashSet<>();
    nms.add(14.34);
    nms.add(45.678);
    nms.add(new Double(2345.45));
    nms.add(99.3);
    nms.add(99.3);
    nms.add(5.3);
    System.out.println(nms);
    
    TreeSet<Double> tset = new TreeSet<>();
    tset.addAll(nms);
    
    
	//un type safe
//	LinkedList list = new LinkedList();
//	list.add("abc");
//	list.add(110);
//	list.add(123.45);
//	list.add(true);
}
}
