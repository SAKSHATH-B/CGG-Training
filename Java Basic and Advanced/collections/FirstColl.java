package collections;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;
import java.util.Vector;

public class FirstColl {
    public static void main(String[] args) {
        // Creating Collections
        // 1. type safe - same type of elements(objects) are added to collections
        // 2.untype safe - different type of elements are added to collections

        List<String> list = new ArrayList<>();
        list.add("ABC");
        list.add("PQR");
        list.add("XYZ");
        list.add("DEF");
        list.add("ABC");

        System.out.println(list);

        //get
        // System.out.println(list.get(4));

        //remove
        list.remove("ABC");
        System.out.println(list);

        //size
        System.out.println(list.size());

        //Check item is there or not
        //calls equals method of that datatype
        System.out.println(list.contains("XYZ"));

        //check for empty
        System.out.println(list.isEmpty());

        //setting value
        list.set(1, "BSH"); //replace the value
        list.add(1,"aaa");  //Adds a value at specific position
        System.out.println(list);

        //remove all elements
        // list.clear();
        // System.out.println(list);

        //creating a vector
        // Vector<String> v = new Vector<>();
        // v.addAll(list);

        //SET
        HashSet<Double> hs = new HashSet<>();
        hs.add(16.85);
        hs.add(25.00);
        hs.add(0.821);
        hs.add(0.821);  //Duplicates are not allowed
        System.out.println(hs);

        //Linked HashSet -- order will be preserved
        LinkedHashSet<Double> lhs = new LinkedHashSet<>();
        lhs.addAll(hs);
        lhs.add(12.22);
        System.out.println(lhs);
        System.out.println("-------------------------");

        //TREE SET
        TreeSet<Double> ts = new TreeSet<>();
        ts.addAll(hs);
        System.out.println(ts);






        // UNTYPE SAFE 

        //create a LinkedList
        // LinkedList l1 = new LinkedList<>();
        // l1.add("abc");
        // l1.add(12);
        // l1.add(true);
        // l1.add(12.2);
        // l1.add(list);
        // System.out.println(l1);


        
    }
}
