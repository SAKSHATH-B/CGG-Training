package FunctionalInterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class SupplierDemo {

  public static void main(String[] args) {
    Supplier<String> str = () -> "Hello Man";
    System.out.println(str.get());

    List<String> list = Arrays.asList("a", "b");
    System.out.println(list.stream().findAny().orElseGet(str));
  }
}
