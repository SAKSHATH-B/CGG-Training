package collections;

import java.util.ArrayList;
import java.util.ListIterator;

import javax.swing.text.html.HTMLDocument.Iterator;

public class Traverse {
    public static void main(String[] args) {
        
        ArrayList<String> al = new ArrayList<>();
        al.add("ABC");
        al.add("PQR");
        al.add("XYZ");
        al.add("DEF");
        al.add("ABC");

        for(String st : al){
            System.out.println(st + "\t" + st.length());
            StringBuffer sb = new StringBuffer(st);
            System.out.println(sb.reverse());
        }
        System.out.println("________________________");



        //Traversing using Iterator  -- Forward Traversing

        // Iterator<String> itr = al.iterator();
        // while(itr.hasNext()){
        //     System.out.println(itr.next());
        // }

        //BackwardTraversal of collection using list iterator
        //ForwardTraversal of collection using list iterator

        ListIterator<String>litr = al.listIterator(al.size());
        // System.out.println("Forward --> ");
        // while(litr.hasNext()){
        //     System.out.println(litr.next());
        // }
        System.out.println("Backward --> ");
        while(litr.hasPrevious()){
            System.out.println(litr.previous());
        }


        //enumeration
        System.out.println("----------------For Each method-----------------");
        al.forEach(e->System.out.println(e));
    }
}
