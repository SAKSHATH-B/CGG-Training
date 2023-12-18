package cgg.functionalinterface;

import java.util.function.BiFunction;
import java.util.function.Function;

public class BiFunctionalDefaultMeth {

  public static void main(String[] args) {
    BiFunction<String, Integer, Integer> bifunction = (designation, age) -> {
      if (designation != null && age != null) {
        if (designation.equalsIgnoreCase("Manager") && age > 30) {
          return 120000;
        } else if (designation.equalsIgnoreCase("Developer") && age > 25) {
          return 90000;
        } else {
          return 0;
        }
      } else {
        return 0;
      }
    };

    int salary1 = bifunction.apply("Manager", 40);
    System.out.println(salary1);
    int salary2 = bifunction.apply("Developer", 30);
    System.out.println(salary2);

    Function<Integer, String> function = s1 -> {
      if (s1 >= 100000) {
        return "Band 5";
      } else if (s1 >= 80000) {
        return "Band 4";
      } else {
        return "Band 3";
      }
    };

    System.out.println(bifunction.andThen(function).apply("Manager", 31));
    String salMgr = bifunction.andThen(function).apply("Developer", 33);
    System.out.println(salMgr);
  }
}
