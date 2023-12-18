package cgg.functionalinterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

public class BiFunctionExample {

  public static void main(String[] args) {
    List<Student> list = new ArrayList<>();

    list.add(new Student("Martin", 23));
    list.add(new Student("Andrew", 20));
    list.add(new Student("Sean", 21));

    for (Student student : list) {
      System.out.println(
        student.customShow(s -> s.getName() + "\t" + s.getAge())
      );
    }

    Function<Student, String> styleOne = s -> {
      String result = "Name :" + s.getName() + " and Age: " + s.getAge();
      return result;
    };

    System.out.println("--------------------------------");
    for (Student student : list) {
      System.out.println(student.customShow(styleOne));
    }

    Function<Student, String> styleTwo = s -> s.getName() + "\t" + s.getAge();
    System.out.println("--------------------------------");
    for (Student student : list) {
      System.out.println(student.customShow(styleTwo));
    }

    System.out.println(
      "_____________________________________________________________"
    );

    Map<Integer, String> hashMap = new HashMap<>();
    hashMap.put(1, "Cgg");
    hashMap.put(2, "Gachibowli");
    hashMap.put(3, "Hyd");

    // BiFunction<Integer, String, String> biFunction = (k, v) -> {
    //   return "Key: " + k + "\t" + "Value: " + v;
    // };
    // String apply = biFunction.apply(1, "hyd");
    // System.out.println(apply);

    BiFunction<Integer, String, Void> biFunction = (k, v) -> {
      System.out.println(k + " : " + v);
      return null;
    };

    hashMap.forEach((k, v) -> biFunction.apply(k, v));
  }
}
