package cgg.MapDefaultMethods;

import java.util.LinkedHashMap;
import java.util.Map;

public class MapComputeIfPresentEx {

  public static void main(String[] args) {
    Map<Integer, String> map = new LinkedHashMap<>();
    map.put(1, "Java");
    map.put(2, "Java");
    System.out.println("Original Map: " + map);

    map.computeIfPresent(1, (key, oldVal) -> oldVal.concat("Script"));
    map.computeIfPresent(2, (key, oldVal) -> oldVal.concat("Framework"));
    System.out.println("Recomputed map: " + map);

    String s1 = map.computeIfPresent(1, (key, oldVal) -> null);
    System.out.println(s1);
    System.out.println(map);

    String r2 = map.computeIfPresent(3, (key, oldVal) -> null);
    System.out.println(r2);

    String r3 = map.computeIfPresent(30, (key, oldVal) -> "Spring Framework");
    System.out.println(r3);
    System.out.println("After null: " + map);
  }
}
