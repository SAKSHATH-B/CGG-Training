package mapandflatmap;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EkartDB {

  public static List<Customer> getAll() {
    return Stream
      .of(
        new Customer(
          101,
          "john",
          "john@gmail.com",
          Arrays.asList("3275423", "73254723")
        ),
        new Customer(
          102,
          "sam",
          "sam@gmail.com",
          Arrays.asList("765327", "83274378")
        ),
        new Customer(
          103,
          "jack",
          "jack@gmail.com",
          Arrays.asList("903274", "39824")
        ),
        new Customer(
          104,
          "daniel",
          "daniel@gmail.com",
          Arrays.asList("923784", "0293478")
        )
      )
      .collect(Collectors.toList());
  }
}
