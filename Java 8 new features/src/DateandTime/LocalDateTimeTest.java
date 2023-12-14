package DateandTime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

public class LocalDateTimeTest {

  public static void main(String[] args) {
    LocalDateTime localDT = LocalDateTime.now();
    System.out.println(localDT);

    LocalDateTime localDT2 = LocalDateTime.of(
      2001,
      Month.OCTOBER,
      04,
      10,
      10,
      10
    );
    System.out.println(localDT2);

    LocalDateTime localDT3 = LocalDateTime.parse("2001-10-04T23:59:59");
    System.out.println(localDT3);

    LocalDateTime plusDays = localDT3.plusDays(1);
    System.out.println(plusDays);

    Month month = localDT3.getMonth();
    System.out.println(month);

    LocalDate date = LocalDateTime.now().toLocalDate();
    LocalTime time = LocalDateTime.now().toLocalTime();
    System.out.println(date);
    System.out.println(time);
  }
}
