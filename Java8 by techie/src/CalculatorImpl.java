/**
 * CalculatorImpl
 */
/**
 InnerCalculatorImpl
 */
interface Calculator {
  //   void switchOn();
  //   void Sum(int i);
  int substract(int i1, int i2);
}

public class CalculatorImpl {

  //()->{body};   --  syntax of lambda

  public static void main(String[] args) {
    // Calculator calc = () -> System.out.println("Switched On");
    // calc.switchOn();

    // Calculator calc = i -> System.out.println("sum: " + (i + i));
    // calc.Sum(5);

    Calculator calc = (i1, i2) -> i1 - i2;
    System.out.println(calc.substract(20, 1));
  }
}
