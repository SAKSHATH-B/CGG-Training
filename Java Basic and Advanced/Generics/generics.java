package Generics;

import java.util.ArrayList;
import java.util.List;

public class generics {
    public static void main(String[] args) {

        //avdantage : type safe and errors are caught at compile time
        List<String> list = new ArrayList<>();
        list.add("Cgg");
        list.add("7626");
        System.out.println(list);

        //type is object class
        List anotherList = new ArrayList<>();
        anotherList.add("New Cgg");
        anotherList.add(565);
        System.out.println(anotherList);

        
    }
}
