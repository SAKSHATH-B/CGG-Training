package DateandTime;

import java.time.Clock;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

public class LocalDateTest {

  public static void main(String[] args) {
    DayOfWeek dayOfWeek = LocalDate.parse("2023-12-14").getDayOfWeek();
    int dayOfMonth = LocalDate.parse("2023-12-14").getDayOfMonth();
    System.out.println(dayOfWeek);
    System.out.println(dayOfMonth);

    System.out.println("------------------------------");

    boolean leapYear = LocalDate.now().isLeapYear();
    System.out.println(leapYear);

    boolean leapYear2 = LocalDate.now().plusYears(1).isLeapYear();
    System.out.println(leapYear2);

    System.out.println("------------------------------");

    boolean before = LocalDate
      .parse("2023-12-14")
      .isBefore(LocalDate.parse("2023-12-12"));
    System.out.println(before);

    boolean after = LocalDate
      .parse("2023-12-14")
      .isAfter(LocalDate.parse("2023-12-12"));
    System.out.println(after);

    System.out.println("------------------------------");

    LocalDateTime atStartOfDay = LocalDate.parse("2023-12-14").atStartOfDay();
    System.out.println(atStartOfDay);

    LocalDate with = LocalDate
      .parse("2023-12-14")
      .with(TemporalAdjusters.firstDayOfMonth());
    System.out.println(with);
  }

  public static void getLocalDateDemo() {
    LocalDate localDate1 = LocalDate.now();
    System.out.println(localDate1);

    Clock systemDefaultZone = Clock.systemDefaultZone();
    LocalDate localDate2 = LocalDate.now(systemDefaultZone);
    System.out.println(localDate2);

    ZoneId zoneId = ZoneId.of("Europe/Paris");
    LocalDate localDate3 = LocalDate.now(zoneId);
    System.out.println(localDate3);

    System.out.println("--------------------------------");

    LocalDate localDate4 = LocalDate.of(2001, 10, 04);
    System.out.println(localDate4);

    LocalDate localDate5 = LocalDate.parse("2001-10-05");
    System.out.println(localDate5);

    LocalDate localDate6 = localDate5.plusDays(2);
    System.out.println(localDate6);

    LocalDate localDate7 = localDate5.minus(2, ChronoUnit.DAYS);
    System.out.println(localDate7);

    System.out.println("-----------------------------------");
  }
}
