package FunctionalInterface;

import java.util.HashMap;
import java.util.function.BiConsumer;

public class BiConsumerEx implements BiConsumer<String, Integer> {

  @Override
  public void accept(String i1, Integer i2) {
    System.out.println("Input 1 :" + i1 + " Input 2 :" + i2);
  }

  public static void main(String[] args) {
    BiConsumer<String, Integer> biConsumerEx = new BiConsumerEx();
    biConsumerEx.accept("javatechie", 53000);

    BiConsumer<String, Integer> biConsumer2 = new BiConsumer<String, Integer>() {
      @Override
      public void accept(String i1, Integer i2) {
        System.out.println(i1 + " : " + i2);
      }
    };
    biConsumer2.accept("Welcome", 928);

    BiConsumer<String, Integer> biConsumer3 = (i1, i2) ->
      System.out.println("Key :" + i1 + " value :" + i2);
    biConsumer3.accept("Youtube", 65);

    HashMap<String, Integer> map = new HashMap<>();
    map.put("basant", 5000);
    map.put("santhosh", 15000);
    map.put("javed", 12000);

    map.forEach(biConsumer3);
    map.forEach((k, v) -> System.out.println(k + ":" + v));
  }
}
