package mapandflatmap;

import java.util.List;
import java.util.stream.Collectors;

public class MapvsFlatmap {

  public static void main(String[] args) {
    List<Customer> customers = EkartDB.getAll();
    //List<Customer> convert to List<String> --> Data Transformation
    //mapping : cus -> cus.getEmail()   --  one-to-one mapping
    List<String> emails = customers
      .stream()
      .map(cus -> cus.getEmail())
      .collect(Collectors.toList());
    emails.forEach(System.out::println);

    //getting phone numbers as a stream of stream data
    //cus -> cus.getPhoneNumbers() -- one-to-many mapping
    List<List<String>> phoneNumbers = customers
      .stream()
      .map(cus -> cus.getPhoneNumbers())
      .collect(Collectors.toList());
    System.out.println(phoneNumbers);

    //flatmap
    List<String> phoneNumber = customers
      .stream()
      .flatMap(cus -> cus.getPhoneNumbers().stream())
      .collect(Collectors.toList());
    System.out.println(phoneNumber);
  }
}
