package cgg.functionalinterface;

import java.util.function.BiConsumer;

public class BiConsumerAndThenEx {

  public static void main(String[] args) {
    BiConsumer<Integer, Integer> adder = (i1, i2) ->
      System.out.println(i1 + i2);

    BiConsumer<Integer, Integer> multiplier = (i1, i2) ->
      System.out.println(i1 * i2);

    adder.andThen(multiplier).accept(10, 20);
    multiplier.andThen(adder).accept(10, 20);
  }
}
