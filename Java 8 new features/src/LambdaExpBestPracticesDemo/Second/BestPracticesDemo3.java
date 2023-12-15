package LambdaExpBestPracticesDemo.Second;

public class BestPracticesDemo3 {

  private String value = "Enclosing scope value";

  public static void main(String[] args) {
    new BestPracticesDemo3().scopeExperiment();
  }

  private void scopeExperiment() {
    Foo foo1 = new Foo() {
      private String value = "Inner Class value";

      @Override
      public String method() {
        return this.value;
      }
    };

    System.out.println(foo1.method());
    Foo foo2 = () -> {
      String value = "Lambda Value";
      return this.value;
    };
    System.out.println(foo2.method());
  }
}

/**
 * Foo
 */
@FunctionalInterface
interface Foo {
  String method();
}
