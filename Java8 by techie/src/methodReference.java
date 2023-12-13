public class methodReference {

  void m1() {
    System.out.println("m1() instance/non-static method");
  }

  public static void m2() {
    System.out.println("m2() static method");
  }

  public static void main(String[] args) {
    //General method to call the two methods are
    methodReference.m2();

    methodReference mr = new methodReference();
    mr.m1();
    //method reference
    //reference :: method name  -- (signature)
    // methodReference::m2(); //static method reference
    // mr::m1(); //instance method reference
    //constructor reference

  }
}
