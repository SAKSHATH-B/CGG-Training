package DateandTime;

import java.time.LocalTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

public class LocalTimeTest {

  public static void main(String[] args) {
    LocalTime localTime = LocalTime.now();
    System.out.println(localTime);

    LocalTime now = LocalTime.now(ZoneId.of("America/Los_Angeles"));
    System.out.println(now);

    LocalTime localTime2 = LocalTime.parse("06:30");
    System.out.println(localTime2);

    LocalTime localTime3 = LocalTime.of(8, 50);
    System.out.println(localTime3);

    System.out.println("----------------------------");

    LocalTime localTime4 = LocalTime.parse("06:30").plusHours(3);
    System.out.println(localTime4);

    LocalTime localTime5 = LocalTime.parse("06:30").plus(10, ChronoUnit.HOURS);
    System.out.println(localTime5);

    int localTime6 = LocalTime.parse("06:30").getHour();
    System.out.println(localTime6);

    boolean localTime7 = LocalTime
      .parse("06:30")
      .isBefore(LocalTime.parse("07:30"));
    System.out.println(localTime7);

    LocalTime localTime8 = LocalTime.MAX;
    System.out.println(localTime8);

    boolean before = LocalTime
      .parse("06:30")
      .isBefore(LocalTime.parse("07:30"));
    System.out.println(before);
  }
}
