package collections;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;

public class MapExample {
    public static void main(String[] args) {

        //HASHMAP

        HashMap<String,Integer> hm = new HashMap<>();

        //adding elements  -- put method
        hm.put("Core java", 4000);
        hm.put("Python Full stack", 30000);
        // hm.put("Python Full stack", 30000); //No Duplicates
        hm.put("Core & Adv Java", 8000);
        System.out.println(hm);
        System.out.println(hm.get("Core java"));


        //LinkedHashMap

        LinkedHashMap<String,Integer> lhm = new LinkedHashMap<>();
        lhm.putAll(hm);
        lhm.put("Second", 2);
        System.out.println(lhm);

        //TREEMAP
        TreeMap<String,Integer> tm = new TreeMap<>();
        tm.putAll(lhm);
        System.out.println(tm);
        tm.forEach((a,b)->System.out.println(a + "->" + b));

    }
}
