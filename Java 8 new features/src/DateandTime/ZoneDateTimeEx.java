package DateandTime;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ZoneDateTimeEx {

  public static void main(String[] args) {
    ZonedDateTime zoneDateTime = ZonedDateTime.now();
    System.out.println(zoneDateTime);

    ZonedDateTime europeZone = ZonedDateTime.now(ZoneId.of("Europe/Paris"));
    System.out.println(europeZone);
  }
}
