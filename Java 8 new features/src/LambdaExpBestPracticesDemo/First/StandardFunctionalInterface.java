package LambdaExpBestPracticesDemo.First;

import java.util.function.Function;

public class StandardFunctionalInterface {

  public static void main(String[] args) {
    // Foo foo = p -> p + " from lambda";
    // UseFoo useFoo = new UseFoo();
    // String string = useFoo.add("John", foo);
    // System.out.println(string);
    //This code is same as to pre existing Function Functional Interface
    //no need to create any other user functional interfaces

    Function<String, String> fun = p -> p + " from lambda";
    UseFoo useFoo = new UseFoo();
    String string = useFoo.add("Martin", fun);
    System.out.println(string);
    //now we are using default functional interfaces and no need to create other functional interfaces

  }
}
