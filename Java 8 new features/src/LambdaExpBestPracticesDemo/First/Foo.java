package LambdaExpBestPracticesDemo.First;

@FunctionalInterface
public interface Foo {
  String method(String name);
}
//when ever creating any functional interface we need to specify the @FunctionalInterface annotation so as to indicate the developers that it is a functional interface that contains one abstract method and indicate the compiler to raise errors whenever we try to write one more abstract method in it.
