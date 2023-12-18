package mapandflatmap;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OptionalDemo {

  public static Customer getCustomerByEmailId(String email) throws Exception {
    List<Customer> customers = EkartDB.getAll();
    return customers
      .stream()
      .filter(c -> c.getEmail().equals(email))
      .findAny()
      .orElseThrow(() -> new Exception("no customer present with this mail"));
  }

  public static void main(String[] args) throws Exception {
    Customer customer = new Customer(
      101,
      "John",
      null,
      Arrays.asList("712635162", "78531272")
    );

    //optional can be created by
    //empty
    //of
    //ofNullable

    Optional<Object> emptyOptional = Optional.empty();
    System.out.println(emptyOptional); //--returns empty optional object

    // Optional<String> emailOptional = Optional.of(customer.getEmail());
    // System.out.println(emailOptional); //--gives null pointer exception if we pass a value with null

    Optional<String> emailOptional2 = Optional.ofNullable(customer.getEmail());
    // if (emailOptional2.isPresent()) {
    //   System.out.println(emailOptional2.get());
    // }
    // System.out.println(emailOptional2.get()); //--if value present return value else return empty optional object and if we directly call the get method on null object then it will raise a noSuchElementException instead check the value if present and call the get method.
    System.out.println(emailOptional2.orElse("default@gmail.com")); //--adds a default value if the the value is null or else return a value
    // System.out.println(
    //   emailOptional2.orElseThrow(() ->
    //     new IllegalArgumentException("email not present")
    //   )
    // );

    System.out.println(
      emailOptional2
        .map(String::toUpperCase)
        .orElseGet(() -> "default email...")
    );

    //use the Optional concept with stream API
    getCustomerByEmailId("pqr");
  }
}
