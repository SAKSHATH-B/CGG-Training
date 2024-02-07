package cgg.smartcontactmanager.smartcontactmanager.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Message {

  private String content;
  private String type;
}
