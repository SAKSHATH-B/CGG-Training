package cgg.spring.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MessageCT {

  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext(
      "message.xml"
    );
    // ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(
    //   "message.xml"
    // );
    // context.start();
    Message message = context.getBean("message", Message.class);
    System.out.println(message);
    // System.out.println("==========================");
    // context.stop();
    // context.close();
    // ((AbstractApplicationContext) context).close();

    // TicketVendingMachine bean = context.getBean(
    //   "ticketVendingMachine",
    //   TicketVendingMachine.class
    // );
    // Ticket ticket = bean.generateTicket();
    // System.out.println(ticket.printTicket());
  }
}
