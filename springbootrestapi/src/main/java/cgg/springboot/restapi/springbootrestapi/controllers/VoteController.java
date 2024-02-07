package cgg.springboot.restapi.springbootrestapi.controllers;

import cgg.springboot.restapi.springbootrestapi.exceptions.AgeNotValidException;
import cgg.springboot.restapi.springbootrestapi.services.VoterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vote")
public class VoteController {

  @Autowired
  private VoterService voterService;

  @PostMapping
  public ResponseEntity<?> vote(@RequestParam("age") int age) {
    if (age < 18) {
      throw new AgeNotValidException("age not valid");
    }
    voterService.vote(age);
    return ResponseEntity.ok("Voted.");
  }
}
