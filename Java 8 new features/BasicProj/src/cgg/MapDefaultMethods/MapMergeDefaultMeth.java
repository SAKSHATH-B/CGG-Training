package cgg.MapDefaultMethods;

import java.util.LinkedHashMap;
import java.util.Map;

public class MapMergeDefaultMeth {

  public static void main(String[] args) {
    Map<String, Integer> prices = new LinkedHashMap<>();
    System.out.println("Prices map: " + prices);

    prices.merge("fruits", 3, (k, v) -> k + v);
    System.out.println("Prices Map: " + prices);
    prices.merge("fruits", 5, Integer::sum);
    System.out.println("Prices Map: " + prices);

    // null removes mapping for the key:
    prices.merge(
      "fruits",
      7,
      (oldVal, newVal) -> {
        System.out.println("Old val:" + oldVal + "," + "new val:" + newVal);
        return null;
      }
    );
    System.out.println("Prices map: " + prices);

    prices.put("Bread", null);
    System.out.println("Prices map: " + prices);

    // No need to handle initial null value:
    prices.merge("Bread", 42, Integer::sum);
    System.out.println("Prices map: " + prices);
  }
}
