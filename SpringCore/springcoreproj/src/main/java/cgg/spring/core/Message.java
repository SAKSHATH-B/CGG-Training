package cgg.spring.core;

public class Message {

  private int messageId;
  private String message;

  public int getMessageId() {
    return messageId;
  }

  public void setMessageId(int messageId) {
    this.messageId = messageId;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public void init() {
    System.out.println("Bean's init() method.");
  }

  public void destroy() {
    System.out.println("Bean's destroy() method.");
  }

  @Override
  public String toString() {
    return "Message [messageId=" + messageId + ", message=" + message + "]";
  }
}
