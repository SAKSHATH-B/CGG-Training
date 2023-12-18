package cgg.functionalinterface;

import java.util.function.BiPredicate;

public class BiPredicateDefaultMethEx {

  public static void main(String[] args) {
    BiPredicate<Integer, Integer> biPredicate1 = (x, y) -> x > y;
    BiPredicate<Integer, Integer> biPredicate2 = (x, y) -> x - 2 > y;

    System.out.println(biPredicate1.and(biPredicate2).test(20, 15));
    System.out.println(biPredicate1.and(biPredicate2).test(10, 8));

    System.out.println("-----------------------------------------------");

    System.out.println(biPredicate1.or(biPredicate2).test(10, 15));
    System.out.println(biPredicate1.or(biPredicate2).test(15, 8));

    System.out.println("-----------------------------------------------");

    System.out.println(biPredicate1.negate().test(20, 18));
  }
}
