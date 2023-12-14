package DateandTime;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class DateTimeFormatterTest {

  public static void main(String[] args) {
    String format = LocalDateTime
      .of(2001, 10, 04, 06, 30, 0)
      .format(DateTimeFormatter.ofPattern("yyyy/MM/dd-hh/mm/ss"));
    System.out.println(format);

    String format2 = LocalDateTime
      .of(2001, 10, 04, 06, 30, 0)
      .format(DateTimeFormatter.ISO_DATE);
    System.out.println(format2);

    String format3 = LocalDateTime
      .of(2001, 10, 04, 06, 30, 0)
      .format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM));
    System.out.println(format3);

    String format4 = LocalDateTime
      .now()
      .format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL));
    System.out.println(format4);
  }
}
