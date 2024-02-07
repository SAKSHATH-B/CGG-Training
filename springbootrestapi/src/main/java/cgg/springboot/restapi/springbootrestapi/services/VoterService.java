package cgg.springboot.restapi.springbootrestapi.services;

import org.springframework.stereotype.Service;

@Service
public class VoterService {

  public void vote(int age) {
    System.out.println("VOTED");
    //db logic...
  }
}
