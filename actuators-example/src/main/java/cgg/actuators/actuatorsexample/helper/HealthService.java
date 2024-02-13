package cgg.actuators.actuatorsexample.helper;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class HealthService implements HealthIndicator {

  private static final String DB_SERVICE = "Database service";

  public Boolean isHealthGood() {
    return true;
  }

  @Override
  public Health health() {
    if (isHealthGood()) {
      return Health
        .up()
        .withDetail(DB_SERVICE, "Database service is running...")
        .build();
    }
    return Health.down().withDetail(DB_SERVICE, "DB running down...").build();
  }
}
