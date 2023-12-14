package DateandTime;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

public class ZoneDateTimeTest {

  public static void main(String[] args) {
    ZoneId z1 = ZoneId.of("Asia/Kolkata");

    // Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
    // availableZoneIds.forEach(System.out::println);

    ZonedDateTime of = ZonedDateTime.of(LocalDateTime.now(), z1);
    System.out.println(of);

    LocalDateTime of2 = LocalDateTime.of(2001, Month.OCTOBER, 20, 06, 20);
    ZoneOffset of3 = ZoneOffset.of("+02:00");
    OffsetDateTime of4 = OffsetDateTime.of(of2, of3);
    System.out.println(of4);
  }
}
