package cgg.springcore.aop;

import org.springframework.stereotype.Component;

// @Component("payment")
public class PaymentServiceImpl implements PaymentService {

  @Override
  public void makePayment(int amount) {
    //payment code
    System.out.println(amount + " Amount Debited...");

    //processing logic
    System.out.println(amount + " Amount Credited...");
  }
}
