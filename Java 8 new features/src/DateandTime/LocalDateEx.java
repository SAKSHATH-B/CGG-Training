package DateandTime;

import java.time.LocalDate;
import java.time.Month;

public class LocalDateEx {

  public static void main(String[] args) {
    LocalDate now = LocalDate.now();
    System.out.println(now);

    LocalDate bday = LocalDate.of(2001, Month.OCTOBER, 04);
    System.out.println("BirthDate: " + bday);

    System.out.println("Tomorrow: " + now.plusDays(1));
    System.out.println("Last Month: " + now.minusMonths(1));
    System.out.println("Is LeapYear: " + now.isLeapYear());
    System.out.println("Last day of the month: " + now.withDayOfMonth(31));
  }
}
