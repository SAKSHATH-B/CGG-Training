package DateandTime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

public class ConvertOldDatetoNewTest {

  public static void main(String[] args) {
    Date date = new Date();

    LocalDateTime localDateTime = LocalDateTime.ofInstant(
      date.toInstant(),
      ZoneId.systemDefault()
    );
    System.out.println(localDateTime);

    LocalDate localDate = localDateTime.toLocalDate();
    LocalTime localTime = localDateTime.toLocalTime();
    System.out.println(localDate);
    System.out.println(localTime);

    Calendar calendar = Calendar.getInstance();
    LocalDateTime localCalender = LocalDateTime.ofInstant(
      calendar.toInstant(),
      ZoneId.systemDefault()
    );
    System.out.println(localCalender);
  }
}
