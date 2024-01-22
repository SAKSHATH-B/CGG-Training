package cgg.spring.core;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStoppedEvent;

public class MsgContextStopEvent
  implements ApplicationListener<ContextStoppedEvent> {

  @Override
  public void onApplicationEvent(ContextStoppedEvent event) {
    System.out.println("ContextStoppedEvent recieved...");
    System.out.println(event.getSource());
    System.out.println("============================");
  }
}
