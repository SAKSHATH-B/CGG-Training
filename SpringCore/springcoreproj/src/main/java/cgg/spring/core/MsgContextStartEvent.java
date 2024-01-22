package cgg.spring.core;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;

public class MsgContextStartEvent
  implements ApplicationListener<ContextStartedEvent> {

  @Override
  public void onApplicationEvent(ContextStartedEvent event) {
    System.out.println("ContextStartedEvent recieved...");
    System.out.println(event.getSource());
    System.out.println("============================");
  }
}
