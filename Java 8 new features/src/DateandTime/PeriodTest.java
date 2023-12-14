package DateandTime;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class PeriodTest {

  public static void main(String[] args) {
    LocalDate initialDate = LocalDate.parse("2001-10-04");
    LocalDate finalDate = initialDate.plus(Period.ofDays(5));
    System.out.println(finalDate);

    int days = Period.between(initialDate, finalDate).getDays();
    long between = ChronoUnit.DAYS.between(initialDate, finalDate);
    System.out.println(days);
    System.out.println(between);
  }
}
