package cgg.MapDefaultMethods;

import java.util.HashMap;
import java.util.Map;

public class MapReplaceAllMeth {

  public static void main(String[] args) {
    Map<Double, Double> map = new HashMap<>();
    map.put(2.0, 3.0);
    map.put(3.0, 3.0);
    map.put(2.0, 4.0);

    map.replaceAll((n1, n2) -> Math.pow(n1, n2));
    map.forEach((x, y) -> System.out.println(x + "\t" + y));

    System.out.println("---------------------");
    Map<Integer, String> empMap = new HashMap<>();
    empMap.put(190292, "Martin");
    empMap.put(190928, "Farnk");
    empMap.put(902292, "Andrew");

    String res = empMap.putIfAbsent(1001, "SAM");
    System.out.println(res);
    System.out.println(empMap.get(1001));
    System.out.println(empMap);

    String result2 = empMap.putIfAbsent(190928, "KK");
    System.out.println(result2);
    System.out.println(empMap.get(190928));
  }
}
