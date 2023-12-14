package ExceptionHandling;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * ExceptionHandlingEx
 */
public class ExceptionHandlingEx {

  public static void main(String[] args) {
    List<String> list = Arrays.asList("44", "12", "xy");
    // List<Integer> collect = list
    //   .stream()
    //   .map(s -> Integer.parseInt(s))
    //   .collect(Collectors.toList());

    //approach-1
    // list.forEach(s -> {
    //   try {
    //     System.out.println(Integer.parseInt(s));
    //   } catch (Exception e) {
    //     System.out.println("Exception: " + e.getMessage());
    //   }
    // });

    //approach-2
    // list.forEach(ExceptionHandlingEx::exceptionWrapper);

    //approach-3
    // list.forEach(handleException(s -> System.out.println(Integer.parseInt(s))));

    //approach-4
    // list.forEach(
    //   handleGenericException(
    //     s -> System.out.println(Integer.parseInt(s)),
    //     NumberFormatException.class
    //   )
    // );

    //checking for arithmetic exception
    // List<Integer> list2 = Arrays.asList(1, 0);
    // list2.forEach(
    //   handleGenericException(
    //     s -> System.out.println(10 / s),
    //     ArithmeticException.class
    //   )
    // );

    //handle exception for checked Exception
    List<Integer> list3 = Arrays.asList(10, 20);
    list3.forEach(
      handleCheckedException(i -> {
        Thread.sleep(i);
        System.out.println(i);
      })
    );
  }

  //approach-2  -   rather than hardcoding the exception logic in lambda we specify it in a wrapper function and call it
  public static void exceptionWrapper(String s) {
    try {
      System.out.println(Integer.parseInt(s));
    } catch (Exception e) {
      // TODO Auto-generated catch block
      System.out.println("Exception: " + e.getMessage());
    }
  }

  //approach-3  -   as foreach accepts a consumer create a consumer function which itselfs returns a consumer
  //this method only works if the list is of the type string and gives error if we have list of integer..so make the handleException as generic
  static Consumer<String> handleException(Consumer<String> input) {
    return obj -> {
      try {
        input.accept(obj);
      } catch (Exception e) {
        System.out.println("Exception: " + e.getMessage());
      }
    };
  }

  //generic exception
  static <
    Target, ExObj extends Exception
  > Consumer<Target> handleGenericException(
    Consumer<Target> input,
    Class<ExObj> exObjClass
  ) {
    return obj -> {
      try {
        input.accept(obj);
      } catch (Exception e) {
        try {
          ExObj exObj = exObjClass.cast(e);
          System.out.println("Exception: " + exObj.getMessage());
        } catch (ClassCastException e1) {
          throw e;
        }
      }
    };
  }

  static <Target> Consumer<Target> handleCheckedException(
    CheckedExceptionHandler<Target, Exception> handle
  ) {
    return obj -> {
      try {
        handle.accept(obj);
      } catch (Exception e) {
        throw new RuntimeException(e);
      }
    };
  }
}
