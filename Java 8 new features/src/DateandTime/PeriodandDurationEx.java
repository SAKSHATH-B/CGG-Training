package DateandTime;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class PeriodandDurationEx {

  public static void main(String[] args) {
    LocalDate bday = LocalDate.of(2001, 10, 04);
    LocalDate today = LocalDate.now();
    Period period = bday.until(today);
    System.out.println(period);
    System.out.print("Years: " + period.get(ChronoUnit.YEARS));
    System.out.print(" Months: " + period.get(ChronoUnit.MONTHS));
    System.out.print(" Days: " + period.get(ChronoUnit.DAYS));
  }
}
