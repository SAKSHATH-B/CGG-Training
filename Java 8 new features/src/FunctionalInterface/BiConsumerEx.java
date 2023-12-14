package FunctionalInterface;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class BiConsumerEx {

  public static void main(String[] args) {
    Map<Integer, String> hashMap = new HashMap<>();
    hashMap.put(1, "Cgg");
    hashMap.put(2, "Gachibowli");
    hashMap.put(3, "Hyd");

    // BiConsumer<Integer, String> biConsumer = (k, v) ->
    //   System.out.println("Key: " + k + "\t" + "Value: " + v);
    hashMap.forEach((k, v) ->
      System.out.println("Key: " + k + "\t" + "Value: " + v)
    );
  }
}
