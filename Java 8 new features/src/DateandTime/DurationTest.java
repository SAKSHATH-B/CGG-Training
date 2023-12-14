package DateandTime;

import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class DurationTest {

  public static void main(String[] args) {
    LocalTime initialTime = LocalTime.of(6, 30, 0);
    LocalTime finalTime = initialTime.plus(Duration.ofSeconds(30));

    long seconds = Duration.between(initialTime, finalTime).getSeconds();
    long between = ChronoUnit.SECONDS.between(initialTime, finalTime);
    System.out.println(seconds);
    System.out.println(between);
  }
}
